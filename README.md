# Demo

## Sample implementations of some of the ways to abstract execution time of method away from business logic

In order to run the "annotation" implementation that uses `aspectj`, the project needs to go through a maven install.
The currently used version of `aspectj` depends on jdk8 for the compilation step of `aspectj-maven-plugin`


```
export JAVA_HOME=/path/to/jdk8-base-dir/
./mvnw clean install
java -jar target/aspect-time-1.0-SNAPSHOT-jar-with-dependencies.jar
```