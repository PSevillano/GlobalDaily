package com.sevillano.globaldaily.Entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="News")
public class News {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name ="title")
    private String title;
    @Column(name ="complete_text")
    private String completeText;
    @Column(name ="link_img")
    private String linkImg;
    @Column(name ="country")
    private String country;
    @Column(name ="date_news")
    private String dateNews;
    @Column(name ="origin")
    private String origin;
    @Column(name ="newsType")
    private String newsType;

    public News() {
    }

    public News(int id, String title, String completeText, String linkImg, String country, String dateNews, String origin, String newsType) {
        this.id = id;
        this.title = title;
        this.completeText = completeText;
        this.linkImg = linkImg;
        this.country = country;
        this.dateNews = dateNews;
        this.origin = origin;
        this.newsType = newsType;
    }

    public String getNewsType() {
        return this.newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleteText() {
        return this.completeText;
    }

    public void setCompleteText(String completeText) {
        this.completeText = completeText;
    }

    public String getLinkImg() {
        return this.linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateNews() {
        return this.dateNews;
    }

    public void setDateNews(String dateNews) {
        this.dateNews = dateNews;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public News id(int id) {
        setId(id);
        return this;
    }

    public News title(String title) {
        setTitle(title);
        return this;
    }

    public News completeText(String completeText) {
        setCompleteText(completeText);
        return this;
    }

    public News linkImg(String linkImg) {
        setLinkImg(linkImg);
        return this;
    }

    public News country(String country) {
        setCountry(country);
        return this;
    }

    public News dateNews(String dateNews) {
        setDateNews(dateNews);
        return this;
    }

    public News origin(String origin) {
        setOrigin(origin);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof News)) {
            return false;
        }
        News news = (News) o;
        return id == news.id && Objects.equals(title, news.title) && Objects.equals(completeText, news.completeText) && Objects.equals(linkImg, news.linkImg) && Objects.equals(country, news.country) && Objects.equals(dateNews, news.dateNews) && Objects.equals(origin, news.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completeText, linkImg, country, dateNews, origin);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", completeText='" + getCompleteText() + "'" +
            ", linkImg='" + getLinkImg() + "'" +
            ", country='" + getCountry() + "'" +
            ", dateNews='" + getDateNews() + "'" +
            ", origin='" + getOrigin() + "'" +
            "}";
    }
    

}
