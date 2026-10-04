public class Main {
    private static int passed = 0;
    private static int total = 0;
    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equals("--demo")) {
            System.out.println("Usage: java -cp out Main --demo");
            return;
        }
        runDemo();
    }

    private static void runDemo() {
        String reminderText = "Meeting at 10:00";
        String alertText = "Server is down";
        Reminder r1 = new Reminder(1, reminderText, new EmailChannel());
        check("T1", "EMAIL: [envelope] Meeting at 10:00", r1.execute());
        Reminder r2 = new Reminder(1, reminderText, new SmsChannel());
        check("T2", "SMS: Meeting at 10:00", r2.execute());
        UrgentAlert a1 = new UrgentAlert(2, alertText, new EmailChannel());
        check("T3", "EMAIL: [envelope] URGENT: Server is down", a1.execute());
        UrgentAlert a2 = new UrgentAlert(2, alertText, new SmsChannel());
        check("T4", "SMS: URGENT: Server is down", a2.execute());
        Reminder reminder = new Reminder(5, reminderText, new EmailChannel());
        Reminder sameReminder = reminder;
        String first = reminder.execute();
        reminder.setImplementation(new SmsChannel());
        String second = reminder.execute();
        boolean sameObject = (reminder == sameReminder);
        boolean sameId = reminder.getId() == 5;
        boolean sameMessage = reminder.getMessage().equals(reminderText);
        boolean firstOk = first.equals("EMAIL: [envelope] Meeting at 10:00");
        boolean secondOk = second.equals("SMS: Meeting at 10:00");
        checkBool("T5", sameObject && sameId && sameMessage && firstOk && secondOk,
                "first=" + first + " | second=" + second + " | same object=" + sameObject);
        Reminder r3 = new Reminder(6, reminderText, new PushChannel());
        check("T6", "PUSH: [bell] Meeting at 10:00", r3.execute());
        UrgentAlert a3 = new UrgentAlert(7, alertText, new PushChannel());
        check("T7", "PUSH: [bell] URGENT: Server is down", a3.execute());
        System.out.println();
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void check(String name, String expected, String actual) {
        total++;
        boolean ok = expected.equals(actual);
        if (ok) {passed++;
            System.out.println(name + " PASS");
        } else {
            System.out.println(name + " FAIL");
        }
        System.out.println("  expected: " + expected);
        System.out.println("  actual:   " + actual);
    }

    private static void checkBool(String name, boolean ok, String info) {
        total++;
        if (ok) {
            passed++;
            System.out.println(name + " PASS");
        } else {
            System.out.println(name + " FAIL");
        }
        System.out.println("  " + info);
    }
}