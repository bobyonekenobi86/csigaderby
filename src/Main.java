// Main.java
// A Main osztály tartalmazza a program belépési pontját és a játék vezérlését.

// Készítette: Bobek Attila (XRF4PS)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ujraJatszik = true;

        while (ujraJatszik) {
            System.out.println("Üdvözöllek a CsigaDerby v1.0 játékban!");
            String fogadas = bekeresEsEllenorzes(scanner);

            System.out.println("Fogadásod a " + getSzinTeljesNev(fogadas) + " csigára érkezett.");

            Verseny verseny = new Verseny(getSzinIndex(fogadas));
            boolean nyert = verseny.inditVerseny();

            System.out.print("Szeretnél újra játszani? (i/n): ");
            String valasz = scanner.next().toLowerCase();
            ujraJatszik = valasz.equals("i");
        }

        System.out.println("Köszönöm, hogy játszottál!");
        scanner.close();
    }

    private static String bekeresEsEllenorzes(Scanner scanner) {
        String fogadas;

        do {
            System.out.println("Melyik csigára szeretnél fogadni?");
            System.out.println("p - Piros");
            System.out.println("z - Zöld");
            System.out.println("k - Kék");
            System.out.print("Válassz egy betűt (p/z/k): ");

            fogadas = scanner.next().toLowerCase();

            if (!fogadas.equals("p") && !fogadas.equals("z") && !fogadas.equals("k")) {
                System.out.println("Érvénytelen választás. Kérlek, válassz p, z vagy k közül.");
            }
        } while (!fogadas.equals("p") && !fogadas.equals("z") && !fogadas.equals("k"));

        return fogadas;
    }

    private static String getSzinTeljesNev(String betujel) {
        switch (betujel) {
            case "p": return "piros";
            case "z": return "zöld";
            case "k": return "kék";
            default: return "";
        }
    }

    private static int getSzinIndex(String betujel) {
        switch (betujel) {
            case "p": return 1;
            case "z": return 2;
            case "k": return 3;
            default: return 0;
        }
    }
}
