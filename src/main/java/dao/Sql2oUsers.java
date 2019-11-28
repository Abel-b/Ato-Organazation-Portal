package dao;

import models.Users;
import models.Departments;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsers implements UsersDao {

    private final Sql2o sql2o;

    public Sql2oUsers(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users users) {
        try(Connection con = sql2o.open()){
            String sql = "INSERT INTO users(title, userName, userRole, departmentId) VALUES (:title, :userName, :userRole, :departmentId);";
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Users> getAll() {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM users;";
            return con.createQuery(sql)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public void delete(int id) {
        try(Connection con = sql2o.open()){
            String sql = "DELETE FROM users WHERE id = :id;";
            con.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM users;";
            con.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Users> getAllUsersByDepartment(int departmentId) {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM users WHERE departmentId = :departmentId;";
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Users.class);
        }
    }
}
