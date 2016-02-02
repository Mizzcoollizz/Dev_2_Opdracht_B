Feature: Hello World
    
    Scenario: Say Howdy
        Given I have a hello app with "Howdy"
        When I ask it to say hi
        Then it should answer with "Howdy World"

    Scenario: Say hello
        Given I have a hello app with "Hello"
        When I ask it to say hi
        Then it should answer with "Hello World"