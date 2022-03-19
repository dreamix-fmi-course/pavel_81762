package fileManagement.service;

import fileManagement.model.*;

import java.util.*;

public class FileManagementSystem {

    private Map<String, File> fileManagementSystem;

    public FileManagementSystem(){
        fileManagementSystem = new HashMap<>();
    }

    public void createFile(String name, String location, String ...arguments){

        File newFile = null;
        //check if the file needs to be of type ContentFile
        if(arguments[0] == "CONTENT"){
            //take the content
            String content = "";
            for (int i = 1; i < arguments.length; i++){
                content += arguments[i];
            }
            //check if the file should be of type MediaContentFile
            if(name.endsWith(".avi") || name.endsWith(".mp3")){
                newFile = new MediaContentFile(name, location, content);
            }
            //its a documentContentFile
            else{
                newFile = new ContentFile(name, location, content);
            }
        }else{
            newFile = new ExecutableFile(name, location, arguments);
        }

        String path = name;

        if(fileManagementSystem.get(path) == null || fileManagementSystem.get(path).isDeleted()){
            fileManagementSystem.put(path, newFile);
        }else {
            System.out.println("File does not exist or is deleted");
        }
    }

    public void readCommands(){
        Scanner sc = new Scanner(System.in);

        while(true){
            String command = sc.nextLine();
            String[] commandArguments = command.split(" ");
            File file = null;
            if(fileManagementSystem.get(commandArguments[1]) != null)
                file = fileManagementSystem.get(commandArguments[1]);

            switch (commandArguments[0]){
                case "MAKE": this.createFile(commandArguments[1], commandArguments[2], Arrays.copyOfRange(commandArguments, 2, commandArguments.length));break;
                case "MOVE": file.move(commandArguments[1]); break;
                case "MOD":  file.modify(commandArguments[2]); break;
                case "EXEC":  file.execute(); break;
                case "END": break;
                case "INFO":
                    System.out.println(file.getInfo());break;
                case "COPY": File copy = file.copy(commandArguments[2]); fileManagementSystem.put(copy.getName(), copy); break;
                case "DELETE": file.delete(); break;
                default:
                    System.out.println("Wrong command bro");
                    command = sc.nextLine();
            }
        }
    }
}
