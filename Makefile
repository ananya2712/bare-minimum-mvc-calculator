all: compile

run: all
	java -cp '.:postgresql-42.2.25.jar' Controller

compile: 
	javac *.java