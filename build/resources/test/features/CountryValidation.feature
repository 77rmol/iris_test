Feature: Validation Country

  @test1
  Scenario Outline: Statistics Country
    Given Rober wanna know the statistics abouts "<country>"
    When Rober get the response
    Then Rober validate the information

    Examples:
      | country   |
      | Colombia  |
      | Mexico    |
      | US        |
      | Canada    |
      | Venezuela |

  @test2
  Scenario: Statistics Failed
    Given Rober wanna know the statistics abouts "Colombia"
    When Rober get the failed response
    Then Rober can not get information
