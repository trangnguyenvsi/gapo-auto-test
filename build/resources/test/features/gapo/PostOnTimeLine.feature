@PostOnTimeLine
Feature: Post On Time Line
  @media_removePost
    #TC5,6,7,11,12,13,14,15,23,24,25
  Scenario: post with media on timeline
    Given the user create new media post '<src>'
    Given the user select the newly created post
    When the user remove media of post
    And the user input new content to update post
    Examples: srcs
      |src|
      |"E:\Projects\Auto Testing\Web\gapo_post-main\gapo_post-main\src\test\resources\testdata\images\image2.jpg" "E:\Projects\Auto Testing\Web\gapo_post-main\gapo_post-main\src\test\resources\testdata\images\image13_png.png"|

  @add_mediaPost
    #TC20,21,22,26
  Scenario: edit and add media on post
    Given the user select the newly created post
    When the user add new media on post

  @posttext
    #TC01,02 03, 08
  Scenario Outline: post text, hashtag and preview link
    Given  the user create new post '<content>'
    When the user view post detail
    Examples:
    |content|
    |bai post text auto|
    |#hashtag auto     |
    |https://www.youtube.com/watch?v=-yhqOX3bLvQ|

  @mentionPost
    #TC09
  Scenario: post with mention user on timeline
    Given the user create new post and mention other user
    When the user view post detail
    And the user click mention

  @backgroundPost
    #TC10, 28
  Scenario: post with background
    Given the user create new post with background
    Given the user select the newly created post
    When the user clear content of post
    And the user remove background
    And the user input new content to update post

  @delPost
    #TC30
  Scenario: delete post on timeline
    Given the user select the newly created post
    When the user confirm delete post

  @sharePost
    #TC31,32,16,17,18
  Scenario: share post on timeline
    Given the user select the newly created post
    When the user edit privacy of post
    And the user share post