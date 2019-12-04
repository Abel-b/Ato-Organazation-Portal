package dao;

import models.Departments;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsTest {


    private Connection conn;
    private Sql2oNews newsDao;
    private Sql2oDepartments departmentsDao;



    @Before
    public void setUp() throws Exception {
        String connectionString =  "jdbc:postgresql://localhost:5432/ato-org_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "berhane1234");
        newsDao = new Sql2oNews(sql2o);
        departmentsDao = new Sql2oDepartments(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingNewsSetsId() throws Exception {
        News  testNews  = setUpNews();
        assertEquals(1, testNews.getId());
    }

    @Test
    public void getALL_returnsAllNewsObjects() throws Exception{
        News testNews = setUpNews();
        News newsTwo = setUpNews();
        assertEquals(2, newsDao.getAll().size());
    }

    @Test
    public void getAllReviewsByDepartments() throws Exception {
        Departments departments = setUpDepartment();
        Departments departments2 = setUpDepartment();
        Departments lastDepartment = setUpDepartment();
        News testNews = setUpNewsForDepartment(departments);
        News testNews2 = setUpNewsForDepartment(departments2);
        News testNewsFinal = setUpNewsForDepartment(lastDepartment);
        assertEquals(1, newsDao.getAllNewsByDepartment(departments.getId()).size());

    }


    @Test
    public void clearAll() throws Exception {
        News testNews = setUpNews();
        News otherNews  = setUpNews();
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }


    // helpers

    public News setUpNews(){
        News news =  new News("Breaking News", "This news is currently breaking","dreamer", 1);
        newsDao.add(news);
        return news;

    }
    public Departments setUpDepartment(){
        Departments departments = new Departments("Department1", "This is the best department", 4);
        departmentsDao.add(departments);
        return departments;
    }

    public News setUpNewsForDepartment(Departments departments){
        News news = new News("Broken News", "Too late, already broken", "dreamer", departments.getId());
        System.out.println(departments.getId());
        newsDao.add(news);
        return news;

    }
}