import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                System.out.printf("%-8s %-12s %-12s %-6s %-4s%n",
                        "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println(".¸.·°¯°·.¸.·°¯°·.¸.·°.¸.·°¯°·.¸.·°¯°·.¸.·°.¸.·°¯°·.¸.·°¯°·.¸.·°");

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] f = line.split(",\\s*");
                    if (f.length < 5) continue; // skip bad lines just in case
                    System.out.printf("%-8s %-12s %-12s %-6s %-4s%n",
                            f[0], f[1], f[2], f[3], f[4]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
