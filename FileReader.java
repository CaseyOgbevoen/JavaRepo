package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
    private String fileName;
    private File file;
    private PrintWriter Input;

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
        int avgWordLength;

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
                noOfSlangWords = noOfSlangWords + checkSlang.countString(word);
                System.out.println("No of Slang Words: " + noOfSlangWords);

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

        //******figure out toSting method***********
        System.out.println("Total no of Words: " + totalNoOfWords);
        System.out.println("Total no of Characters: " + totalNoOfChars);
        System.out.println("Total no of Short Words: " + shortWords);
        System.out.println("Total no of Long Words: " + longWords);
        System.out.println("Average Word Length: " + avgWordLength);

        return totalFile;
    }

    // get hold of a Print writer object
    void appendToFile(String slangWord)
    {
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter out;
        try
        {
            fw = new FileWriter("slang.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(slangWord);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("run time error " + e.getMessage());
        }
    }
}
