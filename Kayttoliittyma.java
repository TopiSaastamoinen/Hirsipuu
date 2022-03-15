import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private ArrayList<String> sanalista;
    private UusiSana UusiSana;
    private Aloita aloita;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.sanalista = new ArrayList<>();
        this.UusiSana = new UusiSana();
        this.aloita = new Aloita(lukija);

    }

    public void kaynnista() {
        System.out.println("H I R S I P U U");

        while (true) {
            String haaste = "";
            sanalista.removeAll(sanalista);

            System.out.print("Aloita peli valitsemalla sana, fraasi tai virke\n \nYksittäinen sana: 's'\n" // aloita peli, lisää sanoja yms
                    + "Fraasi: 'f'\n"
                    + "Sattumanvarainen virke: 'v'\n"
                    + "Lisää uusi sana listalle kirjoittamalla 'lisaa'\n"
                    + "Lopeta painamalla 'l'\n"
                    + "> ");

            String syote = lukija.nextLine();

            // valitaan mitä tehdään
            if (syote.equalsIgnoreCase("l")) {
                break;
            } else if (syote.equalsIgnoreCase("lisaa")) {
                this.UusiSana.lisaa();
            } else if (syote.equalsIgnoreCase("s")) {
                haaste = "sanat.txt";
            } else if (syote.equalsIgnoreCase("f")) {
                haaste = "fraasit.txt";
            } else if (syote.equalsIgnoreCase("v")) {
                haaste = "lauseet.txt";
            }
            // ladataan txt tiedosto
            try (Scanner tiedostonlukija = new Scanner(Paths.get(haaste))) {
                while (tiedostonlukija.hasNextLine()) {
                    String rivi = tiedostonlukija.nextLine();
                    if (rivi.isEmpty()) {
                        break;
                    }
                    sanalista.add(rivi);
                }
            } catch (Exception e) {
                System.out.println("\nVirhe! Anna oikea komento." + e.getMessage());
                continue;
            }

            System.out.println("Aloita peli? k/e");
            syote = lukija.nextLine();
            if (syote.equalsIgnoreCase("k")) {
                aloita.aloita(sanalista);
            }

        }

    }

}
