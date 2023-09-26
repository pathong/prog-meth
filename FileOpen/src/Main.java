import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fileToRead = new File("duplist.txt");


        //TODO: FILL CODE
        Scanner sc = null;
        try {
            sc = new Scanner(fileToRead);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(sc.hasNextLine()){
            String[] sp = sc.nextLine().split(" ");
            System.out.println(sp[0]);
            System.out.println(Integer.parseInt(sp[1]));
        }


    }
}
