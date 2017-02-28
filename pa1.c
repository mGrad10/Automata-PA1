/* Taylor Coury, Melinda Grad
 * Automata PA 1 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// TODO: Function prototypes


int main(int argc, char *argv[]){

	if(argc != 2){
		printf("Program needs one argument <filename>\n");
		exit(1);
	}

	// Read the file containing the DFA simulation specifications
	FILE *infile = fopen(argv[1], "r");
	if(infile ==NULL){
		fprintf(stderr, "Error: Could not open file %s for reading\n", argv[1]);
		exit(1);
	}

	// Read first line containing number of states
	int num_states = 0;
	fscanf(infile, "%d", &num_states);
	printf("Number of states: %d\n", num_states);

	//Gettting the alphabet
	char *alpha = NULL; //TODO: How to init this?
	fscanf(infile, "%s", alpha);
	int num_alpha = strlen(alpha);

	int num_transitions = num_alpha * num_states;
	int transition_func[num_alpha][num_states];

	for(int i = 0; i< num_transitions; i++){
		int curr_state = 0;
		int next_state = 0;
		char input;
		fscanf(infile, "%d '%c' %d", &curr_state, &input, &next_state);
		
		// Checking which element of the alphabet
		for(int j =0; j< num_alpha; j++){
			if(strcmp(input, alpha[i])== 0){
				transition_func[j][curr_state-1] = next_state;
				break;
			}
		}
	}
	int start_state = 0;
	fscanf(infile, "%d", start_state);

	///TAke in the accept tates string, tokenize by space, update counter, change each token to
	// and put into an int array to hold all the accept states.


	//TODO: Read in (for loop) the strings

	//TODO: 

}
