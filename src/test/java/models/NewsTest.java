package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public void NewsObjectsInstantiatesCorrectly_true() {
        News news = newNews();
        assertTrue(news instanceof News);
    }

    @Test
    public void getDepartmentId_GetsCorrectDepartmentId() {
        News news = newNews();
        News news2 = newNews();
        assertEquals(news.getDepartmentId(), news2.getDepartmentId());
    }



    @Test
    public void testEquals_testObjectsAreEqual_True() {
        News news = newNews();
        News news1 = newNews();
        assertTrue(news.equals(news1));
    }

    @Test
    public void getTitle_String() {
        News news = newNews();
        News news1 = newNews();
        assertTrue(news.getTitle().equals(news1.getTitle()));
    }



    @Test
    public void getNewsContent_retrunsCorrectNewsContent_true() {
        News news = newNews();
        News news1 = newNews();
        assertTrue(news.getNewsContent().equals(news1.getNewsContent()));
    }


    public News newNews(){
        return  new News("Breaking News", "This is the past", "dre", 1);
    }
}