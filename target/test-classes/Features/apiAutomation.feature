Feature: API Automation TestCases

  @testGET
  Scenario Outline: using GET method
    Given User using GET method initializes the "<endPoint>"
    When User using GET method validates the <statusCode> and Response file
    Then User using GET method get the Response file

    Examples: 
      | endPoint         | statusCode |
      | posts/1/comments |        200 |

  #	| posts/1				|	200		|
  #	| posts					|	200		|
  @testPOST
  Scenario Outline: using POST method
    Given User using POST method initializes the "<endPoint>"
    When User using POST method validates the <statusCode> and Response file
    Then User using POST method get the Response file

    Examples: 
      | endPoint | statusCode |
      #	| posts/1/comments		|	200		|
      #	| posts/1				|	200		|
      | posts    |        201 |

  @testDELETE
  Scenario Outline: using DELETE method
    Given User using DELETE method initializes the "<endPoint>"
    When User using DELETE method validates the <statusCode> and Response file
    Then User using DELETE method get the Response file

    Examples: 
      | endPoint | statusCode |
      #	| posts/1/comments		|	200		|
      | posts/1  |        200 |
