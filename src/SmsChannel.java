public class SmsChannel implements Channel {
    @Override
    public String getName() {
        return "SMS";
    }
    @Override
    public String deliver(String text) {
        String oneLine = text.replace("\n", " ");
        return "SMS: " + oneLine;
    }
}