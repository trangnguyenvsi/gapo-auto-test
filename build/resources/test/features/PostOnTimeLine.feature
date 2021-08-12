@postontimeline
Feature: Post on timeline

  @posttexttimeline
#  Post text
#  Post hashtag
#  Post preview link
  Scenario Outline: post text
    When the user create new text post "<type>" and "<content>"
    Then the post content is correct
    When the user view post detail
    Then the post content is correct
    When the user go back to previous page
    And the user select view more option of new post
    And the user select edit option
    And the user input new content to update post "<updatedType>" and "<updatedContent>"
    Then the user see the updated content correctly
    When the user select view more option of new post
    And the user select delete option
    And the user confirm
#    Then the post is deleted successfully
    Examples: src
      | type    | content                                     | updatedType | updatedContent                                                      |
      | text    | bai post text auto                          | link        | https://johnfergusonsmart.com/running-serenity-bdd-tests-with-tags/ |
      | hashtag | #autotest                                   | text        | updated text                                                        |
      | link    | https://www.youtube.com/watch?v=-yhqOX3bLvQ | hashtag     | #updatedautotest                                                    |



      #  @postlongtext => Not yet find solution
#  Scenario: post text
#    When the user create new long text post
#    Then the post content is correct "<type>"
#    When the user view post detail
#    Then the post content is correct "<type>"


  @postmediatimeline
#     Post one image
#     Post one video,
#     multiple image,
#     multiple video,
#     multiple images and videos (Not done)
  Scenario Outline: post with media on group
    When the user create new media post "<total>" and "<name>" and "<mediaType>" and "<textType>" and "<content>"
    Then the user see the correct media number on the post
    When the user view post detail
    Then the user see the correct media number on the post
    When the user go back to previous page
    And the user select view more option of new post
    And the user select edit option
    And the user update the media post "<action>" and "<numberOfMedia>" and "<updatedName>" and "<updatedMediaType>"
    Then the user see the correct media number on the post
    When the user select view more option of new post
    And the user select delete option
    And the user confirm
#    Then the post is deleted successfully

    Examples: src
      | total | name  | mediaType | textType | content         | action | numberOfMedia | updatedName  | updatedMediaType | confirmation |
      | 1     | image | .jpg      | text     | one images      | remove | all           |              |                  | Yes          |
      | 8     | image | .jpg      | text     | multiple images | add    | 1             | updatedImage | .jpg             | Yes          |
      | 2     | png   | .png      | text     | png image       | add    | 1             | updatedVideo | .mp4             | Yes          |
      | 1     | video | .mp4      | text     | one video       | add    | 2             | updatedImage | .jpg             | Yes          |
      | 2     | video | .mp4      | text     | multiple videos | remove | all           |              |                  | Yes          |

  @postbackgroundtimeline
  Scenario Outline: post with background
    When the user create new post with background "<textType>" and "<content>" and "<background>"
    Then the user see correct background on post
    When the user view post detail
    Then the user see correct background on post
    When the user go back to previous page
    And the user select view more option of new post
    And the user select edit option
    And the user update background and share post "<updateBackground>"
    Then the user see correct background on post
    When the user select view more option of new post
    And the user select edit option
    And the user remove background
    Then the user see that the post has no background
    When the user select view more option of new post
    And the user select delete option
    And the user confirm
#    Then the post is deleted successfully
    Examples: src
      | textType | content                   | background | updateBackground |
      | text     | Gapo auto test background | covid      | orange           |

  @postmentiontimeline
  Scenario Outline: post by mention user
    When the user create new post and mention another user "<textType>" and "<mentionedName>"
    When the user view post detail
    And the user click mention
    Then the user see profile name correctly
    When the user go back to previous page
    And the user select view more option of new post
    And the user select edit option
    And the user add more mention name "<textType>" and "<updatedMentionedName>"
    When the user view post detail
    And the user click mention
    Then the user see profile name correctly
    When the user go back to previous page
    And the user select delete option
    And the user confirm
#    Then the post is deleted successfully

    Examples: src
      | textType | mentionedName | updatedMentionedName |
      | mention  | @Trang.nguyen | @Nam                 |


  @checkpostprivacytimeline
  Scenario:Check privacy
    When the first user create post with privacy
      | privacy    | content      |
      | only_me    | Chỉ mình tôi |
      | in_company | Cùng công ty |
      | friends    | Bạn bè       |
    When the friend login
      | email                     | pass      |
      | testdemopro01@appzily.com | 12345678a |
    And search the first user and view post list
      | searchText          | name                |
      | Trang Mailinator 21 | Trang Mailinator 21 |
    Then the friend can view the post with correct privacy
      | postContent  | view |
      | Chỉ mình tôi | No   |
      | Cùng công ty | No   |
      | Bạn bè       | Yes  |
    When the colleague login
      | email                           | pass      |
      | trangnguyenpro05@mailinator.com | 12345678a |
    And search the first user and view post list
      | searchText          | name                |
      | Trang Mailinator 21 | Trang Mailinator 21 |
    Then the colleague can view the post with correct privacy
      | postContent  | view |
      | Chỉ mình tôi | No   |
      | Cùng công ty | Yes  |
      | Bạn bè       | No   |
    When the first user login again
      | email                           | pass      |
      | trangnguyenpro21@mailinator.com | 12345678a |
    And the user go to timeline page
    And the user delete all new posts
      | 3 |


  @postquestiontimeline
  Scenario Outline: Check post question
    When the user create the question post "<textType>" and "<content>"
    Then the user see the correct question post
    When the user view post detail
    Then the user see the correct question post
    When the user go back to previous page
    And the user select view more option of new post
    And the user select edit option
    And the user input new content to update question post "<updatedType>" and "<updatedContent>"
    Then the user see the correct question post
    And the user select view more option of new post
    And the user select delete option
    And the user confirm
#    Then the post is deleted successfully

    Examples: src
      | textType | content     | updatedType | updatedContent   |
      | text     | Hỏi tôi nào | text        | Hỏi tôi nào !!!! |


  @editprivacytimeline
  Scenario Outline: Edit privacy of post
    When the user select view more option of new post
    And the user select edit option
    And the user update privacy "<privacy>"
    Then the privacy is update correctly

    Examples: src
      | privacy    |
      | only_me    |
      | in_company |
      | friends    |


  @posttagtimeline
  Scenario Outline: Create post by tag user
    When the user click create post
    And the user input text "<postType>" and "<content>" and choose privacy "<privacy>"
    And the user click tag icon
    And the user search name and select search results "<tagList>"
    And the user click done
    And the user click share post
    Then the user see correct tag list
    When the user click to tag list
    Then the tag list is correct
    When the user view post detail
    Then the user see correct tag list
    When the user click to tag list
    Then the tag list is correct
    When the user close tag list detail popup
    And the friend login "<friendEmail>" and "<password>"
    And select notification tab
    Then see content of tag notification "<friendNoti>"
    And see content of post notification "<friendNoti>"
    When the colleague login "<colleagueEmail>" and "<password>"
    And select notification tab
    Then see content of tag notification "<colleagueNoti>"
    When the first user login again "<userPost>" and "<password>"
#    And the user go to timeline page
#    And the user select view more option of new post
#    And the user select delete option
#    And the user confirm
#    And the user go to home page

    Examples: src
      | postType | privacy    | content | tagList                                  | userPost                        | friendEmail               | friendNoti | colleagueEmail                  | password  | colleagueNoti |
      | text     | in_company | tag     | Thu Hà,Test Auto Demo,Trang Mailinator 5 | trangnguyenpro21@mailinator.com | testdemopro01@appzily.com | no         | trangnguyenpro05@mailinator.com | 12345678a | yes           |
      | text     | friends    | tag     | Thu Hà,Test Auto Demo,Trang Mailinator 5 | trangnguyenpro21@mailinator.com | testdemopro01@appzily.com | yes        | trangnguyenpro05@mailinator.com | 12345678a | no            |


  @deleteallpost
  Scenario: Del post on homepage
    When the user decide to delete all post


