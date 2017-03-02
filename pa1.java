import java.io.*;
import java.util.Scanner;


public class pa1{

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        String file_name = scanner.next();
        scanner.close();
        File file = new File(file_name);
        Scanner file_sc = null;
        try{
            file_sc = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        while(file_sc.hasNextLine()){
            String s = file_sc.next();
            System.out.println(s);
        }
        
        
        file_sc.close();

    }
}