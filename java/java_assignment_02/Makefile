sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: WeightLimit.jar
	@echo
	java -jar WeightLimit.jar 1
	@echo
	java -jar WeightLimit.jar 1 1
	@echo
	java -jar WeightLimit.jar 10 1
	@echo
	java -jar WeightLimit.jar 10 5 4 9
	@echo
	java -jar WeightLimit.jar 10 9 4 5

WeightLimit.jar: $(classes)
	jar cfe WeightLimit.jar Main $(classes)

%.class: %.java
	javac $<
