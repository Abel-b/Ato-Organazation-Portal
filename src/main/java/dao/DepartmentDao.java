package dao;
import models.Departments;
import models.Users;

import java.util.List;

public interface DepartmentDao {

    void add (Departments departments);

    List<Departments> getAll();

    void update(int id, String name, String description, int numberOfEmployees);

    void delete(int id);

    void clearAll();

    List<Users> getAllUsersForDepartments(int departmentId);
}
