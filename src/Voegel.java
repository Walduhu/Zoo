public class Voegel extends Tiere {

    private String vogelArt;
    private String herkunftsland;
    private int fluegelspannweite; // cm

    public Voegel() {}

    public Voegel(double groesse, int futtermenge, String futterart, int platzbedarf, String vogelArt, String herkunftsland, int fluegelspannweite) {
        super(groesse, futtermenge, futterart, platzbedarf);
        this.vogelArt = vogelArt;
        this.herkunftsland = herkunftsland;
        this.fluegelspannweite = fluegelspannweite;
    }

    public String getVogelArt() {
        return vogelArt;
    }

    public void setVogelArt(String vogelArt) {
        this.vogelArt = vogelArt;
    }

    public String getHerkunftsland() {
        return herkunftsland;
    }

    public void setHerkunftsland(String herkunftsland) {
        this.herkunftsland = herkunftsland;
    }

    public int getFluegelspannweite() {
        return fluegelspannweite;
    }

    public void setFluegelspannweite(int fluegelspannweite) {
        this.fluegelspannweite = fluegelspannweite;
    }

}
