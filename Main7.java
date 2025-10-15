package mynewproject;

import java.util.LinkedHashMap;

public class Main7 {
  public static void main(String[] args) {
    LinkedHashMap<String, String> capitalCities = new LinkedHashMap<>();

    capitalCities.put("England", "London");
    capitalCities.put("India", "New Dehli");
    capitalCities.put("Austria", "Wien");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("Norway", "Oslo"); // Duplicate
    capitalCities.put("USA", "Washington DC");

    System.out.println(capitalCities);
  }
}