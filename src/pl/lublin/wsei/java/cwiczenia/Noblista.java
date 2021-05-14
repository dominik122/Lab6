package pl.lublin.wsei.java.cwiczenia;

import java.util.ArrayList;

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
        String[] tokens = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

        dataRow = line;
        imie = tokens[1];
        nazwisko = tokens[2];
        rok = tokens[12];
        kategoria = tokens[13];
        uzasadnienie = tokens[16];
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
