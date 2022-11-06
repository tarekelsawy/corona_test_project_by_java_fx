/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;



public class FindhospitalController implements Initializable {

    @FXML
    AnchorPane findhospitalpane;
    @FXML
    Label hospitalLabel;
    @FXML
    ListView listView;
    
    static long count=0;
    static String hospitalName;
    static ArrayList<String> record = new ArrayList<String>();
    
    
    public void loadHospital(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("hospital.fxml"));
        findhospitalpane.getChildren().setAll(ap);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hospitalLabel.setText(hospitalName);
        ObservableList<String> list = FXCollections.observableList(record);
        listView.setItems(list);
    }    
    
}
