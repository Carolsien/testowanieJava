Scenario: servers address with bad connection
Given server address by <server>
And bad connection
When connection is tested
Then result should equal <result>

Examples:
|server|result|
|inf.ug.edu.pl|1|