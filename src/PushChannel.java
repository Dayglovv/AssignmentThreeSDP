public class PushChannel implements Channel {
    @Override
    public String getName() {
        return "Push";
    }
    @Override
    public String deliver(String text) {
        return "PUSH: [bell] " + text;
    }
}