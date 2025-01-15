// Csiga.java
// A  Csiga osztály reprezentálja a versenyben résztvevő csigákat.

// Készítette: Bobek Attila (XRF4PS)

public class Csiga {
    private String szin;
    private int pozicio;
    private static final String SZIMBOLUM = "๑ï";

    public Csiga(String szin) {
        this.szin = szin;
        this.pozicio = 0;
    }

    public void mozog() {
        pozicio += (int) (Math.random() * 4);
    }

    public String getSzin() {
        return szin;
    }

    public int getPozicio() {
        return pozicio;
    }

    public static String getSzimbolum() {
        return SZIMBOLUM;
    }
}
