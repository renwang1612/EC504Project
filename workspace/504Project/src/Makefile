src_java		:= ActionEventFrame.java ButtonActionEventDemo.java \
                    ButtonActionListener.java FrameTest.java \
                    GetIp.java Observer.java Subject.java 
target_class	:= $(src_java:%.java=%.class)

all:run

%.class:%.java
	javac $<

run:$(target_class) 
	java FrameTest

kill:
	killall java

.PHONY: all run clean
clean:
	rm -rf *.class *~
