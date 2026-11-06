import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CSVMapper {

    public static <T> T map(String fileName, Class<T> clazz)
            throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String headerLine = br.readLine();

        if (headerLine == null) {
            br.close();
            throw new Exception("CSV file is empty");
        }

        String[] headers = headerLine.split(",");
        String dataLine = br.readLine();

        if (dataLine == null) {
            br.close();
            throw new Exception("No data found in CSV file");
        }

        String[] values = dataLine.split(",");
        Map<String, String> data = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {
            data.put(headers[i].trim(), values[i].trim());
        }

        T obj = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();

                if (data.containsKey(columnName)) {
                    field.setAccessible(true);
                    field.set(obj, data.get(columnName));
                } else {
                    System.out.println("Missing column: " + columnName);
                }
            }
        }

        br.close();
        return obj;
    }
}
