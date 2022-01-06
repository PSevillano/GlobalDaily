package com.sevillano.globaldaily.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NewsPaper")
public class NewsPaper {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name ="Name")
    private String name;
    @Column(name ="Tag")
    private String tag;
    @Column(name ="linkToDownload")
    private String linkToDownload;
    @Column(name ="country")
    private String country;



    public NewsPaper() {
    }

    public NewsPaper(int id, String name, String tag, String linkToDownload, String country) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.linkToDownload = linkToDownload;
        this.country = country;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLinkToDownload() {
        return this.linkToDownload;
    }

    public void setLinkToDownload(String linkToDownload) {
        this.linkToDownload = linkToDownload;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public NewsPaper id(int id) {
        setId(id);
        return this;
    }

    public NewsPaper name(String name) {
        setName(name);
        return this;
    }

    public NewsPaper tag(String tag) {
        setTag(tag);
        return this;
    }

    public NewsPaper linkToDownload(String linkToDownload) {
        setLinkToDownload(linkToDownload);
        return this;
    }

    public NewsPaper country(String country) {
        setCountry(country);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NewsPaper)) {
            return false;
        }
        NewsPaper newsPaper = (NewsPaper) o;
        return id == newsPaper.id && Objects.equals(name, newsPaper.name) && Objects.equals(tag, newsPaper.tag) && Objects.equals(linkToDownload, newsPaper.linkToDownload) && Objects.equals(country, newsPaper.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tag, linkToDownload, country);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", tag='" + getTag() + "'" +
            ", linkToDownload='" + getLinkToDownload() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }


    
}
