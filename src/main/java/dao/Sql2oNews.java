package dao;

import models.Departments;
import models.News;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNews implements NewsDao {

    private final Sql2o sql2o;

    public Sql2oNews(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        try(Connection con = sql2o.open()){
            String sql = "INSERT INTO news(title, newscontent, writtenby, department) VALUES (:title, :newsContent, :writtenBy, :departmentId);";
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM news;";
            return con.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void update(int id, String title, String newsContent, String writtenBy, int departmentId) {

    }

    @Override
    public void delete(int id) {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM news WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        try(Connection con = sql2o.open()){
            String sql = "DELETE FROM news;";
            con.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAllNewsByDepartment(int department) {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM news WHERE department = :department;";
            return con.createQuery(sql)
                    .addParameter("department", department)
                    .executeAndFetch(News.class);
        }
    }
}
