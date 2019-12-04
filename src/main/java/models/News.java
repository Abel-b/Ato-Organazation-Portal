package models;

import java.util.Objects;

public class News {
    private int id;
    private String title;
    private String newsContent;
    private String writtenBy;
    private int department;

    public News(String title, String newsContent, String writtenBy, int department) {
        this.title = title;
        this.newsContent = newsContent;
        this.writtenBy = writtenBy;
        this.department = department;
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
        return department;
    }

    public void setDepartmentId(int department) {
        this.department = department;
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
