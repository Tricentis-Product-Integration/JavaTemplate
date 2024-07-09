# Rest API Template using Java

## Clone using the CreateProject CLI Tool:
```
createProject -name "name" -templateType "Java" -templateVersion(optional) "1.0.0" -outputDirectory "path"
```


### Uses Java Version 22

## Included Dependencies
### - Maven Spring Boot Starter 3.3.1
### - Maven Spring Boot Starter Web 3.3.1
### - Maven Spring Boot Starter Test 3.3.1
- Junit Jupiter
- Mockito
- Hamcrest

<br/>

## Included Plugins
### - Spring Boot Maven Plugin 3.3.1
### - Maven Surefire Plugin 3.3.0

<br/>

## CI/CD Pipeline
### Github Workflow
 - Pull Request: Checkout, Setup Java, and Runs tests when pull request opened to main branch.
 - Release: Checkout, Setup Java, Packages into JAR, and Creates release asset when release is published.
 - SonarQube: Checkout, Setup Java, Cache SonarQube packages, Cache Maven packages, and Build and Analyze

