package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {


    @Test
    public void departmentNewsInstantiatesCorrectly() {
        Departments departments = newDepartment();
        assertTrue(departments instanceof Departments);
    }

    @Test
    public void getName() {
        Departments departments = newDepartment();
        assertTrue("Accounting".equals(departments.getName()));
    }

    @Test
    public void getDescription() {
        Departments departments = newDepartment();
        assertTrue("The best department".equals(departments.getDescription()));
    }

    @Test
    public void getNumberOfEmployees() {
        Departments departments = newDepartment();
        assertTrue(7 == departments.getNumberOfEmployees());
    }


    public Departments newDepartment(){
        return new Departments("Accounting", "The best department", 7);
    }
}