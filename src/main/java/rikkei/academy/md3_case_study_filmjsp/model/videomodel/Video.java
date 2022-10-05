package rikkei.academy.md3_case_study_filmjsp.model.videomodel;

import java.time.LocalDate;

public class Video {
    private int id;
    private String videoName;
    private LocalDate dateByVideo;
    private String linkVideo;
    private String country;

    public Video() {
    }

    public Video(int id, String videoName, LocalDate dateByVideo, String linkVideo, String country) {
        this.id = id;
        this.videoName = videoName;
        this.dateByVideo = dateByVideo;
        this.linkVideo = linkVideo;
        this.country = country;
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

    public LocalDate getDateByVideo() {
        return dateByVideo;
    }

    public void setDateByVideo(LocalDate dateByVideo) {
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
