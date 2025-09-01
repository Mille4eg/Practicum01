import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();

        while (true) {
            String id = SafeInput.getNonZeroLenString("Enter ID");
            String first = SafeInput.getNonZeroLenString("Enter First Name");
            String last = SafeInput.getNonZeroLenString("Enter Last Name");
            String title = SafeInput.getNonZeroLenString("Enter Title");
            int yob = SafeInput.getRangedInt("Enter Year of Birth", 1000, 3000);

            String record = String.format("%s, %s, %s, %s, %d", id, first, last, title, yob);
            people.add(record);

            boolean more = SafeInput.getYNConfirm("More party members?");
            if (!more) break;
        }

        String fileName = SafeInput.getNonZeroLenString("Enter output file name (e.g., PersonTestData.txt)");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (String person : people) {
                writer.write(person);
                writer.newLine();
            }
            System.out.println("We be saving this as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
