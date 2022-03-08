import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;

public class Tarkista {
    private int virheet;
    private ArrayList<String> kirjainlista;

    public Tarkista() {
        this.virheet = virheet;
        this.kirjainlista = new ArrayList<>();
    }

    public boolean tarkistaSana(String sana, String kirjain) {

        if (sana.contains(kirjain)) {
            System.out.println("Tässä oli kirjain " + kirjain);
            System.out.println("");

            kirjainlista.add(kirjain);

            return true;

        } else {
            System.out.println("Ei ollut kirjainta " + kirjain);
            virheet++;
            return false;
        }
    }

    public void tulostaSana(String sana, String kirjain) {

        int pituus = sana.length() - 1;
        String kirjaimet[] = sana.split((""));

        for (int i = 0; i <= pituus; i++) {
            if (kirjaimet[i].contains(kirjain)) {
                System.out.print(kirjaimet[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("");
    }

    public int getVirheet() {
        return this.virheet;
    }

    public void nollaa() {
        this.virheet = 0;
    }

}
