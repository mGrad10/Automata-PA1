import java.io.*;
import java.util.Scanner;


public class pa1{

    public static void main (String[] args){
    /*
        Scanner scanner = new Scanner(System.in);
        String file_name = scanner.next();
        scanner.close();
    */

        //File file = new File(file_name);
        File file = new File(args[0]);
        
        Scanner file_sc = null;
        try{
            file_sc = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        /*TODO:
        while(file_sc.hasNextLine()){
            String s = file_sc.nextLine();
            System.out.println(s);
        }*/
        // Get the number of states
        String s = file_sc.nextLine();
        int num_states = Integer.parseInt(s);
        System.out.println(num_states);

        //Get the alphabet
        String alphabet = file_sc.nextLine();
        System.out.println(alphabet);

        //Get number transitions
        int num_alpha = alphabet.length();
        //System.out.println(num_alpha);
        int num_transitions = num_alpha * num_states;

        //Array to hold transitions
        int[][] transition_array = new int[num_alpha][num_states]; 

        for(int i=0; i<num_transitions; i++){
            
            //Read in the transition
            int curr_state = Integer.parseInt(file_sc.next());
            String input = file_sc.next();
            int next_state = Integer.parseInt(file_sc.next());

            //Get rid of ''
            String clean_input = input.replace("'", "");
            //System.out.println(clean_input);

            for(int j=0; j< num_alpha; j++){
                if(clean_input.compareTo(Character.toString(alphabet.charAt(j)))==0){

                    transition_array[j][curr_state-1] = next_state;
                    //System.out.println(transition_array[j][curr_state-1]);
                    break;
                }
            }
        }
        
        for(int i=0; i< num_alpha; i++){
            System.out.println("\n");
            for(int j=0; j<num_states; j++){
                System.out.println(transition_array[i][j]);
            }
        }

        file_sc.close();

    }
}