package gapo.pilot.auto2.constant;

import java.util.EnumMap;

public class NotificatinType {
    public enum NotificationType {
        TAG,TAG_2, POST
    }

    public EnumMap mapNotificationTypeToContent(String tagNumber, String content){
        EnumMap<NotificationType, String> notiContentMap  = new EnumMap<>(NotificationType.class);
        notiContentMap.put(NotificationType.TAG, "đã gắn thẻ bạn và " +tagNumber+ " người khác trong một bài viết" + "\n" + "vừa xong");
        notiContentMap.put(NotificationType.POST,"đã đăng một bài viết mới: "+content);

        return notiContentMap;
    }
}
