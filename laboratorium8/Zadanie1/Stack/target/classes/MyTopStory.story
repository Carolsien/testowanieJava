
Scenario: MyTop throws an exception
Given the stack is empty
Then MyTop should throw an exception

Scenario: MyTop works
Given a  element by <element>
When I want to add element to the stack
Then MyTop should be <element>

Examples:
|element|
|10|