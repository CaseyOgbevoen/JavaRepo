package Classes;

import java.util.ArrayList;

public class Slang {
    //attributes
    private String word;

    public Slang(String word) {

        this.word = word;
    }

    //method counts the number of slang words
    public int countString(String word) {
        int noOfSlangWords = 0;

        //open/read file
        FileReader slangFile = new FileReader("slang.txt");
        slangFile.openFile();
        ArrayList slangWords = slangFile.readAll();

        //check if word appears in slang word file
        for(int i = 0;i < slangWords.size(); i++){

            if(word.equalsIgnoreCase(String.valueOf(slangWords.get(i)))) {
                noOfSlangWords = 1;
            }
        }
        return noOfSlangWords;
    }
}
