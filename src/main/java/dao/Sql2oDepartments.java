package dao;
import models.Departments;
import models.Users;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.ArrayList;

public class Sql2oDepartments implements DepartmentDao {

    private final Sql2o sql2o;

    public Sql2oDepartments(Sql2o sql2o){
        this.sql2o =sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments(name, description, numberOfEmployees) VALUES (:name, :description, :numberOfEmployees);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAll() {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM departments;";
            return con.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public void update(int id, String name, String description, int numberOfEmployees) {
    }

    @Override
    public void delete(int id) {
        try(Connection con = sql2o.open()){
            String sql = "DELETE FROM departments WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM departments;";
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Users> getAllUsersForDepartments(int departmentId) {
        List<Users> users = new ArrayList<>();
        String joinQuery = "SELECT usersId FROM departments_users WHERE departmentId = :departmentId;";
        try (Connection con = sql2o.open()){
            List<Integer> allUsersId = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);

            for (Integer userId: allUsersId){
                String sql = "SELECT * FROM users WHERE id = :userId;";
                users.add(con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(Users.class));
            }
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }
}
