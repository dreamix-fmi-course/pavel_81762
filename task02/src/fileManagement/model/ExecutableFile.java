package fileManagement.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecutableFile extends File{
    private List<String> requiredResources;
    private LocalDate lastExecutionDate;

    public ExecutableFile(String name, String location, String ...requiredResources){
        super(name, location);
        this.lastExecutionDate = LocalDate.now();
        this.requiredResources = new ArrayList<>(Arrays.stream(requiredResources).toList());
    }

    @Override
    public File copy(String location) {
        File copy = this;
        copy.setLocation(location);
        return copy;
    }

    @Override
    public String getInfo() {
        String deleted = !this.isDeleted() ? "" : "[[DELETED]]";
        String sources = "Required sources:\n";
        for (String source: requiredResources){
            sources += requiredResources + "\n";
        }


        return "Name: " + this.getName() + deleted + "\n" +
                "Creation date: " + this.getCreationDate() + "\n" +
                "Last modification date: " + lastExecutionDate + "\n" + sources;
    }

    public void execute() {
        System.out.println("Executing [[ " + this.getName() + " ]]");
        this.lastExecutionDate = LocalDate.now();
    }

}
