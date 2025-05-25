import java.io.*;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        // Use try-with-resources for Scanner to ensure it is closed automatically
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the full path of the file (e.g., This Pc\\\\Documents\\\\practice.txt): ");
            String filePath = sc.nextLine();

            File file = new File(filePath);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("❌ File not found! Please check the path and try again.");
                return;
            }

            // Use try-with-resources to read the file safely
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("\n✅ Contents of the file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("❌ An error occurred while reading the file.");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("❌ Unexpected error.");
            e.printStackTrace();
        }
    }
}
