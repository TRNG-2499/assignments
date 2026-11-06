sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: MissingNumber.jar
	@echo
	java -jar MissingNumber.jar 1 10 9 8 6 3 2 4 5

MissingNumber.jar: $(classes)
	jar cfe MissingNumber.jar Main $(classes)

%.class: %.java
	javac $<
