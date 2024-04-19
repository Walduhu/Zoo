public abstract class Tiere implements Alle {

    private double groesse; // m
    private int futtermenge; // kg pro Monat
    private String futterart;
    private int platzbedarf; // qm

    public Tiere() {
    }

    public Tiere(double groesse, int futtermenge, String futterart, int platzbedarf) {
        this.groesse = groesse;
        this.futtermenge = futtermenge;
        this.futterart = futterart;
        this.platzbedarf = platzbedarf;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public int getFuttermenge() {
        return futtermenge;
    }

    public void setFuttermenge(int futtermenge) {
        this.futtermenge = futtermenge;
    }

    public String getFutterart() {
        return futterart;
    }

    public void setFutterart(String futterart) {
        this.futterart = futterart;
    }

    public int getPlatzbedarf() {
        return platzbedarf;
    }

    public void setPlatzbedarf(int platzbedarf) {
        this.platzbedarf = platzbedarf;
    }

    // Hilfsmethode zum Hinzufügen eines Tiers zu Gehege
    public boolean hasSameProperties(Tiere other) {
        if (other == null) {
            return false;
        }
        return this.getGroesse() == other.getGroesse() && this.getFuttermenge() == other.getFuttermenge();
    }

    @Override
    public void printMe() {

        // Objekt ist Landtier oder Vogel
        if (this instanceof Landtiere || this instanceof Voegel) {

            // Unterscheidung ob Objekt ein Landtier oder Vogel ist
            if (this instanceof Landtiere landtier) {
                System.out.print(Main.CYAN + "\nArt: " + landtier.getLandtierArt() + Main.RESET + "\nNachtaktiv: " + landtier.isNachtaktiv() +
                        "\nLebenserwartung: " + landtier.getLebenserwartung() + " Jahre");
            } else {
                Voegel vogel = (Voegel) this;
                System.out.print(Main.CYAN + "\nArt: " + vogel.getVogelArt() + Main.RESET + "\nHerkunftsland: " + vogel.getHerkunftsland() +
                        "\nFlügelspannweite: " + vogel.getFluegelspannweite() + " cm");
            }
            System.out.print("\nGröße: " + getGroesse() + " m" + "\nFuttermenge: " + getFuttermenge() + " kg pro Monat\nFutterart: " +
                    getFutterart() + "\nPlatzbedarf: " + getPlatzbedarf() + " qm");
        } else { // Objekt kann nur noch Gehege sein, wenn es weder Landtier noch Vogel ist
            Gehege gehege = (Gehege) this;
            System.out.print(Main.CYAN + "\nArt: " + gehege.getTierart() + Main.RESET + "\nMaximale Anzahl Tiere: " + gehege.getMaxTiere() + "\nDerzeitige Anzahl Tiere: " + gehege.getAnzahlTiere() +
                    "\nMaximale Größe der Tiere: " + gehege.getMaxGroesse() + " m\nZugelassene Oberart: " + gehege.getZugelasseneOberArt() +
                    "\nTiere im Gehege: " + Main.BLUE + gehege.getTierArrayList() + Main.RESET);
        }

    }
}
