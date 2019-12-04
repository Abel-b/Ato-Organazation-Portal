package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void UserObjectInstantiatesCorrectly_true() {
        Users newUser = newUsers();
        assertTrue(newUser instanceof Users);
    }


    @Test
    public void getName_returnsCorrectName_String() {
        Users newUser = newUsers();
        Users users = newUser;
        assertEquals(newUser.getUserName(), users.getUserName());
    }


    @Test
    public void getRole_returnsCorrectRole_true() {
        Users users = newUsers();
        Users user = newUsers();
        assertEquals(user.getUserRole(), users.getUserRole());
    }

    @Test
    public void getDepartmentId() {
        Users newUser = newUsers();
        Users user = newUsers();
        assertEquals(newUser.getDepartmentId(), newUser.getDepartmentId());
    }

    @Test
    public void testEquals_defaultMethodIsOverriden() {
        Users newUser = newUsers();
        Users users = newUsers();
        assertEquals(newUser,users);
    }

    //helpers

    public Users newUsers(){
        return new Users("Mr.", "Brian", "CEO", 7);
    }
}