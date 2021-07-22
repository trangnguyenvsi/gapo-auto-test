@CommentOnTimeLine
Feature: Comment On Time Line
  @Comment
    #Comment2,3,6,9 Create1
  Scenario: Comment post on timeline
    Given the user create new comment on '<comment>'
    Examples: comment
    |comment|
    |cmt text auto|
    |#kimtaehyung |
    |https://toeic24.com/toeic-online-test|
    |cmt #hashtag auto|
    |cmt link #learningenglish auto https://toeic24.com/toeic-online-test|

  @Comment_with_sticker_pin_and_unpin
    #Comment5 Pin1 Unpin1
  Scenario: Comment with sticker
    Given the user create new comment with sticker
    #only_page
#    When the user click pin comment
#    And the user click unpin comment

  @Comment_with_emoji
    #Delete1
  Scenario: Comment with emoji
    Given the user create new comment with emoji
    When the user click delete comment

  @Comment_with_media
    #Comment4 Edit1
  Scenario: Comment with media
    Given the user create new comment with media '<src>'
    When the user click edit comment
    And the user remove media of comment and update text
  Examples: src
  |src|
  |D:\DOWNLOAD\KAZUMAMIT.png|
  |D:\DOWNLOAD\1e3d529c-6f1f-4e9c-98cf-1ff2aacd6152.gif|

  @Comment_mention_user
    #Comment1
  Scenario: Comment mention other user
    Given the user create new comment mention other user
    When the user reply comment
    And the user click mention
