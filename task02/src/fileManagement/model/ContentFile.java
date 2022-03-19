package fileManagement.model;

import java.time.LocalDate;

public class ContentFile extends File{

    private String content;
    private LocalDate lastModification;

    public ContentFile(String name, String location, String content){
        super(name, location);
        this.lastModification = LocalDate.now();
    }

    public String getContent() {
        return content;
    }

    public LocalDate getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDate lastExecution) {
        this.lastModification = lastExecution;
    }

    @Override
    public File copy(String location) {
        File copy = this;
        copy.setLocation(location);
        return copy;
    }

    public void modify(String content) {
        this.lastModification = LocalDate.now();
        this.content = content;
    }

    @Override
    public String getInfo() {

        String deleted = this.isDeleted() ? "" : "[[DELETED]]";

        return "Name: " +  this.getName() + deleted + "\n" +
                "Creation date: " + this.getCreationDate() + "\n" +
                "Last modification date: " + this.getLastModification() + "\n";
     }
}
