Scenario: Titit liczba_dziel is zero
Given an number as <liczba_dziel>
When <liczba_dziel> is zero
Then Titit should throw an exception

Scenario: Titit liczba is devided by liczba_dziel
Given a number as <liczba_dziel>
And liczba as <liczba>
When <liczba> devided by <liczba_dziel> is zero
Then Titit should return true

Examples: 
|liczba|liczba_dziel|
|12|3|

Scenario: Titit liczba is not devided by liczba_dziel
Given a number as <liczba_dziel>
And liczba as <liczba>
When <liczba> devided by <liczba_dziel> is not zero
Then Titit should return false

Examples: 
|liczba|liczba_dziel|
|12|5|