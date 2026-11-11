sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: OrderProcessing.jar
	@echo
	java -jar OrderProcessing.jar Sausage 2 3 4.8 3.2 false
	@echo
	java -jar OrderProcessing.jar Steak 3 2 4.8 3.2 false
	@echo
	java -jar OrderProcessing.jar Broccoli 2 3 4.8 38.2 false
	@echo
	java -jar OrderProcessing.jar Lettuce 2 3 4.8 3.2 true

OrderProcessing.jar: $(classes)
	jar cfe OrderProcessing.jar Main $(classes)

%.class: %.java
	javac $<
