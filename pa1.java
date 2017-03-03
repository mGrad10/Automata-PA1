/* Automata PA 1
 * Taylor Coury tacoury@sandiego.edu
 * Melinda Grad mgrad@sandiego.edu

 * This program will read in file with DFA spcifications
 * and will simulate the DFA on sample strings.
 * The program will print out a message indicating whether each
 * string has been accepted or rejected.
 */

import java.io.*;
import java.util.Scanner;

public class pa1{

    public static void main (String[] args){
    
        // Open and read input from the file specifying the DFA
        File file = new File(args[0]);
        Scanner file_sc = null;
        try{
            file_sc = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        // Get the number of states
        String s = file_sc.nextLine();
        int num_states = Integer.parseInt(s);

        //Get the alphabet
        String alphabet = file_sc.nextLine();

        //Get number transitions
        int num_alpha = alphabet.length();
        int num_transitions = num_alpha * num_states;

        //Array to hold transitions
        int[][] transition_array = new int[num_alpha][num_states];

        populateArray(num_transitions, file_sc, num_alpha, alphabet, transition_array);
        
        int start_state = Integer.parseInt(file_sc.next());

        //Get the set of accept states
        String temp = file_sc.nextLine();
        String accept_temp = file_sc.nextLine();
        String[] accept_states = accept_temp.split(" ");
        int num_accept = accept_states.length;
        
        //Get the input strings to simulate then check against the array
        while(file_sc.hasNextLine()){
            String input_string = file_sc.nextLine();
            int length = input_string.length();
            int current = start_state;
            for(int i = 0; i < length; i++){
                for(int j = 0; j < num_alpha; j++){
                    if(input_string.charAt(i) == alphabet.charAt(j)){
                        current = transition_array[j][current-1];
                        break;
                    }
                }
            }
            
            checkResult(num_accept, current, accept_states);
        }
        file_sc.close();

    }

    /* Function to check if DFA accepts or rejects
       @param num_accept number of accept states
       @param current current state
       @param accept states set of accept states
     */
    public static void checkResult(int num_accept, int current, String[] accept_states){
        boolean accept = false;
            for(int i = 0; i < num_accept; i++){
                if(current == Integer.parseInt(accept_states[i])){
                    accept = true;
                    break;
                }
            }
            if(accept)
                System.out.println("Accept");
            else
                System.out.println("Reject");

    }
    /* Function to populate the array of transitions
       @param num_transitions number of transitions
       @param file_sc scanner
       @param num_alpha number of chars in the alphabet
       @param alphabet String containing the alphabet
       @param transition array array to hold transitions
     */
    public static void populateArray(int num_transitions, Scanner file_sc, int num_alpha,
        String alphabet, int[][] transition_array){
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
    }
}
