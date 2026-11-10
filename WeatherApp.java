import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherFetcher fetcher = new WeatherFetcher();
        UserInput input = new UserInput();

        System.out.println("Welcome to the Local Weather App!");

        String again;
        do {
            String city = input.getString("Enter a city: ");
            fetcher.showForecast(city);

            System.out.print("\nWould you like to check another city? (yes/no): ");
            again = scanner.nextLine().trim().toLowerCase();
        } while (again.equals("yes"));

        System.out.println("Thanks for using the Weather App! ☀️");
        scanner.close();
    }
}
