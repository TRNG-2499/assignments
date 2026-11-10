mainclass := Log
mainjava := $(mainclass).java
appname := Log
src := src
out := out

all: jar

compile: $(src)/$(mainjava)
	javac -d $(out) -cp . $(src)/$(mainjava)

jar: compile
	jar cvfe $(appname).jar $(src).$(mainclass) -C $(out) . picocli

clean:
	rm -fr $(out) $(appname).jar