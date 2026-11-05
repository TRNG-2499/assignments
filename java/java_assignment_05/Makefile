sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: Duplicates.jar
	@echo
	java -jar Duplicates.jar a
	@echo
	java -jar Duplicates.jar a a
	@echo
	java -jar Duplicates.jar A a
	@echo
	java -jar Duplicates.jar there once was a great big dog and it jumped and It Jumped and IT JUMPED over the moon
	@echo
	java -jar Duplicates.jar sphinx of black quartz judge my vow

Duplicates.jar: $(classes)
	jar cfe Duplicates.jar Main $(classes)

%.class: %.java
	javac $<
