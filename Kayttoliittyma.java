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
        System.out.println("H A N G  M A N");

        while (true) {
            String haaste = "";
            sanalista.removeAll(sanalista);

            System.out.print("Begin the game by selecting word, phrase, or sentence.\n \nSingle word: 'w'\n" // aloita peli, lisää sanoja yms
                    + "Phrase: 'p'\n"
                    + "Sentence: 's'\n"
                    + "Add a new word by entering 'add'\n"
                    + "Quit with 'q'\n"
                    + "> ");

            String syote = lukija.nextLine();

            // valitaan mitä tehdään
            if (syote.equalsIgnoreCase("q")) {
                break;
            } else if (syote.equalsIgnoreCase("add")) {
                this.UusiSana.lisaa();
            } else if (syote.equalsIgnoreCase("w")) {
                haaste = "sanat.txt";
            } else if (syote.equalsIgnoreCase("p")) {
                haaste = "fraasit.txt";
            } else if (syote.equalsIgnoreCase("s")) {
                haaste = "lauseet.txt";
            } else {
                System.out.println("Faulty command.");
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
                System.out.println(e.getMessage());
                continue;
            }

            while (true) {
                System.out.println("Begin game? y/n");
                syote = lukija.nextLine();
                if (syote.equalsIgnoreCase("y")) {
                    aloita.aloita(sanalista);
                    break;
                } else if (syote.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Faulty command, try again.");
                }
            }

        }

    }

}
