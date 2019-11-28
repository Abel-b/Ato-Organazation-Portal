package models;

import java.util.Objects;

public class Users {

    private int id;
    private String title;
    private String userName;
    private String userRole;
    private int departmentId;

    public Users(String title, String userName, String userRole, int departmentId) {
        this.title = title;
        this.userName = userName;
        this.userRole = userRole;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getDepartmentId() == users.getDepartmentId() &&
                Objects.equals(getTitle(), users.getTitle()) &&
                Objects.equals(getUserName(), users.getUserName()) &&
                Objects.equals(getUserRole(), users.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getUserName(), getUserRole(), getDepartmentId());
    }
}
