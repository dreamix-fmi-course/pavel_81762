package fileManagement;

import fileManagement.model.File;
import fileManagement.service.FileManagementSystem;

public class Main {
    public static void main(String[] args) {
        FileManagementSystem fileManagementSystem = new FileManagementSystem();
        fileManagementSystem.readCommands();

    }
}
