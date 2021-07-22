@ReplyComment
Feature: Reply Comment
  @reply
    #rep_cmt 1, 2, 6
  Scenario: reply comment
    Given the user create new reply comment '<comment>'
    Examples: comment
      |comment|
      |cmt text auto|
      |cmt #hashtag auto|
      |cmt link auto https://toeic24.com/toeic-online-test|