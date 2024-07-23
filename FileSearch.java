import java.io.File;

public class FileSearch {

    public static void searchFiles(File directory, String extension) {
        if (!directory.isDirectory()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, extension);
                } else if (file.getName().endsWith(extension)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        File directory = new File("path/to/your/directory"); 
        String extension = ".txt"; 
        searchFiles(directory, extension);
    }
}
