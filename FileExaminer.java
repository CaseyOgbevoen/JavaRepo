package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileExaminer {
    String fileName;
    File file;

    static int totalNoOfWords = 0;
    static int totalNoOfChars = 0;
    static int shortWords = 0;
    static int longWords = 0;
    static int avgWordLength = 0;
    static boolean Formal = false;

    public FileExaminer(String fileName) {

        this.fileName = fileName;
    }

    public void openFile() {

        this.file = new File(this.fileName);

    }
    public String readAll() {
        String totalFile = "";// = new ArrayList();

        try {
            Scanner myScanner = new Scanner(this.file);
            myScanner.useDelimiter(" ");

            while (myScanner.hasNext()) {
                String word = myScanner.next();

                //remove all invalid characters
                word = word.replaceAll("'*,.<>|/:;-+_", "");

                //check if long word
                if(word.length() > 6) {
                    longWords = longWords + 1;
                }
                else {
                    shortWords = shortWords + 1;
                }

                //count characters and word
                totalNoOfWords = totalNoOfWords + 1;
                totalNoOfChars = totalNoOfChars + word.length();

                totalFile.concat(word);

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
            Formal = false;
        }
        else {
            Formal = true;
        }

        System.out.println("Total no of Words: " + totalNoOfWords);
        System.out.println("Total no of Characters: " + totalNoOfChars);
        System.out.println("Total no of Short Words: " + shortWords);
        System.out.println("Total no of Long Words: " + longWords);
        System.out.println("Average Word Length: " + avgWordLength);
        if(Formal == true){
            System.out.println("Formal Language");
        }
        else {
            System.out.println("Informal Language");
        }

        return totalFile;
    }
}