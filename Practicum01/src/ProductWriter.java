import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();

        while (true) {
            String id = SafeInput.getNonZeroLenString("Enter Product ID");
            String name = SafeInput.getNonZeroLenString("Enter Product Name");
            String desc = SafeInput.getNonZeroLenString("Enter Description");
            double cost = SafeInput.getDouble("Enter Cost");

            String record = String.format("%s, %s, %s, %.2f", id, name, desc, cost);
            products.add(record);

            boolean more = SafeInput.getYNConfirm("Add another product?");
            if (!more) break;
        }

        String fileName = SafeInput.getNonZeroLenString("Enter output file name (e.g., ProductTestData.txt)");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
            System.out.println("File saved as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
