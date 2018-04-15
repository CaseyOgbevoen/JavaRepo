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
        float avgWordLength;

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

        //decide if file is formal or informal
        //more long words than short AND an average word length of greater or equal to 5.1 (general average word length)
        //OR slang words make up less than 10% of the document
        if((longWords > shortWords && avgWordLength >= 5.0) || (noOfSlangWords/totalNoOfWords)*(100) <= 10 ) {
            System.out.println("\nFormal Language\n");
        }
        else {
            System.out.println("\nInformal Language\n");
        }

        //******figure out toSting method***********
        System.out.println("Total no of Words: " + totalNoOfWords);
        System.out.println("Total no of Characters: " + totalNoOfChars);
        System.out.println("Total no of Short Words: " + shortWords);
        System.out.println("Total no of Long Words: " + longWords);
        System.out.println("Average Word Length: " + avgWordLength);
        System.out.println("No of Slang Words: " + noOfSlangWords);

        return totalFile;
    }

    // get hold of a Print writer object
    void appendToFile(String slangWord)
    {
        /******** REF This code is taking from stack overflow https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java*/
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter out;
        try
        {
            fw = new FileWriter("slang.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println("\n" + slangWord);
            out.close();
        }
        /******** End of REF This code is taking from stack overflow https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java*/
        catch (IOException e)
        {
            System.out.println("run time error " + e.getMessage());
        }
    }
}
