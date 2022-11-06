package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

public class Login1Controller implements Initializable {

    Project ob;
    @FXML AnchorPane loginPane;
    @FXML TextField nameTextField;
    @FXML TextField idTextField;
    @FXML Text nameText;
    @FXML Label idLabel;
    @FXML
    public void loginButton(ActionEvent e){
        Connection conn=null;
        Statement stmt = null;
        ResultSet rset = null;
        String id = ""  , 
               name = "";
        nameText.setText("");
        idLabel.setText("");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/patient_management","root","");
            stmt = conn.createStatement();
            
            rset = stmt.executeQuery("select * from users where patient_ssn = "+idTextField.getText()+";");
            if(rset.next())
            {
                id = rset.getString("patient_ssn");
                name = rset.getString("name");
                System.out.print(id +" "+name+"\n");
                if(idTextField.getText().equals(id)&&nameTextField.getText().equals(name))
                {
                    ob.ssn = Integer.parseInt(idTextField.getText());
                    AnchorPane ap = FXMLLoader.load(getClass().getResource("test.fxml"));
                    loginPane.getChildren().setAll(ap);
                }else
                {
                    nameTextField.setText("");
                    nameText.setText("wrong name typed!");
                    nameText.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
                    
                }
            }else 
                {
                    idTextField.setText("");
                    idLabel.setText("wrong id typed!");
                    idLabel.setStyle("-fx-font:12px Tahoma;-fx-text-fill:red;-fx-stroke:#ffe9e3;");

                }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @FXML
    public void signUp(ActionEvent e) throws IOException{
            AnchorPane ap = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            loginPane.getChildren().setAll(ap);       
    }
    @FXML
    public void back(ActionEvent e) throws Exception{
        
            AnchorPane ap = FXMLLoader.load(getClass().getResource("choose.fxml"));
            loginPane.getChildren().setAll(ap);       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idLabel.setStyle("-fx-font-size:12px;-fx-text-fill:red;-fx-background-color:#ffe9e3;");
        nameText.setStyle("-fx-font-size:12px;-fx-text-fill:red;-fx-background-color:#ffe9e3;");
    }    
    
}