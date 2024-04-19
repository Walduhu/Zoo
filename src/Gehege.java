import java.util.ArrayList;

public class Gehege extends Tiere{

    private String tierart;
    private int maxTiere;
    private int anzahlTiere;
    private double maxGroesse; // m
    private String zugelasseneOberArt;
    private ArrayList<Tiere> tierArrayList;


    public Gehege() {}

    public Gehege(String tierart, int maxTiere, int anzahlTiere, double maxGroesse, String zugelasseneOberArt, ArrayList<Tiere> tierArrayList) {
        this.tierart = tierart;
        this.maxTiere = maxTiere;
        this.anzahlTiere = anzahlTiere;
        this.maxGroesse = maxGroesse;
        this.zugelasseneOberArt = zugelasseneOberArt;
        this.tierArrayList = tierArrayList;
    }

    public String getTierart() {
        return tierart;
    }

    public void setTierart(String tierart) {
        this.tierart = tierart;
    }

    public int getMaxTiere() {
        return maxTiere;
    }

    public void setMaxTiere(int maxTiere) {
        this.maxTiere = maxTiere;
    }

    public int getAnzahlTiere() {
        return anzahlTiere;
    }

    public void setAnzahlTiere(int anzahlTiere) {
        this.anzahlTiere = anzahlTiere;
    }

    public double getMaxGroesse() {
        return maxGroesse;
    }

    public void setMaxGroesse(double maxGroesse) {
        this.maxGroesse = maxGroesse;
    }

    public String getZugelasseneOberArt() {
        return zugelasseneOberArt;
    }

    public void setZugelasseneOberArt(String zugelasseneOberArt) {
        this.zugelasseneOberArt = zugelasseneOberArt;
    }

    public ArrayList<Tiere> getTierArrayList() {
        return tierArrayList;
    }

    public void setTierArrayList(ArrayList<Tiere> tierArrayList) {
        this.tierArrayList = tierArrayList;
    }
}
