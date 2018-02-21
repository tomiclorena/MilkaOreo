# MilkaOreo


Ensure you have Java System Variables path assigned
Control panel -> System -> Advanced system settings -> Advanced -> Environment variables...
Under System Variables find PATH -> click Edit
Add 2 new paths (find corresponding in your system)
  - C:\Program Files\Java\jdk1.8.0_161\bin
  - C:\Program Files\Java\jre1.8.0_161\bin

How to run:
- open Command Prompt
- go to project directory /src/oreochoc
- input: javac *.java 
- classes are compiled, .class files are created
- go back to src folder (cd ..)
- input: java oreochoc.Main

