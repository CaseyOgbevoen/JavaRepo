package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public ArrayList readAll() {
        ArrayList totalFile = new ArrayList();

        try {
            Scanner myScanner = new Scanner(this.file);

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

    public ArrayList readExamine() {
        ArrayList totalFile = new ArrayList();

        String word;
        int noOfSlangWords = 0;
        int totalNoOfWords = 0;
        int totalNoOfChars = 0;
        int shortWords = 0;
        int longWords = 0;
        int avgWordLength = 0;
        //boolean formal = false;

        try {
            Scanner myScanner = new Scanner(this.file);

            while (myScanner.hasNext()) {
                word = myScanner.next();
                totalFile.add(word);

                //count characters and word
                totalNoOfWords++;
                totalNoOfChars = totalNoOfChars + word.length();

                //check if word is in slang file
                Slang checkSlang = new Slang(word);
                checkSlang.countString(word, noOfSlangWords);

                //check if long word
                if(word.length() > 6) {
                    longWords = longWords + 1;
                }
                else {
                    shortWords = shortWords + 1;
                }
            }

            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //get average word length
        avgWordLength = totalNoOfChars/totalNoOfWords;

        //if there are more long words or short words
        if(shortWords > longWords) {
            //formal = false;
            System.out.println("\nInformal Language");
        }
        else {
            //formal = true;
            System.out.println("\nFormal Language");
        }

        System.out.println("Total no of Words: " + totalNoOfWords);
        System.out.println("Total no of Characters: " + totalNoOfChars);
        System.out.println("Total no of Short Words: " + shortWords);
        System.out.println("Total no of Long Words: " + longWords);
        System.out.println("Average Word Length: " + avgWordLength);

        return totalFile;
    }
}
