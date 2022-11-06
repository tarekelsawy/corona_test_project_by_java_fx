
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class HospitalController implements Initializable {

    @FXML
    AnchorPane hospitalpane;
    @FXML
    TextField hospitalTextField;
    @FXML
    Label hospitalLabel;
    
    Project ob;  //create object from project to start and clase connection 
    
    FindhospitalController ob2;//create object from FindhospitalController to assign value to static variables;
    
    public void loadFindHospital(ActionEvent ae) throws IOException
    {
        ob2.hospitalName = hospitalTextField.getText();
        if(ob2.hospitalName.length()!=0)
        {
            Connection conn=null;
            Statement stmt = null;
            ResultSet rset = null;
            try
            {
                //ob.startDataBaseConnection();
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/patient_management","root","");
                stmt = conn.createStatement();
                
                //rset = ob.stmt.executeQuery("select * from hospital where hospital = '"+hospital+"';");
                rset = stmt.executeQuery("select * from hospital where hospital = '"+ob2.hospitalName+"';");
                
                boolean flag=false;
                ArrayList list = new ArrayList();//to store ssn's in it
                
                while(rset.next()) 
                    list.add(rset.getString("patient_ssn")); 
                
                for(int i=0;i<list.size();++i)
                {
                    rset = stmt.executeQuery("select * from users where patient_ssn = "+list.get(i)+";");
                    if(rset.next())
                    {
                        ob2.record.add(rset.getString("name")+"\t\t\t\t\t"+rset.getString("patient_ssn")+"\t\t\t\t\t"+rset.getString("age"));
                        flag=true;
                    }
                }
                
                if(flag==true)
                {
                    AnchorPane ap = FXMLLoader.load(getClass().getResource("findhospital.fxml"));
                    hospitalpane.getChildren().setAll(ap);
                    
                    stmt.close();
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            hospitalLabel.setText("you must fill search text field first!!");
            hospitalLabel.setStyle("-fx-text-fill:red;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
        }
        
        
        
        
    }
    
    public void loadChoose(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("choose.fxml"));
        hospitalpane.getChildren().setAll(ap);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         hospitalLabel.setStyle("-fx-text-fill:red;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
    }    
    
}
/**
  AnchorPane ap = FXMLLoader.load(getClass().getResource("findhospital.fxml"));
  hospitalpane.getChildren().setAll(ap);
 */