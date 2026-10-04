public class Reminder extends Notification {
    public Reminder(int id, String message, Channel channel) {
        super(id, message, channel);
    }
    @Override
    protected String buildText() {
        return getMessage();
    }
}