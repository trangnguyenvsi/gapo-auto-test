@postonhomepage
Feature: Post on home page

  @posttexthomepage
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


  @postmediahomepage
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

  @postbackgroundhomepage
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

  @postmentionhomepage
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


  @checkpostprivacyhomepage
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


  @postquestionhomepage
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


  @editprivacyhomepage
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


  @posttaghomepage
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

  @postbycopycontent
  Scenario Outline: Copy post's link and create new post
    When the user get content of the new post "<postType>"
    And the user select view more option of new post
    And the user select copy post content
    And the user click create post
    And paste the coppied content
    And the user click share post
    Then the post content is correct
    When the user select view more option of new post
    And the user select delete option
    And the user confirm

    Examples: src
      | postType |
      | text     |

  @postbycopylink
  Scenario Outline: Copy post's link and create new post
    When the user view post detail
    And the user get the current post link "<postType>"
    And the user go back to previous page
    And the user select view more option of new post
    And the user select copy post link
    And the user click create post
    And paste the coppied content
    And the user click share post
    Then the post content is correct
    When the user select view more option of new post
    And the user select delete option
    And the user confirm

    Examples: src
      | postType |
      | text     |

##  @sharepost
#  Scenario Outline: O: check share post with different privacy
#    When the user A in workspace1 create new post with privacy "<privacy>" and "<content>"
#    And the user B - the friend in workspace1 login "<emailB>" and <"pass">
#    And this user view this post and get content
#    And the user select view more option of new post
#    And click share button
#    And the user input text "<sharedPostType>" and "<shareContent>" and choose privacy "<sharedPrivacy>"
#    And the user C - the friend of B in workspace2 login "<emailC>" and <"pass">
#    Then this user see post with correct privacy and content
#    And the user D - the colleague of B login login "<emailD>" and <"pass">
#    Then this user see post with correct privacy and content
#    And the user E - the friend and colleague of B login "<emailE>" and <"pass">
#    Then this user see post with correct privacy and content
#    Examples: src
#      | privacy | content      | emailB                       | sharedPostType | shareContent          | sharedPrivacy | emailC               | emailD                         | emailD               | emailE | pass | userAviewOriginalContent | viewSharedContent |
#      | friends | post friends | nguyenvanhieu@mailinator.com | content        | Share post of friends | friends       | cafe24h01@cafe24h.gq | trangnguyen0011@mailinator.com | thuha@mailinator.com |        |


  @sharepost
  Scenario: Check share post with different privacy
    When the first user create post with privacy
      | privacy    | content           |
      | friends    | post with friends |
      | in_company | post in company   |
    And the second user login
    #the user B - the friend in workspace1 login
      | email                        | pass      |
      | nguyenvanhieu@mailinator.com | 12345678a |
    And share these post
      | postName          | sharedPostType | sharedContent                       | sharedPrivacy |
      | post with friends | text           | shared post with friend privacy     | friends       |
      | post in company   | text           | shared post with in company privacy | in_company    |
    And another user login and see post with correct privacy
      | email                          | pass      | viewSharedContent1 | viewOriginalContent1 |
      #the user C - the friend of B in workspace2
      | cafe24h01@cafe24h.gq           | 12345678a | yes                | no                   |
      #the user D - the colleague of B
      | trangnguyen0011@mailinator.com | 12345678a | no                 | no                   |
      #the user E - the friend and colleague of B
      | thuha@mailinator.com           | 12345678a | yes                | no                   |
      #the user F - is friend of A and B in workspace1
      | thaothoi@mailinator.com        | 12345678a | yes                | yes                  |
