@PostOnGroup
Feature: Post On Group

  @groupPost
  Scenario: Post on group
    Given the user create new post '<content>'
    When the user view post in feed group
    Examples: contents
      |content|
      |bai post text auto|
      |#hashtag auto     |


  @mention_editPost
  Scenario: Mention user on group
    Given the user create new post and mention other user
    When the user click mention
    And the user select the newly created post
    And the user clear content of post
    And the user input new content to update post


  @background_delPost
  Scenario: post with background on group
    Given the user create new post with background
    Given the user select the newly created post
    When the user confirm delete post


  @mediaPost
  Scenario: post with media on group
    Given the user create new media post '<src>'
    Given the user select the newly created post
    When the user remove media of post
    And the user input new content to update post
    Examples: srcs
      |src|
      |"D:\DOWNLOAD\maruko.jpg" "D:\DOWNLOAD\KAZUMAMIT.png"|