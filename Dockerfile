FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/container-test-0.0.1-SNAPSHOT.jar /usr/share/tag/container-test-0.0.1-SNAPSHOT.jar

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/container-test-0.0.1-SNAPSHOT.jar", "org.testng.TestNG", "-testclass", "com.testautomationguru.container.test.GoogleTest"]