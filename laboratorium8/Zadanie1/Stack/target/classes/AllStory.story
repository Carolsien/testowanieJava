GivenStories: MyPopStory.story, MyPushStory.story

Scenario: IsEmpty returns false if stack is not empty
Given the stack by <list>  
Then IsEmpty should be false

Examples: 
|list|
|1, 2, 9, 10|
