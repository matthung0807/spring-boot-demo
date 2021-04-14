# spring-boot-demo
Spring Boot Demo

### Requirments

Write a password validation service, meant to be configurable via IoC (using dependency
injection engine of your choice). The service is meant to check a text string for compliance
to any number of password validation rules. The rules currently known are:

1. Must consist of a mixture of lowercase letters and numerical digits only, with at least one
of each.
2. Must be between 5 and 12 characters in length.
3. Must not contain any sequence of characters immediately followed by the same sequence.


The project should include a build capability in one of the following
tools, Eclipse, IntelliJ, ant, or maven. The project should be ready for insertion into a
production system. Show tests for the service and any constituent classes involved in
fulfillment of the service. Also, show how to access and use the service at runtime.

### Others

* SOLID design principles
* Apply sensible design patterns
* Use dependency injection in a sensible way given the problem
* Solution should be extensible
* Solution should be maintainable
* Automated test should fully exercise the code and prove it works
* Show both unit tests and integration tests
* Apply the same design principles to the test code that you apply to the actual code
* Ask questions, confirm your understanding