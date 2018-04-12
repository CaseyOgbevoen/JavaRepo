package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String fileName;
    private File file;

    public FileReader(String fileName) {

        this.fileName = fileName;
    }

    public void openFile() {

        this.file = new File(this.fileName);

    }
    public String readAll() {
        String totalFile = "";

        try {
            Scanner myScanner = new Scanner(this.file);
            myScanner.useDelimiter(" ");

            while (myScanner.hasNext()) {
                String word = myScanner.next();
                totalFile = totalFile.concat(word);

            }

            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return totalFile;
    }
}
