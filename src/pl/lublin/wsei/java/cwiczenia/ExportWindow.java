package pl.lublin.wsei.java.cwiczenia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class ExportWindow {
    public TextField txtRok;
    public TextField txtKraj;
    public TextField txtDziedzina;
    public Label lblInfo;

    private ArrayList<Noblista> listaNoblistow = null;
    public ArrayList<Noblista> filtrowaniNoblisci = null;

    private PrintStream out;

    public void setListaNoblistow(ArrayList<Noblista> lst){
        listaNoblistow = lst;
    }

    public void btnFilterOnAction(ActionEvent actionEvent) {
        filtrowaniNoblisci = new ArrayList<>();

        if (listaNoblistow != null) {
            for (Noblista nob : listaNoblistow) {
                if (!txtRok.getText().equals("")) {
                    String rok = txtRok.getText();
                    if (!nob.rok.equalsIgnoreCase(rok)) {
                        continue;
                    }
                }
                if (!txtKraj.getText().equals("")) {
                    String kraj = txtKraj.getText();
                    if (!nob.kraj.equalsIgnoreCase(kraj)) {
                        continue;
                    }
                }
                if (!txtDziedzina.getText().equals("")) {
                    String dziedzina = txtDziedzina.getText();
                    if (!nob.kategoria.equalsIgnoreCase(dziedzina)) {
                        continue;
                    }
                }
                filtrowaniNoblisci.add(nob);
            }
            lblInfo.setText("Ukończono !");
        } else {
            lblInfo.setText("Brak wczytanego pliku, proszę wczytać plik !");
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        if(filtrowaniNoblisci != null){
            try{
                 out= new PrintStream(new FileOutputStream("nobel_filtered.csv"));

                for (Noblista n : filtrowaniNoblisci){
                    out.println(n.dataRow);
                }
            } catch (IOException e){
                System.out.println("IOException: " + e.getMessage());
                e.printStackTrace();
            } finally {
                out.close();
            }
            lblInfo.setText("Ukończono.");
        } else {
            lblInfo.setText("Brak filtrowanej listy !");
        }
    }
}
