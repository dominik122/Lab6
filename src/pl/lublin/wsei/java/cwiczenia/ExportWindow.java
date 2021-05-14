package pl.lublin.wsei.java.cwiczenia;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ExportWindow {
    public TextField txtRok;
    public TextField txtKraj;
    public TextField txtDziedzina;
    public Label lblInfo;

    private ArrayList<Noblista> listaNoblistow;
    public ArrayList<Noblista> filtrowaniNoblisci = null;

    public void setListaNoblistow(ArrayList<Noblista> lst){
        listaNoblistow = lst;
    }

    public void btnFilterOnAction(ActionEvent actionEvent) {

        for(Noblista nob : listaNoblistow){
            if(txtRok.hasProperties()){
                String rok = txtRok.getText();
                if(!nob.rok.equalsIgnoreCase(rok)){
                    continue;
                }
            }
            if(txtKraj.hasProperties()){
                String kraj = txtKraj.getText();
                if(!nob.kraj.equalsIgnoreCase(kraj)){
                    continue;
                }
            }
            if(txtDziedzina.hasProperties()){
                String dziedzina = txtDziedzina.getText();
                if(!nob.kategoria.equalsIgnoreCase(dziedzina)){
                    continue;
                }
            }
            filtrowaniNoblisci.add(nob);
        }
        lblInfo.setText("Ukończono !");
    }
}
