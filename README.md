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

------

# password-validator User Guild

## Password Validation Rules

`CharactersLengthRule` validates password length.

`CharactersTypeRule` validates password required character types, `DigitCharacter` for numerical digit, `LowercaseCharacter` for lowercase letter.

`NoRepeatSequenceRule` validates there is no repeat sequence of characters immediately followed by the same sequence.

Implements `Rule` interface to create new validation rule.

## Password Requried Character Types

`DigitCharacter` validates at least numbers of digit in password.

`LowercaseCharacter` validates at least numbers of lowercase characters in password.

Implements `Character` to create new charater type for `CharactersTypeRule` validation.

## Configuration properties file

Confiure password validation rules and character types by add the following properties in `password-validation-config.properties` in classpath. 

Notice that The programming configuation will override properties configuration.

|property|type|description|
|-|-|-|
|`rule.length.min`|Number|At least password length|
|`rule.length.max`|Number|At most password length|
|`rule.char.types`|Array|Required character types. e.g. `digit,lowercase`|
|`rule.char.lowercase.count`|Number|At least numbers of lowercase letter. 
|`rule.char.digit.count`|Number|At least numbers of numerical digit|