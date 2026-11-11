sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Parenthesis.jar
	@echo
	java -jar Parenthesis.jar

Parenthesis.jar: $(classes)
	jar cfe Parenthesis.jar Main $(classes)

%.class: %.java
	javac $<
