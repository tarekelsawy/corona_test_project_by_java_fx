
package project;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;


public class Result3Controller implements Initializable {

    Project ob ;
    
    @FXML  AnchorPane pane ;
    
    @FXML ComboBox combo ;
    
    @FXML Text label ;
    
    @FXML
    public void Restart(ActionEvent e) throws Exception{
       
        if(combo.getValue().equals(""))
            
            displayLabel();
        else
        {
            insertUserAsPatient();
            
            AnchorPane ap =  FXMLLoader.load(getClass().getResource("choose.fxml"));
            
            pane.getChildren().setAll(ap); 
        }
   }
    public void displayLabel(){
        
        label.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        
        label.setText("Choose a Hospital!");
    }
    public void insertUserAsPatient() throws Exception{
        
        ob.startDataBaseConnection();
        
        ob.stmt.executeUpdate("insert into hospital values (" + ob.ssn + " , '" + combo.getValue() + "');");
        
        ob.closeDataBaseConnection();
        
    }
    
    public String getTheStateOfUser() throws Exception{
        
        ob.startDataBaseConnection();
        ResultSet set = ob.stmt.executeQuery("select state from users where patient_ssn = " + ob.ssn + ";");
        String state="";
        if(set.next())
        {
            state = set.getString("state");
        }
        
        ob.closeDataBaseConnection();
        
        return state;  // note : must return value (because user is already exist in the system);
        
    }
    public void giveValuesToCombo(String s) throws Exception{
        
        ob.startDataBaseConnection();
        
        ResultSet set = ob.stmt.executeQuery("select hospital_name from states where state = '" + s + "' ;" );
        
        List<String> list = new ArrayList<String>();

        while (set.next()) {
    
            String current = set.getString(1);
    
            list.add(current);
        }
        ObservableList<String> Observer = FXCollections.observableArrayList(list);
        
        combo.setItems(Observer);
        
        ob.closeDataBaseConnection();
        
        
    }
    public void initializeComboBox(){
        
        try{
        
             giveValuesToCombo(getTheStateOfUser());    
           }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        catch(Exception e){
           
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    
        ob = new Project();
        
        initializeComboBox();
        
        // intialize the label;
        // choose the appropriate values of the attributes;
        
        label.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        
        label.setText("");
    }    
    
}








/**
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Result3Controller implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
*/