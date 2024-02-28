/*
 * Made By unrushed
 */

import java.io.FileReader;
import java.util.Scanner;

public class WordScapesSolver {
    public static void main(String[] args) throws Exception{
        Scanner i = new Scanner(System.in);
        Scanner input = new Scanner(new FileReader("english3.txt"));

        System.out.print("Enter the given letters as a “word” with repetitions: ");
        String lettersUsed = i.nextLine().toLowerCase();

        System.out.print("Enter the length of the blank(number of characters int the desired word): ");
        int numberOfLetters = i.nextInt();

        while(input.hasNext()){
            String strTemp = input.nextLine().toLowerCase();
            if(isGood(lettersUsed, strTemp, numberOfLetters)){
                System.out.println(strTemp);
            }
        }

        input.close();
    }

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