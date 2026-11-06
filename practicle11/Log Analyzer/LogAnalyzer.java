// Demonstrates file reading, keyword counting, and file attributes
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;
 
public class LogAnalyzer {
 
    public static void main(String[] args) {
 
        // Names of the log files to analyze
        String[] fileNames = {
            "log1.txt",
            "log2.txt",
            "log3.txt"
        };
 
        // Keyword to search across all files
        String keyword = "ERROR";
 
        int totalLines = 0;
        int totalKeywordCount = 0;
 
        try {
            // Create sample log files
            Files.write(Paths.get("log1.txt"),
                    ("INFO: Application started\\n" +
                     "ERROR: Database connection failed\\n" +
                     "INFO: Retry successful\\n").getBytes());
 
            Files.write(Paths.get("log2.txt"),
                    ("INFO: User logged in\\n" +
                     "ERROR: Invalid request\\n").getBytes());
 
            Files.write(Paths.get("log3.txt"),
                    ("INFO: Processing data\\n" +
                     "INFO: Task completed\\n" +
                     "ERROR: Timeout occurred\\n").getBytes());
 
            System.out.println("Log files created successfully.\\n");
 
            // Analyze each file
            for (String fileName : fileNames) {
 
                Path path = Paths.get(fileName);
                int fileLines = 0;
                int keywordCount = 0;
 
                // Read the file line by line
                try (Stream<String> lines = Files.lines(path)) {
                    for (String line : (Iterable<String>) lines::iterator) {
                        fileLines++;
 
                        if (line.contains(keyword)) {
                            keywordCount++;
                        }
                    }
                }
 
                totalLines += fileLines;
                totalKeywordCount += keywordCount;
 
                // Read file attributes
                BasicFileAttributes attributes =
                        Files.readAttributes(
                            path, BasicFileAttributes.class);
 
                System.out.println("File: " + fileName);
                System.out.println("Lines: " + fileLines);
                System.out.println("Keyword occurrences: " + keywordCount);
                System.out.println("File size: " +
                        attributes.size() + " bytes");
                System.out.println("-----------------------------");
            }
 
            // Display overall analysis summary
            System.out.println("\\n===== LOG ANALYSIS SUMMARY =====");
            System.out.println("Total lines: " + totalLines);
            System.out.println("Total ERROR occurrences: " +
                    totalKeywordCount);
 
        } catch (IOException e) {
            System.out.println("Error analyzing files: " + e.getMessage());
        }
    }
}
