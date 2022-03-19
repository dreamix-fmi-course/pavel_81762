package fileManagement.model;

import java.time.LocalDate;

public abstract class File {
    private String name;
    private String location;
    private LocalDate creationDate;
    private boolean isDeleted;

    public File(String name, String location){
        this.name = name;
        this.setLocation(location);
        this.creationDate = LocalDate.now();
        this.isDeleted = false;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void move(String newLocation){
        this.location = newLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void delete(){
        this.isDeleted = true;
    }

    public void setLocation(String newLocation) throws IllegalArgumentException {
        if (newLocation == null || !newLocation.matches("^/([\\w\\-.]+/?)*$")) {
            throw new IllegalArgumentException("Invalid path \"" + newLocation + "\"");
        }
        this.location = (newLocation.charAt(newLocation.length() - 1) == '/' ? newLocation : newLocation + '/');
    }

    public void execute(){
        System.out.println("Basic execute");
    }

    public void modify(String content){
        System.out.println("Basic modify");
    }

    public abstract File copy(String location);
    public abstract String getInfo();
}
