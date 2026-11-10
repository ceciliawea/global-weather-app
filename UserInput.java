import java.util.Scanner;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        String choice;
        System.out.print(prompt);
        return scanner.nextLine().trim().replaceAll(" ", "%20");
    }


    public void closeScanner() {
        scanner.close();
    }
}
