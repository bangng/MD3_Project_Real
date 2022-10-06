package rikkei.academy.md3_case_study_filmjsp.service.seriesfilm;

import rikkei.academy.md3_case_study_filmjsp.cofig.ConnectMySQL;
import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.model.seriesfilm.SeriesFilm;
import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.video.IVideoService;
import rikkei.academy.md3_case_study_filmjsp.service.video.VideoServiceIMPL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeriesFilmServiceIMPL implements ISeriesFilmService{
    private IVideoService videoService = new VideoServiceIMPL();
    private Connection connection = ConnectMySQL.getConnection();
    private static final String CREATE_SERIES = "INSERT INTO seriesfilm(seriesName) VALUES (?);";
    private static final String FIND_ALL_SERIES_FILM = "SELECT * FROM seriesfilm";
    private static final String FIND_BY_ID_SERIES = "SELECT seriesName FROM seriesfilm WHERE id = ?;";
    private static final String UPDATE_SERIES_BY_ID = "UPDATE seriesfilm SET seriesName =? WHERE id = ?;";
    private static final String DELETE_SERIES_FILM = "DELETE FROM seriesfilm WHERE id = ?;";
    @Override
    public void save(SeriesFilm seriesFilm) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SERIES);
            preparedStatement.setString(1,seriesFilm.getSeriesName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<SeriesFilm> findAll() {
        List<SeriesFilm> seriesFilmList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SERIES_FILM);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String seriesFilm = resultSet.getString(2);
                seriesFilmList.add(new SeriesFilm(id,seriesFilm));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return seriesFilmList;
    }

    @Override
    public SeriesFilm findById(int id) {
        SeriesFilm seriesFilm = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SERIES);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                String seriesName = resultSet.getString("seriesName");
                seriesFilm = new SeriesFilm(seriesName);
                return seriesFilm;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public void updateVideo(SeriesFilm seriesFilm) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERIES_BY_ID);
            preparedStatement.setInt(2,seriesFilm.getId());

            preparedStatement.setString(1,seriesFilm.getSeriesName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERIES_FILM);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
