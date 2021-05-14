package pl.lublin.wsei.java.cwiczenia.console;

import pl.lublin.wsei.java.cwiczenia.Noblista;
import pl.lublin.wsei.java.cwiczenia.NoblistaList;

import java.io.IOException;

public class TestNoblistaList {
    public static void main(String[] args) throws IOException {
        NoblistaList lst = new NoblistaList("nobel_prize_by_winner.csv");

        for(Noblista n: lst.noblisci) n.print();
    }
}
