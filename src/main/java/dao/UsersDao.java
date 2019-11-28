package dao;

import models.Users;
import models.Departments;

import java.util.List;

public interface UsersDao {

    void add(Users users);

    List<Users> getAll();

    void delete(int id);

    void clearAll();

    List<Users> getAllUsersByDepartment(int departmentId);

}
