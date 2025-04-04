package due.giuaky221121514233.day3.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    private String id;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("primaryTitle")
    private String primaryTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("primaryImage")
    private String primaryImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return releaseDate;
    }

    public void setDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return primaryTitle;
    }

    public void setTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getContent() {
        return description;
    }

    public void setContent(String description) {
        this.description = description;
    }

    public String getImage() {
        return primaryImage;
    }

    public void setImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }
}
