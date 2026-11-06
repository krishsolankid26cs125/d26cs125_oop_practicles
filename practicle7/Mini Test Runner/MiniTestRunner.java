import java.lang.reflect.Method;

public class MiniTestRunner {

    public static void runTests(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        int count = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Run.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error executing test: " + method.getName());
                }
            }
        }

        System.out.println("Total tests executed: " + count);
    }
}
