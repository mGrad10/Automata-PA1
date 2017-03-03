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
        //Loop to populate the array of transitions
        for(int i=0; i<num_transitions; i++){
            //Read in the transition
            int curr_state = Integer.parseInt(file_sc.next());
            String input = file_sc.next();
            int next_state = Integer.parseInt(file_sc.next());

            //Get rid of ''
            String clean_input = input.replace("'", "");
            
            for(int j=0; j< num_alpha; j++){
                if(clean_input.compareTo(Character.toString(alphabet.charAt(j)))==0){
                    transition_array[j][curr_state-1] = next_state;
                    break;
                }
            }
        }
        /*Prints the array
        for(int i=0; i< num_alpha; i++){
            System.out.println("\n");
            for(int j=0; j<num_states; j++){
                System.out.println(transition_array[i][j]);
            }
        }*/

        int start_state = Integer.parseInt(file_sc.next());
        System.out.println(start_state);

        //TODO: Get the set of accept states
        String temp = file_sc.nextLine();
        String accept_temp = file_sc.nextLine();
        System.out.println(accept_temp);
        String[] accept_states = accept_temp.split(" ");
        int num_accept = accept_states.length;
        for(int i = 0; i < num_accept; i++){
            System.out.println(accept_states[i]);
        }
        
        //TODO: Get the input strings to simulate then check against the array
        /*while(file_sc.hasNextLine()){
            String input = file_sc.nextLine();
            int length = input.length();
            int current = start_state;
            for(int i = 0; i < length; i++){
                
            }
        }
        */


        file_sc.close();

    }
}
