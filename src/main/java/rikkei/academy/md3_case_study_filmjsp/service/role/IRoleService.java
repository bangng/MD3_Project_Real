package rikkei.academy.md3_case_study_filmjsp.service.role;

import rikkei.academy.md3_case_study_filmjsp.model.usermodel.Role;
import rikkei.academy.md3_case_study_filmjsp.model.usermodel.RoleName;

public interface IRoleService {
    Role findByName(RoleName name);
    Role findById(int id);
}
