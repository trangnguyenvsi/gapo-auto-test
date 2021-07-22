@React
Feature: React
  @react_on_post
    #reaction1, 2, 3, 4, 6, 7, 8, 9, 10
  Scenario: React on post
    Given the user click react on post
    When the user click react on cmt
#    And the user click react on reply cmt

#  @change_react_on_post
#  Scenario: Change react on post
#    Given the user click change react on post
#    When the user click change react on cmt
#    And the user click change react on reply cmt

  @un_react_on_post
#unreaction 1,2, 3, 4, 5, 6
  Scenario: Unreact on post
    Given the user click unreact on post
    When the user click unreact on cmt
#    And the user click unreact on reply cmt
