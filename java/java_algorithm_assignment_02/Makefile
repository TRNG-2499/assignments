sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: RotateArray.jar
	@echo
	java -jar RotateArray.jar 0 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 1 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 2 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 3 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 4 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 5 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 6 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 7 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar 8 1 2 3 4 5 6
	@echo
	java -jar RotateArray.jar -1 1 2 3 4 5 6

RotateArray.jar: $(classes)
	jar cfe RotateArray.jar Main $(classes)

%.class: %.java
	javac $<
