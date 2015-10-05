src_java		:= Main.java Client.java
target_class	:= $(src_java:%.java=%.class)

all:run

%.class:%.java
	javac $<

run:$(target_class) 
	java Main 

kill:
	killall java

.PHONY: all run clean
clean:
	rm -rf *.class *~
