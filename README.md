# Java CLI Weather App

A lightweight, command-line weather application built in Java that fetches real-time meteorological data for any city worldwide using the OpenWeatherMap API[cite: 1, 2, 3].

---

## Features
* **Global City Search:** Query current weather conditions for any city worldwide with automatic URL encoding for spaces and special characters[cite: 1, 2].
* **Detailed Atmospheric Metrics:** Retrieves and displays current temperature in Fahrenheit, weather description capitalized for readability, humidity percentage, and wind speed[cite: 3].
* **Interactive Loop:** Prompts the user continuously, allowing multiple searches in a single session without restarting the application[cite: 2].
* **Robust Error Handling:** Validates HTTP response codes and catches connection exceptions gracefully[cite: 3].

---

## Project Structure
* `WeatherApp.java` — The entry point and main execution loop handling user prompts[cite: 2].
* `WeatherFetcher.java` — Connects to the OpenWeatherMap REST API, parses JSON payloads using `org.json`, and formats console outputs[cite: 3].
* `UserInput.java` — Manages safe console input collection and string sanitization for URL formatting[cite: 1].

---

## Tech Stack & Dependencies
* **Language:** Java (JDK 8+)
* **API:** OpenWeatherMap Current Weather Data API[cite: 3]
* **Library:** `org.json` for parsing JSON responses[cite: 3]

---

## How to Run
1. Have a Java Development Kit (JDK), or a common compiler (like IntelliJ) installed.
2. Make sure you have the `org.json` library jar included in your project build path/classpath.
3. Compile all source files:
   ```bash
   javac WeatherApp.java WeatherFetcher.java UserInput.java
