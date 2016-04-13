Scenario: message is sent
Given server address by <server>
And message by <message>
When message can be send
And messager sends message
Then result should equal <result>

Examples:
|server|message|result|
|inf.ug.edu.pl|some message|0|
