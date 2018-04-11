package Classes;

public class Slang {
    //attributes
    private String slangWords;
    private int noOfSlangWords;

    //constructors counts the number of slang words
    public Slang extends FileExaminer(String slangWords, int noOfSlangWords) {

        this.slangWords = slangWords;
        this.noOfSlangWords = noOfSlangWords;

        FileReader slangFile = new FileReader("slang.txt");
        slangFile.openFile();
        slangWords = slangFile.readAll();


        //check if formal or informal
        for(int i = 0;i < slangFile.length(); i++){

            if(slangWords.equals(slangFile[i])) {
                System.out.println("Slang word found.");
                noOfSlangWords++;
            }
        }
    }
}

*/