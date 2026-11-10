import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherFetcher {

    private final String API_KEY = "add your own API";  // Add your own API to fetch weather data!

    public void showForecast(String city) {
        String choice;
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&units=imperial&appid=" + API_KEY;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                JSONObject json = new JSONObject(response.toString());

                String cityName = json.getString("name");
                JSONObject main = json.getJSONObject("main");
                JSONArray weatherArray = json.getJSONArray("weather");
                JSONObject weather = weatherArray.getJSONObject(0);
                JSONObject wind = json.getJSONObject("wind");

                double temp = main.getDouble("temp");
                int humidity = main.getInt("humidity");
                String description = weather.getString("description");
                double windSpeed = wind.getDouble("speed");

                System.out.println("\n🌤️  Forecast for " + cityName + ":");
                System.out.println("Temperature: " + temp + "°F");
                System.out.println("Condition: " + capitalize(description));
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Wind Speed: " + windSpeed + " mph");

            } else {
                System.out.println("Error: HTTP response code " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Could not fetch weather for " + city);
            e.printStackTrace();
        }
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}
