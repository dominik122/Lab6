package pl.lublin.wsei.java.cwiczenia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV(*.csv)", "*.csv");

    public Label lblFile;
    public ListView lstNoblisci;
    public TextField txtRok;
    public TextField txtKategoria;
    public TextField txtKraj;
    public TextField txtUzasadnienie;

    ObservableList<String> pelneImiona = FXCollections.observableArrayList();
    NoblistaList noblisciList;
    ArrayList<Noblista> filteredNoblisci;
    private Noblista selNoblista;


    @FXML
    public void initialize(){
        fileChooser.getExtensionFilters().add(csvFilter);

    }

    public void btnOpenFileAction(ActionEvent actionEvent) throws IOException {
        File file = fileChooser.showOpenDialog(null);

    }

    public void btnExportOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("exportWindow.fxml"));
            Parent root = loader.load();
            ExportWindow export = loader.getController();
            export.setListaNoblistow(noblisciList.noblisci);

            Stage stage = new Stage();
            stage.setTitle("Filtrowanie Noblistów");
            stage.setScene(new Scene(root, 502, 330));
            stage.show();

            if(export.filtrowaniNoblisci != null){
                filteredNoblisci = export.filtrowaniNoblisci;
                System.out.println("Filtracja Udana");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
