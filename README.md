# Rest API Template using Java

 Uses Java Version 22

## Included Dependencies
 - Spring Boot Starter
 - Spring Boot Starter Web
 - Spring Boot Starter Test
    - Junit Jupiter
    - Mockito
    - Hamcrest
 - Spring Boot Starter JPA
 - Spring Boot Devtools 
 - H2 Database


## Included Plugins
 - Spring Boot Maven Plugin
 - Maven Surefire Plugin


## CI/CD Pipeline
### Github Workflow
 - Pull Request: Checkout, Setup Java, and Runs tests when pull request opened to main branch.
 - Release: Checkout, Setup Java, Packages into JAR, and Creates release asset when release is published.


## CreateProject CLI Tool to Create Clone:
```
Used to create project using given parameters, which include name, type, version, and directory location

Usage:
  projectMaker createProject [flags]

Aliases:
Flags:
  -h, --help                     help for createProject
  -n, --name string              desired name of project
  -o, --outputDirectory string   desired output directory location of project, can be path to existing directory or can be name of a new directory to be created
  -t, --templateType string      desired type of project template, used to generate
                                 repository name: Tricentis-Product-Integration/<templateType>Template
  -v, --templateVersion string   version of template, passed as a tag to the template repository (default "latest")
```

## Clone using the CreateProject CLI Tool:
```
createProject -name "name" -templateType "Java" -templateVersion(optional) "1.0.0" -outputDirectory "path"
```