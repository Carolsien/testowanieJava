Scenario: Heheszki liczba is smaller than zero
Given liczba as <liczba>
When liczba is smaller or equal zero
Then Heheszki should throw an exception


Scenario: Heheszki liczba is greater than zero
Given liczba as <liczba>
Then wynik as <wynik> should be a random number smaller than liczba

Examples:
|liczba|wynik|
|12|3|