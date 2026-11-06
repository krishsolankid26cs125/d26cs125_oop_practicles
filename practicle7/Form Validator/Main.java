import java.util.List;

public class Main {
    public static void main(String[] args) {
        SignupForm form1 = new SignupForm(
                "Mann Patel", "mannpatel", "mann@example.com");

        SignupForm form2 = new SignupForm(
                "", "thisusernameiswaytoolong", "");

        System.out.println("Validating Form 1:");
        List<String> errors1 = FormValidator.validate(form1);
        if (errors1.isEmpty()) {
            System.out.println("Form is valid!");
        } else {
            errors1.forEach(System.out::println);
        }

        System.out.println("\nValidating Form 2:");
        List<String> errors2 = FormValidator.validate(form2);
        if (errors2.isEmpty()) {
            System.out.println("Form is valid!");
        } else {
            errors2.forEach(System.out::println);
        }
    }
}
