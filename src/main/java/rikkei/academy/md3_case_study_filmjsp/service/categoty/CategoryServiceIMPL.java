package rikkei.academy.md3_case_study_filmjsp.service.categoty;

import rikkei.academy.md3_case_study_filmjsp.cofig.ConnectMySQL;
import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {

    private Connection connection = ConnectMySQL.getConnection();
    private final String CREATE_CATEGORY = "INSERT INTO categories(category) VALUES (?);";
    private final String SHOW_CATEGORY = "SELECT * FROM categories";
    private final String FIND_BY_ID_CATE = "SELECT category FROM categories WHERE id = ?;";
    private final String UPDATE_CATE_BY_ID = "UPDATE categories SET category =? WHERE id = ?;";
    private final String DELETE_CATE_BY_ID = "DELETE FROM categories WHERE id = ?;";
    @Override
    public void save(Categories categories) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CATEGORY);

            preparedStatement.setString(1,categories.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categoriesList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String category = resultSet.getString(2);
                categoriesList.add(new Categories(id,category));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoriesList;
    }

    @Override
    public Categories findById(int id) {
        Categories categories = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_CATE);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                String category = resultSet.getString("category");
                categories = new Categories(category);
                return categories;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateCategory(Categories categories) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATE_BY_ID);
            preparedStatement.setInt(2,categories.getId());

            preparedStatement.setString(1,categories.getCategory());
            preparedStatement.executeUpdate();

   } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}