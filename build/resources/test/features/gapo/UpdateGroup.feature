@UpdateOnGroup
Feature: Update On Group

  @UpdateCoverOnGroup
  Scenario: update cover
    Given the user update cover on page
    When the user del cover on page

  @UpdateBackgroundGroup
  Scenario: update background on group
    Given the user update background on page
    When the user del background on page

  @UpdateSettingGroup
  Scenario: update setting on group
    When the user update noti
    When the user update follow

  @UpdateIntroAndInviteFr
  Scenario: update intro of group and invite fr join group
    Given the user update intro
    When the user invite fr join group

  @UpdateNameAndRuleGroup
  Scenario: edit name and rule of group
    Given the user go to setting group
    When the user edit name of group
    When the user edit rule of group

  @AcceptRequetsJoinAndDeleteMemberOnGroup
  Scenario: accept requets join group and delete member group
    Given the user accept requets
    When the user delete member group

  @AccpetPostAndPinPost
  Scenario: accept requet post and pin post
    Given the user accept post
    When the user pin post