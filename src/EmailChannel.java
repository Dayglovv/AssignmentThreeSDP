public class EmailChannel implements Channel {
    @Override
    public String getName() {
        return "Email";
    }
    @Override
    public String deliver(String text) {
        return "EMAIL: [envelope] " + text;
    }
}