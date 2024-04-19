public class Landtiere extends Tiere {

    private String landtierArt;
    private boolean nachtaktiv;
    private int lebenserwartung; // Jahre

    public Landtiere() {}

    public Landtiere(double groesse, int futtermenge, String futterart, int platzbedarf, String landtierArt, boolean nachtaktiv, int lebenserwartung) {
        super(groesse, futtermenge, futterart, platzbedarf);
        this.landtierArt = landtierArt;
        this.nachtaktiv = nachtaktiv;
        this.lebenserwartung = lebenserwartung;
    }

    public String getLandtierArt() {
        return landtierArt;
    }

    public void setLandtierArt(String landtierArt) {
        this.landtierArt = landtierArt;
    }

    public boolean isNachtaktiv() {
        return nachtaktiv;
    }

    public void setNachtaktiv(boolean nachtaktiv) {
        this.nachtaktiv = nachtaktiv;
    }

    public int getLebenserwartung() {
        return lebenserwartung;
    }

    public void setLebenserwartung(int lebenserwartung) {
        this.lebenserwartung = lebenserwartung;
    }

}
