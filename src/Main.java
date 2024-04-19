/**
 * PT Java Semester 2
 * Projekt Zoo
 * Hauptklasse des Programms
 * @author Benjamin Schwarz
 * @version 18.03.24
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    // für mehr Übersichtlichkeit der Ausgaben:
    // globale Variablen für farbige System.out.println()-Ausgabe
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String CYAN_BG = "\u001B[46m";

    // globale ArrayList für alle Tiere
    public static ArrayList<Tiere> alleTiere = instantiateAnimals();

    // globale ArrayList für alle Gehege
    public static ArrayList<Gehege> alleGehege = instantiateGehege();

    public static void main(String[] args) {
        menu();
    }

    // Ausgabe Hauptmenü (Tipp: Cursor auf Methode, F4 für Sprung zu Methode)
    public static void menu() {
        System.out.println("\n" + GREEN + "Willkommen im Zoo-Management-System (ZMS)" +
                "\n-----------------------------------------" + RESET +
                CYAN + "\n\nBitte wählen Sie eine Option:" + RESET +
                PURPLE + "\n\n0) " + RESET + "Neues Tier hinzufügen" +
                PURPLE + "\n1) " + RESET + "Alle Tiere anzeigen" +
                PURPLE + "\n2) " + RESET + "Tier aus dem Zoo entfernen" +
                PURPLE + "\n3) " + RESET + "Neues Gehege hinzufügen" +
                PURPLE + "\n4) " + RESET + "Alle Gehege anzeigen" +
                PURPLE + "\n5) " + RESET + "Alle Tiere eines Geheges anzeigen" +
                PURPLE + "\n6) " + RESET + "Tier einem Gehege zuordnen" +
                PURPLE + "\n7) " + RESET + "Tier aus Gehege entfernen" +
                PURPLE + "\n8) " + RESET + "Gehege löschen" +
                PURPLE + "\n9) " + RED + "Programm beenden\n" + RESET);

        String userInput = new Scanner(System.in).nextLine();
        switch (userInput) {
            case "0":
                addAnimal();
                break;
            case "1":
                printAnimals();
                break;
            case "2":
                deleteAnimal();
                break;
            case "3":
                addGehege();
                break;
            case "4":
                printGehege();
                break;
            case "5":
                animalsOfGehege();
                break;
            case "6":
                allocateAnimalToGehege();
                break;
            case "7":
                deleteAnimalFromGehege();
                break;
            case "8":
                deleteGehege();
                break;
            case "9":
                exit();
            default:
                System.out.println("\n" + RED_BG + BLACK + "Falsche Eingabe, bitte versuchen Sie es noch einmal." + RESET);
                menu();
        }
        pressEnter();
    }

    // User muss nach dem Beenden jeder Methode Enter drücken, um zum Hauptmenü zurückzukehren
    private static void pressEnter() {
        System.out.println("\n\n" + CYAN_BG + BLACK + "Enter drücken um ins Hauptmenü zurückzukehren..." + RESET);
        new Scanner(System.in).nextLine();
        menu();
    }

    // Methode zum Programm beenden
    private static void exit() {
        System.out.println(CYAN_BG + BLACK + "Das ZMS ist beendet" + RESET);
        System.exit(0);
    }

    // Tier-Objekt zu alleTiere-ArrayList hinzufügen
    private static void addAnimal() {

        System.out.println(GREEN + "\nDem Zoo ein Tier hinzufügen\n---------------------------" + RESET);
        System.out.println(CYAN + "Ist das neue Tier" + RESET + PURPLE + "\n1) " + RESET + "ein Vogel oder" + PURPLE + "\n2) " + RESET + "ein Landtier ?\n");
        String wahl = new Scanner(System.in).nextLine();

        Tiere neuesTier = null;
        switch (wahl) {
            case "1":
                neuesTier = createVogel();
                break;
            case "2":
                neuesTier = createLandtier();
                break;
            default:
                System.out.println(RED_BG + BLACK + "Ungültige Eingabe. Bitte nur 1 oder 2 eingeben." + RESET);
                addAnimal();
        }

        alleTiere.add(neuesTier); // erzeugtes Tier zu alleTiere-ArrayList hinzufügen
        System.out.println("\n" + GREEN_BG + BLACK + "Tier erfolgreich hinzugefügt." + RESET);
    }

    // Methode für Eingabe von Vogel-Eigenschaften gibt ein Vogel-Objekt zurück
    private static Voegel createVogel() {

        System.out.println(GREEN + "\nEINEN VOGEL ANLEGEN\n-------------------" + RESET);
        System.out.println("Geben Sie die Größe ein (in Metern): ");
        double groesse = new Scanner(System.in).nextDouble();
        System.out.println("Geben Sie die Futtermenge ein (in kg pro Monat): ");
        int futtermenge = new Scanner(System.in).nextInt();
        System.out.println("Geben Sie die Futterart ein: ");
        String futterart = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie den Platzbedarf ein (in qm): ");
        int platzbedarf = new Scanner(System.in).nextInt();
        System.out.println("Geben Sie die Art ein: ");
        String vogelArt = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie das Herkunftsland ein: ");
        String herkunftsland = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie die Flügelspannweite ein (in cm): ");
        int fluegelspannweite = new Scanner(System.in).nextInt();

        return new Voegel(groesse, futtermenge, futterart, platzbedarf, vogelArt, herkunftsland, fluegelspannweite);
    }

    // Methode für Eingabe von Landtier-Eigenschaften, gibt Landtier-Objekt zurück
    private static Landtiere createLandtier() {

        System.out.println(GREEN + "\nEIN LANDTIER ANLEGEN\n--------------------" + RESET);
        System.out.println("Geben Sie die Größe ein (in Metern): ");
        double groesse = new Scanner(System.in).nextDouble();
        System.out.println("Geben Sie die Futtermenge ein (in kg pro Monat): ");
        int futtermenge = new Scanner(System.in).nextInt();
        System.out.println("Geben Sie die Futterart ein: ");
        String futterart = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie den Platzbedarf ein (in qm): ");
        int platzbedarf = new Scanner(System.in).nextInt();
        System.out.println("Geben Sie die Art ein: ");
        String landtierArt = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie an, ob das Tier nachtaktiv ist (true/false): ");
        boolean nachtaktiv = new Scanner(System.in).nextBoolean();
        System.out.println("Geben Sie die Lebenserwartung ein (in Jahren): ");
        int lebenserwartung = new Scanner(System.in).nextInt();

        return new Landtiere(groesse, futtermenge, futterart, platzbedarf, landtierArt, nachtaktiv, lebenserwartung);
    }

    // erzeugen aller vordefinierten Tiere, Methode gibt ArrayList von Tieren zurück
    private static ArrayList<Tiere> instantiateAnimals() {

        Voegel vogel10 = new Voegel(1.15, 100, "Fleisch", 1000, "Bartgeier", "China", 290);
        Voegel vogel11 = new Voegel(1.05, 90, "Fleisch", 1000, "Bartgeier", "China", 275);
        Voegel vogel20 = new Voegel(0.85, 45, "vegetarisch", 100, "Hyazinth-Ara", "Brasilien", 120);
        Voegel vogel21 = new Voegel(0.95, 50, "vegetarisch", 100, "Hyazinth-Ara", "Brasilien", 135);
        Voegel vogel22 = new Voegel(0.8, 40, "vegetarisch", 100, "Hyazinth-Ara", "Brasilien", 110);
        Voegel vogel23 = new Voegel(1, 60, "vegetarisch", 100, "Hyazinth-Ara", "Brasilien", 150);

        Landtiere landtier10 = new Landtiere(0.7, 125, "Allesfresser", 250, "Rotfuchs", true, 14);
        Landtiere landtier11 = new Landtiere(0.65, 100, "Allesfresser", 250, "Rotfuchs", true, 14);
        Landtiere landtier20 = new Landtiere(2.75, 10000, "vegetarisch", 1000, "Afrikanischer Elefant", false, 70);
        Landtiere landtier21 = new Landtiere(3.05, 11000, "vegetarisch", 1000, "Afrikanischer Elefant", false, 70);
        Landtiere landtier22 = new Landtiere(1.8, 8500, "vegetarisch", 1000, "Afrikanischer Elefant", false, 70);
        Landtiere landtier23 = new Landtiere(3.65, 12500, "vegetarisch", 1000, "Afrikanischer Elefant", false, 70);

        return new ArrayList<>(Arrays.asList(vogel10, vogel11, vogel20, vogel21, vogel22, vogel23, landtier10, landtier11, landtier20, landtier21, landtier22, landtier23));
    }

    // Ausgabe aller Tiere mit Hilfe von printMe() in Tiere.java
    private static void printAnimals() {
        System.out.println(GREEN + "\nÜbersicht alle Tiere\n--------------------" + RESET);
        for (Tiere animal : alleTiere) {
            animal.printMe();
            System.out.println();
        }
    }

    // Tier aus dem Zoo entfernen
    private static void deleteAnimal() {

        System.out.println(RED + "\nEin Tier aus dem Zoo entfernen\n------------------------------" + RESET);
        System.out.println("Geben Sie die Art des zu löschenden Tieres ein:");
        String tierart = new Scanner(System.in).nextLine();

        // ArrayList für gefundene Tiere die mit der Eingabe matchen
        ArrayList<Tiere> foundAnimals = new ArrayList<>();
        boolean foundAny = false; // Hilfsvariable
        for (Tiere tier : alleTiere) {
            if ((tier instanceof Voegel && ((Voegel) tier).getVogelArt().equalsIgnoreCase(tierart)) ||
                    (tier instanceof Landtiere && ((Landtiere) tier).getLandtierArt().equalsIgnoreCase(tierart))) {
                foundAnimals.add(tier);
                foundAny = true;
            }
        }

        if (foundAny) { // kann nur true sein, wenn oben true gesetzt; dh, wenn Tier gefunden wurde
            System.out.println("\n" + GREEN_BG + BLACK + "Folgende Tiere der Art \"" + tierart + "\" wurden gefunden:" + RESET);
            for (int i = 0; i < foundAnimals.size(); i++) {
                System.out.print("\n" + PURPLE + (i + 1) + ")" + RESET);
                foundAnimals.get(i).printMe(); // Ausgabe der gefundenen Tiere
                System.out.println();
            }

            boolean found = false; // Hilfsvariable für do-while-Schleife
            do {
                System.out.println("\n" + RED + "Welches Individuum möchten Sie aus dem Zoo entfernen?" + "\n(1 für das erste Individuum, 2 für das zweite usw.)" + RESET);
                int individuum = new Scanner(System.in).nextInt();

                if (individuum > 0 && individuum <= foundAnimals.size()) {
                    found = true;
                    // entfernen des gewählten Tieres aus alleTiere-Liste an gewähltem Index
                    alleTiere.remove(foundAnimals.get(individuum - 1));

                    Gehege selectedGehege = findGehege(tierart);
                    if (selectedGehege != null) {
                        selectedGehege.getTierArrayList().remove(individuum - 1);
                        selectedGehege.setAnzahlTiere(selectedGehege.getAnzahlTiere() - 1);
                    }
                    System.out.println("\n" + GREEN_BG + BLACK + "Tier erfolgreich gelöscht." + RESET);
                    foundAnimals.clear(); // entfernen aller gefundenen Tiere aus Liste
                } else {
                    System.out.println("\n" + RED_BG + BLACK + "Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und " + foundAnimals.size() + " ein." + RESET);
                }
            } while (!found); // Schleife läuft, solange found nicht true gesetzt wurde
        } else {
            System.out.println("\n" + RED_BG + BLACK + "Keine Tiere der Art \"" + tierart + "\" gefunden. Bitte versuchen Sie es erneut." + RESET);
            deleteAnimal();
        }
    }

    // neues Gehege erstellen und zur alleGehege-Liste hinzufügen
    private static void addGehege() {

        System.out.println(GREEN + "\nNeues Gehege hinzufügen\n-----------------------" + RESET);
        System.out.println("Geben Sie die Art des Geheges ein: ");
        String tierart = new Scanner(System.in).nextLine();
        System.out.println("Geben Sie die maximale Anzahl der Tiere im Gehege ein: ");
        int maxTiere = new Scanner(System.in).nextInt();
        System.out.println("Geben Sie die maximale Größe der Tiere im Gehege ein (in Metern): ");
        double maxGroesse = new Scanner(System.in).nextDouble();
        System.out.println("Geben Sie die zugelassene Oberart der Tiere im Gehege ein: ");
        String zugelasseneOberArt = new Scanner(System.in).nextLine();
        ArrayList<Tiere> tierArrayList = new ArrayList<>();

        Gehege gehege = new Gehege(tierart, maxTiere, 0, maxGroesse, zugelasseneOberArt, tierArrayList);
        alleGehege.add(gehege);
    }

    // vordefinierte Gehege erzeugen
    private static ArrayList<Gehege> instantiateGehege() {

        ArrayList<Tiere> bartgeierListe = new ArrayList<>(instantiateAnimals().subList(0, 2));
        Gehege gehege1 = new Gehege("Bartgeier", 4, 2, 1.25, "Vögel", bartgeierListe);
        ArrayList<Tiere> araListe = new ArrayList<>(instantiateAnimals().subList(2, 6));
        Gehege gehege2 = new Gehege("Hyazinth-Ara", 6, 4, 1, "Vögel", araListe);
        ArrayList<Tiere> rotfuchsListe = new ArrayList<>(instantiateAnimals().subList(6, 8));
        Gehege gehege3 = new Gehege("Rotfuchs", 6, 2, 0.75, "Landtiere", rotfuchsListe);
        ArrayList<Tiere> elefantenListe = new ArrayList<>(instantiateAnimals().subList(8, 12));
        Gehege gehege4 = new Gehege("Afrikanischer Elefant", 6, 4, 3.95, "Landtiere", elefantenListe);

        return new ArrayList<>(Arrays.asList(gehege1, gehege2, gehege3, gehege4));
    }

    // alle Gehege ausgeben mit printMe() in Tiere.java
    private static void printGehege() {
        System.out.println(GREEN + "\nÜbersicht alle Gehege\n---------------------" + RESET);
        for (Gehege einGehege : alleGehege) {
            einGehege.printMe();
            System.out.println();
        }
    }

    // Hilfsmethode um Gehege zu finden, verlangt eine Tierart, gibt Gehege-Objekt zurück
    private static Gehege findGehege(String gehegeArt) {
        for (Gehege gehege : alleGehege) {
            if (gehege.getTierart().equalsIgnoreCase(gehegeArt)) {
                return gehege;
            }
        }
        return null;
    }

    // alle Tiere eines Geheges anzeigen
    private static void animalsOfGehege() {

        System.out.println(GREEN + "\nAlle Tiere eines Geheges anzeigen\n--------------------------------" + RESET);
        System.out.println("Geben Sie die Tierart an, für die das Gehege angezeigt werden soll: ");
        String tierart = new Scanner(System.in).nextLine();

        Gehege selectedGehege = findGehege(tierart);
        if (selectedGehege != null) {
            System.out.println(GREEN + "\nTiere im Gehege \"" + selectedGehege.getTierart() + "\"\n----------------------------" + RESET);
            for (Tiere tier : selectedGehege.getTierArrayList()) {
                if (tier instanceof Gehege) {
                    tier.printMe();
                } else {
                    tier.printMe();
                }
                System.out.println();
            }
        } else {
            System.out.println(RED_BG + BLACK + "Gehege nicht gefunden. Bitte versuchen Sie es erneut." + RESET);
            animalsOfGehege();
        }
    }

    // je ein Tier, das noch nicht in Gehege ist, zum Gehege seiner Art hinzufügen
    private static void allocateAnimalToGehege() {

        System.out.println(GREEN + "\nEin Tier einem Gehege zuordnen\n------------------------------" + RESET);
        System.out.println("Geben Sie eine Tierart ein: ");
        String tierart = new Scanner(System.in).nextLine();

        // neue ArrayList für Tiere die der Eingabe matchen
        ArrayList<Tiere> foundAnimals = new ArrayList<>();
        for (Tiere tier : alleTiere) {
            if ((tier instanceof Voegel && ((Voegel) tier).getVogelArt().equalsIgnoreCase(tierart) ||
                    tier instanceof Landtiere && ((Landtiere) tier).getLandtierArt().equalsIgnoreCase(tierart))) {
                foundAnimals.add(tier);
            }
        }

        for (Iterator<Tiere> animals = foundAnimals.iterator(); animals.hasNext();) {
            Tiere foundAnimal = animals.next();

            // Verwendung der Hilfsmethode aus Tiere.java
            // ANNAHME: Wenn das Tier außerhalb eines Geheges die gleiche Größe und Futtermenge
            // hat wie ein Tier in einem Gehege, ist es dasselbe Tier
            boolean isInGehege = alleGehege.stream()
                    .anyMatch(gehege -> gehege.getTierArrayList().stream()
                            .anyMatch(gehegeTier -> gehegeTier.hasSameProperties(foundAnimal)));

            if (isInGehege) {
                animals.remove();
                // entfernen von Tier aus der Liste:
                // es bleibt nur das Tier außerhalb eines Geheges übrig
            }
        }

        if (!foundAnimals.isEmpty()) { // wenn foundAnimals-Liste nicht leer ist
            System.out.println("\n" + GREEN_BG + BLACK + "Folgende Tiere der Art \"" + tierart + "\" wurden gefunden:" + RESET);
            for (int i = 0; i < foundAnimals.size(); i++) {
                System.out.print("\n" + PURPLE + (i + 1) + ")" + RESET);
                foundAnimals.get(i).printMe();
                System.out.println();
            }

            boolean found = false; // Hilfsvariable für do-while-Schleife
            do {
                System.out.println("\n" + RED + "Welches Individuum möchten Sie einem Gehege hinzufügen?" +
                        "\n(1 für das erste Individuum, 2 für das zweite usw.)" + RESET);
                int individuum = new Scanner(System.in).nextInt();

                if (individuum > 0 && individuum <= foundAnimals.size()) {
                    Tiere selectedAnimal = foundAnimals.get(individuum - 1);

                    found = true;
                    Gehege selectedGehege = findGehege(tierart);
                    if (selectedGehege != null) {
                        selectedGehege.getTierArrayList().add(selectedAnimal);
                        selectedGehege.setAnzahlTiere(selectedGehege.getAnzahlTiere() + 1);
                        System.out.println("\n" + GREEN_BG + BLACK + "Tier erfolgreich einem Gehege hinzugefügt." + RESET);
                    }
                } else {
                    System.out.println("\n" + RED_BG + BLACK + "Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und " + foundAnimals.size() + " ein." + RESET);
                }
            } while (!found);
        } else {
            // Rückkehr ins Hauptmenü, wenn es keine Tiere außerhalb eines Geheges gibt, die der Eingabe matchen
            System.out.println("\n" + RED_BG + BLACK + "Nicht gefunden oder alle Tiere der Art \"" + tierart + "\" sind bereits in einem Gehege." + RESET);
            pressEnter();
            menu();
        }
    }

    // Tiere aus einem Gehege entfernen
    private static void deleteAnimalFromGehege() {

        System.out.println(RED + "\nTier aus Gehege entfernen\n-------------------------" + RESET);
        System.out.println("Geben Sie die Tierart an, aus deren Gehege ein Tier entfernt werden soll: ");
        String gehegeArt = new Scanner(System.in).nextLine();

        Gehege selectedGehege = findGehege(gehegeArt);

        if (selectedGehege != null && selectedGehege.getAnzahlTiere() > 0) {

            System.out.println("\n" + GREEN_BG + BLACK + "Folgende Tiere wurden im gewählten Gehege gefunden:" + RESET);

            for (int i = 0; i < selectedGehege.getTierArrayList().size(); i++) {
                System.out.print("\n" + PURPLE + (i + 1) + ")" + RESET);
                selectedGehege.getTierArrayList().get(i).printMe();
                System.out.println();
            }

            boolean found = false;
            do {
                System.out.println("\n" + RED + "Welches Individuum möchten Sie aus dem Gehege entfernen?" + "\n(1 für das erste Individuum, 2 für das zweite usw.)" + RESET);
                int individuum = new Scanner(System.in).nextInt();

                if (individuum > 0 && individuum <= selectedGehege.getTierArrayList().size()) {

                    found = true;

                    selectedGehege.getTierArrayList().remove(individuum - 1);
                    selectedGehege.setAnzahlTiere(selectedGehege.getAnzahlTiere() - 1);

                    System.out.println("\n" + GREEN_BG + BLACK + "Tier erfolgreich aus dem Gehege entfernt." + RESET);
                } else {
                    System.out.println("\n" + RED_BG + BLACK + "Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und " + selectedGehege.getTierArrayList().size() + " ein." + RESET);
                }
            } while (!found);

        } else {
            System.out.println(RED_BG + BLACK + "Gehege nicht gefunden oder keine Tiere im Gehege. Versuchen Sie es noch einmal." + RESET);
            deleteAnimalFromGehege();
        }
    }

    // Gehege löschen
    private static void deleteGehege() {

        System.out.println(RED + "\nGehege löschen\n--------------" + RESET);
        System.out.println("Geben Sie die Tierart an, deren Gehege gelöscht werden soll: ");
        String tierart = new Scanner(System.in).nextLine();

        // Gehege anhand Eingabe der Tierart finden
        Gehege gehegeToRemove = null;
        for (Gehege gehege : alleGehege) {
            if (gehege.getTierart().equalsIgnoreCase(tierart)) {
                gehegeToRemove = gehege;
            }
        }

        if (gehegeToRemove != null) { // Gehege existiert

            // Userabfrage ob Gehege wirklich gelöscht werden soll
            // ternärer Operator: wenn Gehege leer → Ausgabe 1, wenn Gehege nicht leer → Ausgabe 2
            System.out.println(gehegeToRemove.getTierArrayList().isEmpty() ?
                    RED + "Möchten Sie wirklich das leere Gehege löschen? (j/n)" + RESET :
                    RED + "Möchten Sie wirklich das Gehege mitsamt der darin enthaltenen Tiere (Anzahl: " +
                            gehegeToRemove.getAnzahlTiere() + ") der Art \"" + tierart + "\" löschen? (j/n)" + RESET);

            String wirklich = new Scanner(System.in).nextLine().toUpperCase();
            if (wirklich.equals("J") || wirklich.equals("JA")) {
                alleGehege.remove(gehegeToRemove);
                System.out.println("\n" + GREEN_BG + BLACK + "Gehege erfolgreich gelöscht." + RESET);
            } else {
                System.out.println(RED_BG + BLACK + "Löschvorgang abgebrochen" + RESET);
                pressEnter();
                menu();
            }
        } else { // Gehege existiert nicht
            System.out.println(RED_BG + BLACK + "Gehege nicht gefunden. Bitte versuchen Sie es erneut." + RESET);
            deleteGehege();
        }
    }

}


