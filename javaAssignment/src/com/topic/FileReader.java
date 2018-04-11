package com.topic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        //var
        String word;
        ArrayList totalFile = new ArrayList();

        //scanner and array
        try {
            Scanner myScanner = new Scanner(this.file);
            myScanner.useDelimiter(" "); //delimiter is one space

            while(myScanner.hasNext()) {
                word = myScanner.next();
                totalFile.add(word);

                System.out.println(myScanner.next());

            }

            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return totalFile;
    }

}
