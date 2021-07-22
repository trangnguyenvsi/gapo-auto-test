package gapo.pilot.auto2.constant;

public enum PrivacyPost {
    //instance of class PrivacyPost
    PRIVATE("Chỉ mình tôi"),
    FRIENDS("Bạn bè"),
    IN_COMPANY("Cùng công ty");

    //instance variable
    private final String privacy;

    PrivacyPost(String privacy) {
        this.privacy = privacy;
    }

    public String getPrivacy() {
        return privacy;
    }

}
