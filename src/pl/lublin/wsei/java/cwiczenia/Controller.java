package pl.lublin.wsei.java.cwiczenia;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Pliki CSV(*.csv)", "*.csv");

    public Label lblFile;

    public ListView lstNoblisci;
    ObservableList<String> imiona = FXCollections.observableArrayList();


    public TextField txtRok;
    public TextField txtKategoria;
    public TextField txtKraj;
    public TextArea txtUzasadnienie;

    NoblistaList noblisciList;
    private Noblista selNoblista;


    @FXML
    public void initialize(){
        fileChooser.getExtensionFilters().add(csvFilter);
        lstNoblisci.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val){
                        int index = new_val.intValue();
                        if(index != -1){
                            selNoblista= noblisciList.noblisci.get(index);
                            txtRok.setText(selNoblista.rok);
                            txtKategoria.setText(selNoblista.kategoria);
                            txtKraj.setText(selNoblista.kraj);
                            txtUzasadnienie.setText(selNoblista.uzasadnienie);
                        } else {
                            txtRok.setText("");
                            txtKategoria.setText("");
                            txtKraj.setText("");
                            txtUzasadnienie.setText("");
                            selNoblista = null;
                        }
                    }
                }
        );

    }

    public void btnOpenFileAction(ActionEvent actionEvent) throws IOException {
        File file = fileChooser.showOpenDialog(null);

        if(file!=null){
            noblisciList = new NoblistaList(file.getAbsolutePath());
            lblFile.setText(file.getAbsolutePath());
            for (Noblista n: noblisciList.noblisci) imiona.add(n.imie + " " + n.nazwisko);
            lstNoblisci.setItems(imiona);
        } else {
            lblFile.setText("Proszę wczytać plik...");
        }

    }

    public void btnExportOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("exportWindow.fxml"));
            Parent root = loader.load();
            ExportWindow export = loader.getController();
            export.setListaNoblistow(noblisciList.noblisci); // Przekazujemy wczytanaliste noblistow dodatkowemu okienku filtracji

            Stage stage = new Stage();
            stage.setTitle("Filtrowanie Noblistów");
            stage.setScene(new Scene(root, 338, 329));
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
