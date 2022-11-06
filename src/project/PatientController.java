/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class PatientController implements Initializable {

    @FXML
    AnchorPane patientpane;
    @FXML
    TextField textField;
    @FXML
    Label searchLabel;
    
    FindpatientController ob;
    
    
    public void loadFindPatient(ActionEvent ae) throws IOException
    {
        String patient_ssn=textField.getText();
        String tmpSsn , tmpHospital;
        if(patient_ssn.length()!=0)
        {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rset = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_management","root","");
                stmt = conn.createStatement();
                rset = stmt.executeQuery("select * from hospital where patient_ssn = "+patient_ssn+";");
                    
                if(rset.next())
                {
                    tmpSsn = rset.getString("patient_ssn");
                    tmpHospital = rset.getString("hospital");
                    
                    rset = stmt.executeQuery("select * from users where patient_ssn = "+tmpSsn+";");
                    if(rset.next())
                    {
                        ob.ssn=rset.getString("patient_ssn");
                        ob.name=rset.getString("name");
                        ob.email=rset.getString("Email");
                        ob.gender=rset.getString("gender");
                        ob.state=rset.getString("state");
                        AnchorPane ap = FXMLLoader.load(getClass().getResource("findpatient.fxml"));
                        patientpane.getChildren().setAll(ap);
                    }
                    
                    stmt.close();
                }else
                {
                    searchLabel.setText("No Patient with ssn "+patient_ssn+"\n");
                    searchLabel.setStyle("-fx-text-fill:red;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
                    stmt.close();
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else
        {
            searchLabel.setText("you must fill search text field first!!");
            searchLabel.setStyle("-fx-text-fill:red;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
        }
        
    }
    
    public void loadChoose(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("choose.fxml"));
        patientpane.getChildren().setAll(ap);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchLabel.setStyle("-fx-text-fill:red;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
    }    
    
}
