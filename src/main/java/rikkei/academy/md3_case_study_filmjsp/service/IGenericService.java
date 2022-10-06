package rikkei.academy.md3_case_study_filmjsp.service;

import java.sql.SQLException;

public interface IGenericService<T> {
    void save(T t) throws SQLException;
}
