package rikkei.academy.md3_case_study_filmjsp.model.seriesfilm;

public class SeriesFilm {
    private int id;
    private String seriesName;

    public SeriesFilm(String seriesName) {
        this.seriesName = seriesName;
    }

    public SeriesFilm(int id, String seriesName) {
        this.id = id;
        this.seriesName = seriesName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    @Override
    public String toString() {
        return "SeriesFilm{" +
                "id=" + id +
                ", seriesName='" + seriesName + '\'' +
                '}';
    }
}
