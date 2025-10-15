package mynewproject;

import java.util.*;

public class Main0 {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("Liam");
    names.add("Jenny");
    names.add("Kasper");
    names.add("Angie");

    Collections.sort(names); // must be sorted first
    int index = Collections.binarySearch(names, "Angie");
    System.out.println("Angie is at index: " + index);
  }
}