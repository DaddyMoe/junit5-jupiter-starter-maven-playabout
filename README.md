# My junit5-jupiter-starter-maven-playabout

The `junit5-jupiter-starter-maven-playabout` is example Junit5 test example code mainly from the 
[Junit5 guides](https://junit.org/junit5/docs/current/user-guide/) built up on top of the 
[original junit5](https://github.com/junit-team/junit5-samples/tree/master/junit5-jupiter-starter-maven) 
`junit5-jupiter-starter-maven` project which demonstrates how to execute JUnit Jupiter
tests using Maven.

---

Notes:
 
- This project uses the [Maven Wrapper](https://github.com/takari/maven-wrapper).
Thus, to ensure that the correct version of Maven is used, invoke `mvnw` instead of `mvn`.

- Caution Some annotations may currently be experimental. Consult the 
[Junit5 documentation](https://junit.org/junit5/docs/current/user-guide/#api-evolution-experimental-apis) 
for Experimental APIs for details.  Unfortunately this includes my favourite @ParameterizedTest :( .
