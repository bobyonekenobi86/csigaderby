// Verseny.java
// A Verseny osztály felelős a csigaverseny lebonyolításáért.

// Készítette: Bobek Attila (XRF4PS)

import java.util.ArrayList;
import java.util.List;

public class Verseny {
    private List<Csiga> csigak;
    private int korokSzama;
    private int fogadas;

    public Verseny(int fogadas) {
        csigak = new ArrayList<>();
        csigak.add(new Csiga("Piros"));
        csigak.add(new Csiga("Zöld"));
        csigak.add(new Csiga("Kék"));
        korokSzama = 5;
        this.fogadas = fogadas;
    }

    public boolean inditVerseny() {
        System.out.println("\n--- CsigaDerby v1.0 ---\n");
        for (int i = 1; i <= korokSzama; i++) {
            System.out.println(i + ". kör:");
            for (Csiga csiga : csigak) {
                if (Math.random() < 0.2) {
                    System.out.println(csiga.getSzin() + " csiga gyorsítót kapott!");
                    csiga.mozog();
                }
                csiga.mozog();
                megjelenites(csiga);
            }
            System.out.println();
        }

        return kiertekelesEsEredmenyHirdetes();
    }

    private void megjelenites(Csiga csiga) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s", csiga.getSzin()));
        sb.append("[");
        for (int i = 0; i < csiga.getPozicio(); i++) {
            sb.append("_");
        }
        sb.append(Csiga.getSzimbolum());
        sb.append("]");
        System.out.println(sb.toString());
    }

    private boolean kiertekelesEsEredmenyHirdetes() {
        List<Csiga> gyoztesek = new ArrayList<>();
        int maxTavolsag = 0;

        for (Csiga csiga : csigak) {
            if (csiga.getPozicio() > maxTavolsag) {
                gyoztesek.clear();
                gyoztesek.add(csiga);
                maxTavolsag = csiga.getPozicio();
            } else if (csiga.getPozicio() == maxTavolsag) {
                gyoztesek.add(csiga);
            }
        }

        if (gyoztesek.size() == 1) {
            System.out.println("A győztes: " + gyoztesek.get(0).getSzin() + " csiga!");
        } else {
            System.out.println("Döntetlen! A győztesek:");
            for (Csiga gyoztes : gyoztesek) {
                System.out.println("- " + gyoztes.getSzin() + " csiga");
            }
        }

        String fogadottSzin = csigak.get(fogadas - 1).getSzin();
        boolean nyert = gyoztesek.stream().anyMatch(csiga -> csiga.getSzin().equals(fogadottSzin));
        if (nyert) {
            System.out.println("Gratulálok, nyertél a fogadáson! :)");
        } else {
            System.out.println("Sajnos nem nyertél a fogadáson. :(");
        }

        return nyert;
    }
}
