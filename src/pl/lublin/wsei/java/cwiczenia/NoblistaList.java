package pl.lublin.wsei.java.cwiczenia;

import java.io.*;
import java.util.ArrayList;

public class NoblistaList {
    public ArrayList<Noblista> noblisci;
    private BufferedReader in ;

    public NoblistaList(String filepath) throws IOException {
        noblisci = new ArrayList<>();

        String line;
        int nr = -1;
        try {
            in = new BufferedReader(new FileReader(filepath));
            while ((line = in.readLine()) != null){
                nr++;
                if(nr == 0){
                    continue;
                }
                noblisci.add(new Noblista(line));
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            in.close();
        }

    }
}
