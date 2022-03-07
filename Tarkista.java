
public class Tarkista {
    private int virheet;

    public Tarkista() {
        this.virheet = virheet;
    }

    public boolean tarkistaSana(String sana, String kirjain) {

        if (sana.contains(kirjain)) {
            System.out.println("Tässä oli kirjain " + kirjain);
            return true;

        } else {
            System.out.println("Ei ollut kirjainta " + kirjain);
            virheet++;
            return false;
        }
    }

    public int getVirheet() {
        return this.virheet;
    }

}
