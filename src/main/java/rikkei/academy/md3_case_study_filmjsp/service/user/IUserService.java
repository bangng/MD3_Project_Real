package rikkei.academy.md3_case_study_filmjsp.service.user;

import rikkei.academy.md3_case_study_filmjsp.model.usermodel.User;
import rikkei.academy.md3_case_study_filmjsp.service.IGenericService;

import java.sql.SQLException;

public interface IUserService extends IGenericService<User> {
    boolean existedByUsername(String username);
    boolean existedByEmail(String email);
    User findById(int id);
    User findByUsernameAndPassword(String username, String password);
    void changeAvatar(int id,String avatar);
    void update(User user)throws SQLException;

    void createVideo( String linkVideo);
}
