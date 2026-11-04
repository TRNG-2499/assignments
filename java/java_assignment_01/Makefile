sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: VendingMachine.jar
	@echo
	java -jar VendingMachine.jar -1.2 2.3
	@echo
	java -jar VendingMachine.jar 2.3 -1.2
	@echo
	java -jar VendingMachine.jar 1.2 3.4
	@echo
	java -jar VendingMachine.jar 1.2 1.20
	@echo
	java -jar VendingMachine.jar 3.4 1.20
	@echo
	java -jar VendingMachine.jar 1.100 2.3

VendingMachine.jar: $(classes)
	jar cfe VendingMachine.jar Main $(classes)

%.class: %.java
	javac $<
