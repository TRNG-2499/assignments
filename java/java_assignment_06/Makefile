sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Calculator.jar
	@echo
	java -jar Calculator.jar

Calculator.jar: $(classes)
	jar cfe Calculator.jar Main $(classes)

%.class: %.java
	javac $<
