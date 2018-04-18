package Classes;

/****************************************************************************
 * Author: Casey Ogbevoen
 * Date: March/April 2018
 * OS: Windows 10
 * Purpose: This file compares the given word with another file called
 *          "slang.txt". This slang file contains a list of slang words
 *          where, if the passed-in word matches a word in the file, that
 *          match is recorded and counted to give the total number of
 *          slang words used.
 ****************************************************************************/

import java.util.ArrayList;

public class Slang {
    //attributes
    private String word;

    public Slang(String word) {

        this.word = word;
    }

    //method determines if the word appears in the slang.txt file
    public int countSlang(String word) {

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
