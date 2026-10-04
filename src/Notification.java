public abstract class Notification {
    private final int id;
    private final String message;
    protected Channel channel;
    public Notification(int id, String message, Channel channel) {
        this.id = id;
        this.message = message;
        this.channel = channel;
    }

    protected abstract String buildText();
    public String execute() {
        return channel.deliver(buildText());
    }
    public void setImplementation(Channel newChannel) {
        this.channel = newChannel;
    }
    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Channel getChannel() {
        return channel;
    }
}