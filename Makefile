TARGETS=pa1

CFLAGS=-Wall -Wextra -Werror -g

all: $(TARGETS)

pa1: pa1.c
	gcc $(CFLAGS) -o $@ $^

clean:
	rm -f $(TARGETS)
