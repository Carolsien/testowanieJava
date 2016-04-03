Scenario: IsEmpty returns true if stack is empty
Given the empty stack
Then IsEmpty should be true
					 
Scenario: IsEmpty returns false if stack is not empty
Given the stack by <list0>  
Then IsEmpty should be false

Examples: 
|list0|
|1, 2, 9, 10|


Scenario: MyPop throws exception
Given the stack is empty
And I want to pop item
Then MyPop throws an exception

Scenario: MyPop works
Given the stack by <list1>
Then the top of the stack should be <element1>

Examples:
|list1|element1|
|8, 9, 0|9|


Scenario: MyPush works
Given the element by <element2>
Then the stack should have <element2>

Examples:
|element2|
|12|

Scenario: MyTop throws an exception
Given the stack is empty
Then MyTop should throw an exception

Scenario: MyTop works
Given a  element by <element3>
When I want to add element to the stack
Then MyTop should be <element3>

Examples:
|element3|
|10|