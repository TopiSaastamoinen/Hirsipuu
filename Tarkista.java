import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;

public class Tarkista {
    private int virheet;
    private ArrayList<String> kirjainlista;
    private ArrayList<String> vaarat;

    public Tarkista() {
        this.virheet = virheet;
        this.kirjainlista = new ArrayList<>();
        this.vaarat = new ArrayList<>();
    }

    public boolean tarkistaSana(String sana, String kirjain) {

        if (sana.contains(kirjain)) {
            if (kirjainlista.contains(kirjain)) {
                System.out.println(kirjain + " on jo siellä");
                System.out.println("");

                return true;
            }
            System.out.println("Tässä oli kirjain " + kirjain);
            System.out.println("");

            if (!(kirjainlista.contains(kirjain))) {
                kirjainlista.add(kirjain);
            }

            return true;

        } else {

            if (vaarat.contains(kirjain)) {
                System.out.println("Käytit jo " + kirjain + ":n");
                return true;
            }
            System.out.println("Ei ollut kirjainta " + kirjain);
            virheet++;
            vaarat.add(kirjain);
            return false;
        }
    }

    public void tulostaSana(String sana) {

        int pituus = sana.length() - 1;
        String kirjaimet[] = sana.split((""));

        int loyty = 0;
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
                System.out.print("_ ");
            }

        }
        System.out.println("");
    }

    public void tulostaVaarat() {
        int i = 1;
        System.out.print("Käytetyt: ");
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

    public int getVirheet() {
        return this.virheet;
    }

    public void nollaa() {
        this.virheet = 0;
        this.kirjainlista.removeAll(kirjainlista);
    }

}
