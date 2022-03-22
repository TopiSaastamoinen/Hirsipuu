import java.util.ArrayList;

public class Tarkista {
    private int virheet;
    private boolean voitto;
    private ArrayList<String> kirjainlista;
    private ArrayList<String> vaarat;

    public Tarkista() {
        this.kirjainlista = new ArrayList<>();
        this.vaarat = new ArrayList<>();
    }

    public boolean tarkistaSana(String sana, String kirjain) {

        if (sana.contains(kirjain)) {
            if (kirjainlista.contains(kirjain)) {
                System.out.println(kirjain + " already exists.");
                System.out.println("");

                return true;
            }
            System.out.println("The answer contains " + kirjain + ".");
            System.out.println("");

            if (!(kirjainlista.contains(kirjain))) {
                kirjainlista.add(kirjain);
            }

            return true;

        } else {

            if (vaarat.contains(kirjain)) {
                System.out.println(kirjain + "has already been used.");
                System.out.println("");
                return true;
            }
            System.out.println("The answer does not contain " + kirjain + ".");
            virheet++;
            vaarat.add(kirjain);
            return false;
        }
    }

    public void tulostaSana(String sana) {

        int pituus = sana.length() - 1;
        String kirjaimet[] = sana.split((""));

        int loyty = 0;
        voitto = true;
        for (int i = 0; i <= pituus; i++) {
            loyty = 0;
            for (String kirjain : kirjainlista) {
                if (kirjaimet[i].contains(kirjain)) {
                    System.out.print(kirjaimet[i] + " ");
                    loyty = 1;
                    continue;
                }

            }
            if (loyty == 0) {
                if (!(!kirjaimet[i].matches(".*[^A-Z].*"))) {
                    System.out.print(kirjaimet[i] + " ");
                    continue;
                }
                System.out.print("_ ");
                voitto = false;
            }

        }
        System.out.println("");
    }

    public void tulostaVaarat() {
        int i = 1;
        System.out.print("Used letters: ");
        for (String vaara : vaarat) {
            System.out.print(vaara);
            if (i == vaarat.size()) {
                System.out.println("");
                break;
            }
            System.out.print(", ");
            i++;
        }
    }

    public boolean onkoKaikki() {
        return voitto;
    }

    public int getVirheet() {
        return this.virheet;
    }

    public void nollaa() {
        this.virheet = 0;
        this.kirjainlista.removeAll(kirjainlista);
        this.vaarat.removeAll(vaarat);
    }

}
