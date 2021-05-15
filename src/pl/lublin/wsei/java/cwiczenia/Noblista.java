package pl.lublin.wsei.java.cwiczenia;


public class Noblista {
    public String imie;
    public String nazwisko;
    public String rok;
    public String kategoria;
    public String uzasadnienie;
    public String kraj;
    public String dataRow;

    Noblista(String line){
        String[] tokens = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1); // rozdzielenie przy pomocy samego przecinka powoduje błędny podział na tokeny

        dataRow = line;
        imie = tokens[1];
        nazwisko = tokens[2];
        rok = tokens[12];
        kategoria = tokens[13];
        uzasadnienie = tokens[16].replace("\"\"\"", ""); // Pozbywamy sie cudzysłowów które znajduja sie przy uzasadnieniu
        kraj = tokens[19];
    }

    public void print(){
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Rok: " + rok);
        System.out.println("Kategoria: " + kategoria);
        System.out.println("Uzasadnienie: " + uzasadnienie);
        System.out.println("Kraj: " + kraj);
        System.out.println(dataRow);
    }
}
