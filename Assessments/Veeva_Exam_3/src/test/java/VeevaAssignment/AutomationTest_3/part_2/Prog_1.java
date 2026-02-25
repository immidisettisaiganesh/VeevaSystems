package VeevaAssignment.AutomationTest_3.part_2;

import java.util.*;

public class Prog_1 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, HashMap<String, String>> hm = new HashMap<>();

        System.out.println("Enter number of countries:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter country name:");
            String country = sc.next();

            System.out.println("Enter number of capitals:");
            int k = sc.nextInt();

            HashMap<String, String> capitals = new HashMap<>();

            if (k >= 1) {
                System.out.println("Enter winter capital:");
                capitals.put("winter", sc.next());
            }
            if (k >= 2) {
                System.out.println("Enter summer capital:");
                capitals.put("summer", sc.next());
            }
            if (k == 3) {
                System.out.println("Enter rainy capital:");
                capitals.put("rainy", sc.next());
            }

            hm.put(country, capitals);
        }

        System.out.println("\nChoose Query (1-7):");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                printAllData(hm);
                break;

            case 2:
                System.out.println("Enter country name:");
                String name = sc.next();
                printCountry(hm, name);
                break;

            case 3:
                printCountriesByCapitalCount(hm, 2);
                break;

            case 4:
                printCountriesByCapitalCount(hm, 3);
                break;

            case 5:
                countriesWithoutSummer(hm);
                break;

            case 6:
                capitalsOfCountriesStartingWithVowel(hm);
                break;

            case 7:
                summerCapitalsOfVowelCountries(hm);
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
    public static void printAllData(HashMap<String, HashMap<String, String>> hm) {

        for (Map.Entry<String, HashMap<String, String>> entry : hm.entrySet()) {

            System.out.println("Country: " + entry.getKey());
            System.out.println("No of Capitals: " + entry.getValue().size());

            for (Map.Entry<String, String> cap : entry.getValue().entrySet()) {
                System.out.println(cap.getKey() + " capital: " + cap.getValue());
            }

            System.out.println("--------------------");
        }
    }
    public static void printCountry(HashMap<String, HashMap<String, String>> hm, String country) {

        if (hm.containsKey(country)) {

            HashMap<String, String> caps = hm.get(country);

            System.out.println("No of Capitals: " + caps.size());

            for (Map.Entry<String, String> entry : caps.entrySet()) {
                System.out.println(entry.getKey() + " capital: " + entry.getValue());
            }

        } else {
            System.out.println("Country not found");
        }
    }
    public static void printCountriesByCapitalCount(HashMap<String, HashMap<String, String>> hm, int count) {

        for (Map.Entry<String, HashMap<String, String>> entry : hm.entrySet()) {

            if (entry.getValue().size() == count) {
                System.out.println(entry.getKey());
            }
        }
    }
    public static void countriesWithoutSummer(HashMap<String, HashMap<String, String>> hm) {

        for (Map.Entry<String, HashMap<String, String>> entry : hm.entrySet()) {

            if (!entry.getValue().containsKey("summer")) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void capitalsOfCountriesStartingWithVowel(HashMap<String, HashMap<String, String>> hm) {

        for (Map.Entry<String, HashMap<String, String>> entry : hm.entrySet()) {

            if (startsWithVowel(entry.getKey())) {

                System.out.println("Country: " + entry.getKey());

                for (String capital : entry.getValue().values()) {
                    System.out.println("Capital: " + capital);
                }
            }
        }
    }
    public static void summerCapitalsOfVowelCountries(HashMap<String, HashMap<String, String>> hm) {

        for (Map.Entry<String, HashMap<String, String>> entry : hm.entrySet()) {

            if (startsWithVowel(entry.getKey())
                    && entry.getValue().containsKey("summer")) {

                System.out.println("Country: " + entry.getKey());
                System.out.println("Summer Capital: "
                        + entry.getValue().get("summer"));
            }
        }
    }
    public static boolean startsWithVowel(String str) {

        char ch = Character.toLowerCase(str.charAt(0));
        return (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u');
    }
}