package rikkei.academy.md3_case_study_filmjsp.model.categorymodel;

public class Categories {
    private int id;
    private String category;

    public Categories(String category) {
        this.category = category;
    }

    public Categories(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
