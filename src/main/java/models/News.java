package models;

import java.util.Objects;

public class News {

    private String title;
    private String newsContent;
    private int id;
    private String writtenBy;
    private int departmentId;

    public News(String title, String newsContent, String writtenBy, int departmentId) {
        this.title = title;
        this.newsContent = newsContent;
        this.writtenBy = writtenBy;
        this.departmentId = departmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
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
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getDepartmentId() == news.getDepartmentId() &&
                Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getNewsContent(), news.getNewsContent()) &&
                Objects.equals(getWrittenBy(), news.getWrittenBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getNewsContent(), getWrittenBy(), getDepartmentId());
    }
}
