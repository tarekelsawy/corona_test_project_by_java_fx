/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class FindpatientController implements Initializable {

    static String ssn , name , email , gender , state;
    @FXML
    AnchorPane findpatientpane;
    @FXML
    Label lpatient_ssn , lname , lEmail , lgender , lstate;
    
    
    public void loadPatient(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("patient.fxml"));
        findpatientpane.getChildren().setAll(ap);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lpatient_ssn.setText(ssn);
        lname.setText(name);
        lEmail.setText(email);
        lgender.setText(gender);
        lstate.setText(state);
    }    
    
}
