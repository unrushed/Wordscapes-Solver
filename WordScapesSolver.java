/*
 * Made By unrushed
 * https://github.com/unrushed
 */

import java.io.FileReader;
import java.util.Scanner;

public class WordScapesSolver {
    public static void main(String[] args) throws Exception{
        // scanners
        Scanner i = new Scanner(System.in);
        /* 
        * If you would like to use another dictionary, change the "english3.txt" with another dictionary or text file.
        */
        Scanner input = new Scanner(new FileReader("english3.txt"));

        System.out.print("Enter the given letters as a “word” with repetitions: ");
        String lettersUsed = i.nextLine().toLowerCase(); // saves the letters possble with no spaces

        System.out.print("Enter the length of the blank(number of characters int the desired word): ");
        int numberOfLetters = i.nextInt(); // how many letters do you need in the word


        /*
        * Reads from the dictionary text file.
        */
        while(input.hasNext()){
            String strTemp = input.nextLine(); // each word from dictionary
            if(isGood(lettersUsed, strTemp.toLowerCase, numberOfLetters)){
                System.out.println(strTemp);
            }
        }

        input.close();
    }
    
    /*
    * Checks whether the word from dictionary full fills the requirements for the desired word.
    */
    
    public static boolean isGood(String lettersGood, String dictionaryWord, int numberOfLetters){
        if((dictionaryWord.length() == numberOfLetters)) {
            StringBuilder temp = new StringBuilder(lettersGood);
            for (int i = 0; i < dictionaryWord.length(); i++) {
                if (temp.indexOf(String.valueOf(dictionaryWord.charAt(i))) != -1) {
                    temp = temp.deleteCharAt(temp.indexOf(String.valueOf(dictionaryWord.charAt(i))));
                } else {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
