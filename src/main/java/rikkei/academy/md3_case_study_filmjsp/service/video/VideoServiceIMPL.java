package rikkei.academy.md3_case_study_filmjsp.service.video;

import rikkei.academy.md3_case_study_filmjsp.cofig.ConnectMySQL;
import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.CategoryServiceIMPL;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.ICategoryService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideoServiceIMPL implements IVideoService{
    private  int noOfRecords;
    Statement stmt;
    private ICategoryService categoryService = new CategoryServiceIMPL();
    private Connection connection = ConnectMySQL.getConnection();
    private final String CREATE_VIDEOS = "INSERT INTO video(videoName,country) VALUES (?,?);";
    private final String INSERT_ID_VIDEO_ID_CATEGORY= "INSERT INTO video_categories(id_video,id_category) VALUES (?,?);";
    private final String FIND_ALL_VIDEOS = "SELECT * FROM video";
    @Override
    public void save(Video videos) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_VIDEOS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,videos.getVideoName());

            preparedStatement.setString(2,videos.getCountry());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int id_video = 0;
            while (resultSet.next()){
                id_video = resultSet.getInt(1);
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ID_VIDEO_ID_CATEGORY);
            List<Categories> categoriesList = categoryService.findAll();
            List<Integer> categoryId = new ArrayList<>();
            for (int i = 0; i < categoriesList.size(); i++) {
                categoryId.add(categoriesList.get(i).getId());

            }
            for (int i = 0; i < categoryId.size(); i++) {
                preparedStatement1.setInt(1,id_video);
                preparedStatement1.setInt(2,categoryId.get(i));
                preparedStatement1.executeUpdate();
            }
            connection.commit();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Video> findAll() {
        List<Video> videoList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_VIDEOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String videoName = resultSet.getString(2);
                LocalDate dateByVideo = LocalDate.parse(resultSet.getString(3));
                String link = resultSet.getString(4);
                String country = resultSet.getString(5);
                videoList.add(new Video(id,videoName,dateByVideo,link,country));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videoList;
    }

    @Override
    public Video findById(int id) {
        return null;
    }

    @Override
    public void updateCategory(Video videos) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Video> viewAll(int offset, int noOfRecords) {
        String query = "select SQL_CALC_FOUND_ROWS * from video limit "
                + offset + ", " + noOfRecords;
        List<Video> list = new ArrayList<Video>();
        Video video = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                video = new Video();
                video.setVideoName(rs.getString("videoname"));
                video.setDateByVideo(LocalDate.parse(rs.getString("dateByvideo")));
                video.setLinkVideo(rs.getString("linkVideo"));
                video.setCountry(rs.getString("country"));
                list.add(video);
            }
            rs.close();

            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }
}