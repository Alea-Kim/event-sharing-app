package inducesmile.com.parsejsoninandroid;

public class ItemObject {

    private String title;
    private String id;
    private String description;
    private String picture;

    public ItemObject(String title, String id, String description, String picture) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.picture = picture;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getId() { return id; }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {  this.description = description; }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {   this.picture = picture; }
}
