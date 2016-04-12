
Scenario: MyPop throws exception
Given the stack is empty
And I want to pop item
Then MyPop throws an exception

Scenario: MyPop works
Given the stack by <list>
Then the top of the stack should be <element>

Examples:
|list|element|
|8, 9, 0|9|

