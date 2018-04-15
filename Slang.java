package Classes;

import java.util.ArrayList;

public class Slang {
    //attributes
    private String word;

    //constructor counts the number of slang words
    public  Slang(String word) {

        this.word = word;
    }

    public int countString(String word, int noOfSlangWords) {

        //open/read file
        FileReader slangFile = new FileReader("temp.txt");
        slangFile.openFile();
        ArrayList slangWords = slangFile.readAll();
        //noOfSlangWords = 0;

        //check if word appears in slang word file
        for(int i = 0;i < slangWords.size(); i++){

            if(word.equalsIgnoreCase(String.valueOf(slangWords.get(i)))) {
                noOfSlangWords++;
                System.out.println("No of Slang Words: " + noOfSlangWords);
            }
        }
        return noOfSlangWords;
    }
}
