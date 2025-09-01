import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                System.out.printf("%-8s %-15s %-30s %-8s%n",
                        "ID#", "Name", "Description", "Cost");
                System.out.println(".¸.·°¯°·.¸.·°¯°·.¸.·°.¸.·°¯°·.¸.·°¯°·.¸.·°.¸.·°¯°·.¸.·°¯°·.¸.·°");

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] f = line.split(",\\s*");
                    if (f.length < 4) continue;
                    System.out.printf("%-8s %-15s %-30s %-8s%n",
                            f[0], f[1], f[2], f[3]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
