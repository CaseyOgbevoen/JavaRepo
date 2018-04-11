package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    String fileName;
    File file;

    public FileReader(String fileName) {

        this.fileName = fileName;
    }

    public void openFile() {

        this.file = new File(this.fileName);

    }
    public ArrayList readAll() {
        ArrayList totalFile = new ArrayList();

        try {
            Scanner myScanner = new Scanner(this.file);
            myScanner.useDelimiter(" ");

            while (myScanner.hasNext()) {
                String word = myScanner.next();

                totalFile.add(word);

            }

            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return totalFile;
    }
}
