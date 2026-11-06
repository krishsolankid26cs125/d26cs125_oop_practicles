@FunctionalInterface
interface Notifier {
    void send(String message);
}
 
@FunctionalInterface
interface Urgent {
    void sendUrgent(Notifier notifier, String message);
}
 
public class NotificationDemo {
 
    public static void main(String[] args) {
 
        Notifier email = message ->
            System.out.println("Email Notification: " + message);
 
        Notifier sms = message ->
            System.out.println("SMS Notification: " + message);
 
        Notifier[] senders = { email, sms };
 
        System.out.println("Normal Notification:");
 
        for (Notifier sender : senders) {
            sender.send("Hello! This is a notification.");
        }
 
        Urgent urgentNotification = (notifier, message) -> {
            notifier.send(message);
            notifier.send(message);
        };
 
        System.out.println("\nUrgent Notification:");
 
        urgentNotification.sendUrgent(
            email,
            "URGENT! Please respond immediately."
        );
    }
}
