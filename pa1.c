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

	//Correctly reads in file :-) 
}
