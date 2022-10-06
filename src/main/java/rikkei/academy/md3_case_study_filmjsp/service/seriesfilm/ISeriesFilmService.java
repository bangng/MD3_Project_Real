package rikkei.academy.md3_case_study_filmjsp.service.seriesfilm;

import rikkei.academy.md3_case_study_filmjsp.model.seriesfilm.SeriesFilm;
import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.IGenericService;

import java.util.List;

public interface ISeriesFilmService extends IGenericService<SeriesFilm> {
    List<SeriesFilm> findAll();

   SeriesFilm findById(int id);
    void updateVideo(SeriesFilm seriesFilm);
    void remove(int id);
}
