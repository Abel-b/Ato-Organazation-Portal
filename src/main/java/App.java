import com.google.gson.Gson;
import dao.Sql2oDepartments;
import dao.Sql2oNews;
import dao.Sql2oUsers;
import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        Sql2oDepartments departmentDao;
        Sql2oUsers usersDao;
        Sql2oNews newsDao;
        Connection con;
        Gson gson = new Gson();


        String connectionString = "jdbc:postgresql://localhost:5432/ato_org";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "berhane1234");

        departmentDao = new Sql2oDepartments(sql2o);
        usersDao = new Sql2oUsers(sql2o);
        newsDao = new Sql2oNews(sql2o);

        get(("/"), (request, response) -> {
            response.redirect("/users");
            return null;
        });

        post ("departments/new", "application/json", (request, response) -> {
            Departments department = gson.fromJson(request.body(), Departments.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return  gson.toJson(department);
        });
        get("departments", "application/json", (req, res) -> {
            res.type("application/json");
            System.out.println(departmentDao.getAll());
            if(departmentDao.getAll().size() > 0){
                return gson.toJson(
                        departmentDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently available in the database.\"}";
            }
        });

        post("departments/:departmentId/news/new", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartmentId(departmentId);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return  gson.toJson(news);
        });

        get("news","application/json", (req, res)->{
            res.type("application/json");
            System.out.println(newsDao.getAll().size());
            if(newsDao.getAll().size() > 0){
                return gson.toJson(
                        newsDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but your request is currently unavailable in the database.\"}";
            }
        });

        get("departments/:departmentId/news", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            res.type("application/json");
            if(newsDao.getAllNewsByDepartment(departmentId).size() > 0){
                return gson.toJson(
                        newsDao.getAllNewsByDepartment(departmentId));
            }
            else {
                return "{\"message\":\"I'm sorry, but your request is currently unavailable in the database.\"}";
            }
        });

        get("departments/:departmentId/users", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            res.type("application/json");
            if(usersDao.getAllUsersByDepartment(departmentId).size() > 0){
                return gson.toJson(
                        usersDao.getAllUsersByDepartment(departmentId));
            }
            else {
                return "{\"message\":\"I'm sorry, but your request is currently unavailable in the database.\"}";
            }
        });
        post("users/new", "application/json", (req, res)->{
            Users newuser = gson.fromJson(req.body(), Users.class);
            usersDao.add(newuser);
            res.status(201);
            res.type("application/json");
            return  gson.toJson(newuser);
        });

        post("news/new", "application/json", (req, res)->{
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return  gson.toJson(news);
        });


        get("users", "application/json", (req, res)->{
            res.type("application/json");
            if(usersDao.getAll().size() > 0){
                return gson.toJson(
                        usersDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but your request is currently unavailable in the database.\"}";
            }
        });

        post("departments/:departmentId/users/new", "application/json", (req, res) ->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Users newUser = gson.fromJson(req.body(), Users.class);
            newUser.setDepartmentId(departmentId);
            usersDao.add(newUser);
            res.status(201);
            res.type("application/json");
            return gson.toJson(newUser);
        });

        after((req, res) ->{
            res.type("application/json");
        });


    }
}