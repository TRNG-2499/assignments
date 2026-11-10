sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Closest.jar
	@echo
	java -jar Closest.jar 10 1 2 3 4 18 30 90

Closest.jar: $(classes)
	jar cfe Closest.jar Main $(classes)

%.class: %.java
	javac $<
