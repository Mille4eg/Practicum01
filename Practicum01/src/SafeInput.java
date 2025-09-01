import java.util.Scanner;

public class SafeInput {
    private static final Scanner in = new Scanner(System.in);

    public static String getNonZeroLenString(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = in.nextLine().trim();
        } while (input.length() == 0);
        return input;
    }

    public static int getRangedInt(String prompt, int low, int high) {
        int val = 0;
        boolean ok = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (in.hasNextInt()) {
                val = in.nextInt();
                if (val >= low && val <= high) ok = true;
            } else {
                in.next(); // toss bad token
            }
        } while (!ok);
        in.nextLine(); // clear leftover newline
        return val;
    }

    public static double getDouble(String prompt) {
        double val = 0;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            if (in.hasNextDouble()) {
                val = in.nextDouble();
                ok = true;
            } else {
                in.next(); // toss bad token
            }
        } while (!ok);
        in.nextLine(); // clear leftover newline
        return val;
    }

    public static boolean getYNConfirm(String prompt) {
        String resp;
        do {
            System.out.print(prompt + " [Y/N]: ");
            resp = in.nextLine().trim().toUpperCase();
        } while (!resp.equals("Y") && !resp.equals("N"));
        return resp.equals("Y");
    }
}
