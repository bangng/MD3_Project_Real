package rikkei.academy.md3_case_study_filmjsp.service.categoty;

import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Categories> {
    List<Categories> findAll();

    Categories findById(int id);
    void updateCategory(Categories categories);
    void remove(int id);
}
