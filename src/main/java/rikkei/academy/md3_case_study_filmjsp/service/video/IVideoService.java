package rikkei.academy.md3_case_study_filmjsp.service.video;

import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.IGenericService;

import java.util.List;

public interface IVideoService extends IGenericService<Video> {
    List<Video> findAll();

    Video findById(int id);
    void updateCategory(Video videos);
    void remove(int id);
}
