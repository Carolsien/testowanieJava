Scenario: IsEmpty returns true if stack is empty
Given the empty stack
Then IsEmpty should be true
					 
Scenario: IsEmpty returns false if stack is not empty
Given the stack by <list>  
Then IsEmpty should be false

Examples: 
|list|
|1, 2, 9, 10|
