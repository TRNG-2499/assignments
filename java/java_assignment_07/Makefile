sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Animals.jar
	@echo
	java -jar Animals.jar

Animals.jar: $(classes)
	jar cfe Animals.jar Main $(classes)

%.class: %.java
	javac $<
