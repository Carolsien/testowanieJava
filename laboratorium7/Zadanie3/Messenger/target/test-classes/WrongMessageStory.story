Scenario: message has wrong format
Given server address by <server>
And message by <message>
When message can be send
And messenger sends message
Then the result should be equal <result>

Examples:
|server|message|result|
|inf.ug.edu.pl|ab|2|
