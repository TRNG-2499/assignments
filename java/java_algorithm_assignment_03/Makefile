sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: ConsecutiveCompress.jar
	@echo
	java -jar ConsecutiveCompress.jar aabbaaAAbbccdeded
	@echo
	java -jar ConsecutiveCompress.jar aaaaaaaaaaaabbbbaaacd

ConsecutiveCompress.jar: $(classes)
	jar cfe ConsecutiveCompress.jar Main $(classes)

%.class: %.java
	javac $<
