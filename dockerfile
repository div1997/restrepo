FROM maven:3.6.3-jdk-8

Copy src home/APIAutomation/src
Copy testresult.html home/APIAutomation/testresult.html
Copy pom.xml  home/APIAutomation/pom.xml
Copy testng.xml home/APIAutomation/testng.xml
WorkDIR home/APIAutomation
ENTRYPOINT mvn clean test
