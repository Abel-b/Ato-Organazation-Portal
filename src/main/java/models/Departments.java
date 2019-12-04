package models;

import java.util.Objects;

public class Departments {

    private String userName;
    private String description;
    private int numberOfEmployees;
    private int id;

    public Departments(String userName, String description, int numberOfEmployees) {
        this.userName = userName;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        Departments that = (Departments) o;
        return getNumberOfEmployees() == that.getNumberOfEmployees() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getNumberOfEmployees());
    }
}
