package gapo.pilot.auto2.constant;

public enum BackgroundPost {
    COVID("covid", "866ad07a-6d89-4233-a1f8-e085eed97ec9"),
    WHILE_LEAF("white_leaf", "fb009ca1-d40d-4722-a082-6b097f60768e"),
    ORANGE("orange", "8af29e58-2606-43d2-a033-02a00704ef3c"),
    WHITE_CLOUD("white_cloud", "06a0f48e-5d06-48ab-a974-048141e8c0cd");

    private final String name;
    private final String id;

    BackgroundPost(String name, String id) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
