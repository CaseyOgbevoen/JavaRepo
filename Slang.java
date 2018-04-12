package Classes;

import java.util.ArrayList;

public class Slang {
    //attributes
    private String slang;
    private int noOfSlangWords = 0;

    //constructors counts the number of slang words
    public Slang(String slang, int noOfSlangWords) {

        this.slang = slang;
        this.noOfSlangWords = noOfSlangWords;

        FileReader slangFile = new FileReader("slang.txt");
        slangFile.openFile();
        String slangWords = slangFile.readAll();

        //check if formal or informal
        for(int i = 0;i < slangWords.length(); i++){

            if(slang.equals(slangWords[i])) {
                System.out.println("Slang word found.");
                noOfSlangWords++;
            }
        }
    }
}
