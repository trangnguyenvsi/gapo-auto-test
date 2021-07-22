package gapo.pilot.auto2.pages.notification;

import gapo.pilot.auto2.constant.NotificatinType;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.EnumMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NotificationVerify extends UIInteractionSteps {
    NotificationAction notificationAct;
    NotificatinType notificationConst;

    @Step("verify avatar on noti")
    public NotificationVerify verifyAvatarOnEachNotification(String receivedNoti, String avatarCreatePost) {
        //if having noti
        if ($(NotificationElement.FIRST_NOTI_AVATAR).isPresent()) {
            String avatarNoti = notificationAct.getFirstAvatarNotification();
            if (receivedNoti.equalsIgnoreCase("yes")) {
                assertThat(avatarNoti.equalsIgnoreCase(avatarCreatePost)).isTrue();
            } else {
                assertThat(avatarNoti.equalsIgnoreCase(avatarCreatePost)).isFalse();
            }
        }
        //not having any noti
        else {
            if (receivedNoti.equalsIgnoreCase("no")) {
                assertThat($(NotificationElement.FIRST_NOTI_AVATAR).isPresent()).isFalse();
            }
        }
        return this;
    }

    public String getExpectedNotiContentByType(String userPost, String number, String notiType, String postContent) {
        //get noti content from noti type
        notificationConst = new NotificatinType();
        String expectedNotiContent = "";
        //get noti content from enum
        EnumMap notiMap = notificationConst.mapNotificationTypeToContent(number, postContent);
        String notiContent = "";
        switch (notiType) {
            case "tag":
                notiContent = notiMap.get(NotificatinType.NotificationType.TAG).toString();
                //expected noti content
                expectedNotiContent = userPost + " " + notiContent;
                System.out.println("Expected Noti Tag content:" + expectedNotiContent);
                break;
            case "post":
                notiContent = notiMap.get(NotificatinType.NotificationType.POST).toString();
                //expected noti content
                expectedNotiContent = userPost + " " + notiContent;
                System.out.println("Expected Noti Post content:" + expectedNotiContent);
                break;
            default:
        }
        return expectedNotiContent;
    }


    @Step("verify notification of tag post")
    public NotificationVerify verifyNotificationContent(String receivedNoti, String userPost, String tagNumber, String notiType, String postContent) {
        //if having notification
        if (notificationAct.getPresentStatusOfTagNoti()) {
            //get actual noti content
            String actualNotiContent = null;
            int sizeOfNotiList;
            switch (notiType) {
                case "tag":
                    actualNotiContent = notificationAct.getFirstContentOfTagNotiList();
                    sizeOfNotiList = notificationAct.getSizeOfTagNotiList();
                    break;
                case "post":
                    actualNotiContent = notificationAct.getFirstContentOfPostNotiList();
                    sizeOfNotiList = notificationAct.getSizeOfPostNotiList();
                    break;
            }

            System.out.println("Actual noti Tag content:" + actualNotiContent);
            //get expected noti content
            String expectedNotiContent = getExpectedNotiContentByType(userPost, tagNumber, notiType, postContent);
            //if user should get the noti
            if (receivedNoti.equalsIgnoreCase("yes")) {
                switch (notiType) {
                    case "tag":
                        String delayContent = expectedNotiContent.replace("vừa xong","1 phút trước");
                        System.out.println("Delay content:"+delayContent);
                        assertThat(actualNotiContent.equals(expectedNotiContent)||actualNotiContent.equalsIgnoreCase(delayContent)).isTrue();
                        break;
                    case "post":
                        assertThat(actualNotiContent.contains(expectedNotiContent)).isTrue();
                        break;
                }

            } else {
                assertThat(actualNotiContent.equals(expectedNotiContent)).isFalse();
            }
        }
        return this;
    }

}
