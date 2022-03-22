import java.util.ArrayList;
import java.util.Scanner;

public class Aloita {
    private Arvonta arvonta;
    private Tarkista tarkista;
    private Scanner lukija;
    private String arvottuSana;

    public Aloita(Scanner lukija) {
        this.arvonta = new Arvonta();
        this.tarkista = new Tarkista();
        this.lukija = lukija;

    }

    public void aloita(ArrayList<String> sanalista) {

        arvottuSana = arvonta.arvoSana(sanalista); // sana on valittu arvalla
        tarkista.tulostaSana(arvottuSana);
        System.out.println(); // muutos tehty. Yritetty lisätä väli ennen pelin alotusta
        suorita();
    }

    public void suorita() {

        while (true) {
            System.out.print("Enter a letter(A-Z): ");
            String kirjain = lukija.nextLine().toUpperCase();
            if (!(!kirjain.matches(".*[^A-Z].*")) || kirjain.equals("")) {
                continue;
            }

            if (this.tarkista.tarkistaSana(arvottuSana, kirjain) == true) {
                this.tarkista.tulostaSana(arvottuSana);

            } else { // Hirsipuun rakentaminen
                if (tarkista.getVirheet() == 1) {
                    System.out.println(
                            "\n       \n" +
                                    "  -    \n" +
                                    "    -  \n" +
                                    " -     \n" +
                                    "   -   \n" +
                                    "______ ");
                } else if (tarkista.getVirheet() == 2) {
                    System.out.println(
                            "\n       \n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "______|");
                } else if (tarkista.getVirheet() == 3) {
                    System.out.println(
                            "\n______ \n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "______|");
                } else if (tarkista.getVirheet() == 4) {
                    System.out.println(
                            "\n______ \n" +
                                    "     L|\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "______|");
                } else if (tarkista.getVirheet() == 5) {
                    System.out.println(
                            "\n______ \n" +
                                    "  |  L|\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    "      |\n" +
                                    "_A____|");
                } else if (tarkista.getVirheet() >= 6) {
                    System.out.println(
                            "\n______ \n" +
                                    "  |  L|\n" +
                                    " _O_  |\n" +
                                    " |||  |\n" +
                                    "  H   |\n" +
                                    "_A____|");

                    tarkista.nollaa();

                    break;
                }

                System.out.println("");
                this.tarkista.tulostaSana(arvottuSana);

            }

            if (this.tarkista.onkoKaikki() == true) {
                taysiSana();
                break;
            }
            this.tarkista.tulostaVaarat();
            System.out.println("");
        }

    }

    public void taysiSana() {

        if (tarkista.getVirheet() == 0) { // Pako
            System.out.println(
                    "\n    P\n" +
                            "__O/ \n" +
                            " _|_/\n" +
                            "/    \n");

        } else if (tarkista.getVirheet() == 1) {
            System.out.println(
                    "\n    P\n" +
                            "__O/ \n" +
                            " _|_/\n" +
                            "/         ______ \n");

        } else if (tarkista.getVirheet() == 2) {
            System.out.println(
                    "\n                |\n" +
                            "    P           |\n" +
                            "__O/            |\n" +
                            " _|_/           |\n" +
                            "/         ______|\n");

        } else if (tarkista.getVirheet() == 3) {
            System.out.println(
                    "\n          ______ \n" +
                            "                |\n" +
                            "    P           |\n" +
                            "__O/            |\n" +
                            " _|_/           |\n" +
                            "/         ______|\n");

        } else if (tarkista.getVirheet() == 4) {
            System.out.println(
                    "\n          ______ \n" +
                            "               L|\n" +
                            "    P           |\n" +
                            "__O/            |\n" +
                            " _|_/           |\n" +
                            "/         ______|\n");

        } else if (tarkista.getVirheet() == 5) {
            System.out.println(
                    "\n          ______ \n" +
                            "            |  L|\n" +
                            "    P       |   |\n" +
                            "__O/        O   |\n" +
                            " _|_/           |\n" +
                            "/         _A____|\n");

        }
        tarkista.nollaa();

    }
}
