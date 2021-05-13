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
        //1,2,12,13,16,19
        String[] tokens = line.split(",");
        dataRow = line;
        imie = tokens[1];
        nazwisko = tokens[2];
        rok = tokens[12];
        kategoria = tokens[13];
        uzasadnienie = tokens[16];
        kraj = tokens[19];
    }
}
