@PostOnPage
Feature: Post On Page

  @draftPost
  Scenario: draft post on page
    Given the user create draft post
    And the user go to draft setting

  @eventPost
  Scenario: event post on page
    Given the user create event post
    And the user go to event setting

  @background_editPost
  Scenario: post with background
    Given the user create new post on page with background
    Given the user select the newly created post
    When the user clear content of post
    And the user remove background
    And the user input new content to update post

  @postPage
  Scenario: post on page
    Given the user create new post on page
    When the user view post detail
    
  @mediaPost
  Scenario: post with media on timeline
    Given the user create new media post '<src>' on page
    Given the user select the newly created post
    When the user remove media of post
    And the user input new content to update post
    Examples: srcs
      |src|
      |"D:\DOWNLOAD\maruko.jpg" "D:\DOWNLOAD\KAZUMAMIT.png"|

  @sharePost
  Scenario: share post on page
    Given the user select the newly created post
    When the user share post

