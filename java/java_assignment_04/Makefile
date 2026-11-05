sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Password.jar
	@echo
	java -jar Password.jar a
	@echo
	java -jar Password.jar A
	@echo
	java -jar Password.jar "*"
	@echo
	java -jar Password.jar eae9
	@echo
	java -jar Password.jar abcdefghijklmnop
	@echo
	java -jar Password.jar AAAaaa99Qb!!28

Password.jar: $(classes)
	jar cfe Password.jar Main $(classes)

%.class: %.java
	javac $<
