package dao;

import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentsTest {
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
    public void teardown() throws Exception{
        newsDao.clearAll();
        departmentsDao.clearAll();
        conn.close();
    }

    @Test
    public void addingDepartnmentsSetsId() throws Exception {
        Departments departments = newDepartments();
        assertEquals(1, departments.getId());
    }

    @Test
    public void getAll_ReturnsAllEntriesInDatabase_Departments() {
        Departments  departments = newDepartments();
        Departments departments1 = newDepartments();
        assertTrue(departmentsDao.getAll().contains(departments));
        assertTrue(departmentsDao.getAll().contains(departments1));
    }


    @Test
    public void clearsAllEntriesInDb() {
        Departments departments = newDepartments();
        Departments departments1 = newDepartments();
        departmentsDao.clearAll();
        assertEquals(0, departmentsDao.getAll().size());
    }

    //helpers

    public Departments newDepartments(){
        Departments departments = new Departments("Amazing Dept","The best department", 9);
        departmentsDao.add(departments);
        return departments;
    }
}