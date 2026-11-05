sources = $(wildcard *.java)
classes = $(sources:.java=.class)

.PHONY: test

test: TrafficLight.jar
	@echo
	java -jar TrafficLight.jar Red 4
	@echo
	java -jar TrafficLight.jar Green 3
	@echo
	java -jar TrafficLight.jar Green Green
	@echo
	java -jar TrafficLight.jar Yellow -1
	@echo
	java -jar TrafficLight.jar Ourple 3
	@echo
	java -jar TrafficLight.jar Yellow 8

TrafficLight.jar: $(classes)
	jar cfe TrafficLight.jar Main $(classes)

%.class: %.java
	javac $<
