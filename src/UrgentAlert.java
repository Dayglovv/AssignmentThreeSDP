public class UrgentAlert extends Notification {
    public UrgentAlert(int id, String message, Channel channel) {
        super(id, message, channel);
    }
    @Override
    protected String buildText() {
        return "URGENT: " + getMessage();
    }
}