import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FormValidator {

    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " must not be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = field.getAnnotation(MaxLength.class);
                    int maxLength = annotation.value();

                    if (value != null && value.toString().length() > maxLength) {
                        errors.add(field.getName() + " exceeds maximum length of " + maxLength);
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Unable to access field: " + field.getName());
            }
        }
        return errors;
    }
}

