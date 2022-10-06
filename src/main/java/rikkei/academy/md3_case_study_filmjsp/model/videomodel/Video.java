package rikkei.academy.md3_case_study_filmjsp.model.videomodel;

import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;

import java.util.HashSet;
import java.util.Set;

public class Video {
    private int id;
    private String videoName;
    private String dateByVideo;
    private String linkVideo;
    private String country;
    private Set<Categories> categoriesSet = new HashSet<>();

    public Video(String videoName, String dateByVideo, String country, Set<Categories> categoriesSet) {
        this.videoName = videoName;
        this.dateByVideo = dateByVideo;
        this.country = country;
        this.categoriesSet = categoriesSet;
    }
    public Video(int id, String videoName, String dateByVideo, String country) {
        this.id = id;
        this.videoName = videoName;
        this.dateByVideo = dateByVideo;
        this.country = country;
    }


    public Video(int id, String videoName, String dateByVideo, String linkVideo,String country) {
        this.id = id;
        this.videoName = videoName;
        this.dateByVideo = dateByVideo;
        this.linkVideo = linkVideo;
        this.country = country;
    }

    public Video(int id, String videoName, Set<Categories> categoriesSet) {
        this.id = id;
        this.videoName = videoName;
//        this.dateByVideo = dateByVideo;
//        this.linkVideo = linkVideo;
//        this.country = country;
        this.categoriesSet = categoriesSet;
    }

    public Set<Categories> getCategoriesSet() {
        return categoriesSet;
    }

    public void setCategoriesSet(Set<Categories> categoriesSet) {
        this.categoriesSet = categoriesSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getDateByVideo() {
        return dateByVideo;
    }

    public void setDateByVideo(String dateByVideo) {
        this.dateByVideo = dateByVideo;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", dateByVideo=" + dateByVideo +
                ", linkVideo='" + linkVideo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
