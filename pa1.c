/* Taylor Coury, Melinda Grad
 * Automata PA 1 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

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

	//Get the alphabet
	char *alpha = malloc(100*sizeof(char));
	fscanf(infile, "%s", alpha);
	//printf("%c\n", alpha[0]);

	//Get the number of characters in the aplhabet
	int num_alpha = strlen(alpha);
	printf("num_alpha = %d\n", num_alpha);
	
	int num_transitions = num_alpha * num_states;
	int transition_array[num_alpha][num_states];

	for(int i = 0; i< num_transitions; i++){
		int curr_state = 0;
		int next_state = 0;
		char input;

		//Get the transition
		fscanf(infile, "%d '%c' %d", &curr_state, &input, &next_state);
		
		// Checking which element of the alphabet
		for(int j =0; j< num_alpha; j++){
			printf("alpha[j] = %c %c\n", alpha[j], input);
			int ret = strcmp(input, alpha[i]);
			if(ret ==0){
				// Put the input into the array

				transition_array[j][curr_state-1] = next_state;
				printf(" element: %d", transition_array[j][curr_state-1]);
				break;
			}

	///TAke in the accept tates string, tokenize by space, update counter, change each token to
	// and put into an int array to hold all the accept states.
	//TODO: 

	//TODO: Read in (for loop) the strings

	//TODO:

	return 0;
}
