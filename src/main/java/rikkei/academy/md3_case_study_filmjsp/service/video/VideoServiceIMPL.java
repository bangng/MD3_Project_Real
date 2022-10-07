package rikkei.academy.md3_case_study_filmjsp.service.video;

import rikkei.academy.md3_case_study_filmjsp.cofig.ConnectMySQL;
import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.CategoryServiceIMPL;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.ICategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VideoServiceIMPL implements IVideoService{
    private ICategoryService categoryService = new CategoryServiceIMPL();

    private Connection connection = ConnectMySQL.getConnection();
    private final String CREATE_VIDEOS = "INSERT INTO video(videoName,dateByVideo,country) VALUES (?,?,?);";
    private final String INSERT_ID_VIDEO_ID_CATEGORY= "INSERT INTO video_categories(id_video,id_category) VALUES (?,?);";
    private final String FIND_ALL_VIDEOS = "SELECT * FROM video";
    private final String FIND_BY_ID_VIDEO = "SELECT videoName FROM video WHERE id=?;";
    private final String FIND_CATEGORIES_BY_VIDEO = "SELECT id_category FROM video_categories WHERE id_video=?;";
    private final String UPDATE_VIDEO_BY_ID = "UPDATE video SET videoName=?,dateByVideo=?,country=? WHERE id = ?;";
    private final String DELETE_VIDEO_BY_ID = "DELETE FROM video WHERE id = ?;";
    @Override
    public void save(Video videos) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_VIDEOS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,videos.getVideoName());
            preparedStatement.setString(2,videos.getDateByVideo());
            preparedStatement.setString(3,videos.getCountry());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int id_video = 0;
            while (resultSet.next()){
                id_video = resultSet.getInt(1);
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ID_VIDEO_ID_CATEGORY);
            Set<Categories> categoriesSet = videos.getCategoriesSet();
             List<Categories> categoriesList = new ArrayList<>(categoriesSet);


            for (int i = 0; i < categoriesList.size(); i++) {
                preparedStatement1.setInt(1,id_video);
                preparedStatement1.setInt(2,categoriesList.get(i).getId());
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
                String dateByVideo = resultSet.getString(3);
                String link = resultSet.getString(4);
                String country = resultSet.getString(5);
                videoList.add(new Video(id,videoName,dateByVideo,link));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videoList;
    }

    @Override
    public Video findById(int id) {

       Video video = null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_VIDEO);
            preparedStatement.setInt(1,id);
            PreparedStatement preparedStatement1 = connection.prepareStatement(FIND_CATEGORIES_BY_VIDEO);
            preparedStatement1.setInt(1,id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            int id_category = 0;
           Set<Categories> categoriesSet = new HashSet<>();
            while (resultSet.next()){
                id_category = resultSet.getInt("id_category");
                Categories categories  =categoryService.findById(id_category);
               categoriesSet.add(categories);
            }
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()){
                String videoName = resultSet1.getString("videoName");
                video = new Video(id,videoName,categoriesSet);
                connection.commit();
                return video;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateVideo(Video videos) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VIDEO_BY_ID);
            preparedStatement.setInt(4,videos.getId());
            preparedStatement.setString(1,videos.getVideoName());
            preparedStatement.setString(2,videos.getDateByVideo());
            preparedStatement.setString(3,videos.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VIDEO_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}