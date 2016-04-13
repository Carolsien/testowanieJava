Scenario: Test MyStack
Given the empty stack
Then isEmpty should be true
Given the list 1, 2, 3
Then isEmpty should be false
Given the element by 3
When the element is pushed
Then the stack should have 3
Given the element by 4
When I want to add element to the stack
Then MyTop should be 4

Scenario: MyTop throws an exception
Given the stack is empty
Then MyTop should throw an exception

Scenario: MyPop throws exception
Given the stack is empty
And I want to pop item
Then MyPop throws an exception
