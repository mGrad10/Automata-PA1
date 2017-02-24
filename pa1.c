#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// Function prototypes

int main(int argc, char *argv[]){

	if(argc !=2){
		printf("Program needs one input <filename>");
		exit(1);
	}

	File *infile = fopen(argv[1], "r");
	if(infile ==NULL){
		fprintf(stderr, "Error: Could not open file %s for reading\n", argv[1]);
		exit(1);
	}

}
