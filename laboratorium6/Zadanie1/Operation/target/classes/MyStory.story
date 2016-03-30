Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  Add two values
Given a variable x by <x1>
Given a variable y by <y1>
Then Add should <add>

Examples: 
|x|y|add|
|2|4|6|
|13|24|37|

					 
Scenario:  Subtract 
Given a variable x by <x2>
Given a variable y by <y2>
Then Subtract should <sub>

Examples: 
|x|y|sub|
|6|4|2|
|37|24|13|


Scenario:  Multiple
Given a variable x by <x3>
Given a variable y by <y3>
Then Multiple should <multi>

Examples: 
|x|y|multi|
|2|4|8|
|1|24|24|
|12|2|24|


Scenario:  Divide
Given a variable x by <x4>
Given a variable y by <y4>
Then Divide should <div>

Examples: 
|x|y|div|
|6|2|3|
|13|1|13|
|24|2|12|
