import java.util.ArrayList;

public class Aloita {
    private Arvonta arvonta;


    public Aloita() {
        this.arvonta = new Arvonta();

    }

    public void aloita(ArrayList<String> sanalista) {
        
        String arvottuSana = arvonta.arvoSana(sanalista); //sana on valittu arvalla
    }
}
