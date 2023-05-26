package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController
{

    public static String currentUser="";
    @FXML
    private Label lstatus,rstatus;
    @FXML
    private Button regbtn,loginbtn;
    @FXML
    private TextField username,password,fnameField,lnameField,unameField,emailField,passField,pass1Field,cityField,phoneField;
    @FXML
    private DatePicker dobField;
    String fname,lname,uname,pass,pass1,email,city;
    Long phone;
    Date dob;

    Stage stage;
    Parent root;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        if(event.getSource()==loginbtn)
        {
            ResultSet rs;
            try {
                Connection conn = DatabaseConnection.Connector();
                Statement stmt;
                if (conn != null)
                {
                    stmt = conn.createStatement();
                    String Query="Select * from accounts WHERE (uname='"+username.getText()+"' AND pass='"+password.getText()+"')";
                    rs=stmt.executeQuery(Query);
                    if(rs.next()) {
                        lstatus.setText(rs.getString(2)+" Logged In");
                        currentUser=username.getText();
                        stage=(Stage) loginbtn.getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("view/home.fxml"));
                        stage.setTitle("Techno Market - Home ("+currentUser+")");
                        stage.setScene(new Scene(root,800,620));
                        stage.show();

                        HomeController hc = new HomeController();
                        hc.showUser();
                        //hc.showStatus(rs.getString(1));
                        //loginstatus.setText(rs.getString(1)+" Logged In Successfully");
                        stage.setResizable(false);
                    }
                    else {
                        lstatus.setText("Login Failed");
                    }
                    conn.commit();
                    stmt.close();
                    conn.close();
                }
            }
            catch (Exception e){}
        }
        else if(event.getSource()==regbtn)
        {
            fname = fnameField.getText();
            lname = lnameField.getText();
            uname = unameField.getText();
            email = emailField.getText();
            pass = passField.getText();
            try {
                phone  = Long.valueOf(phoneField.getText());
                dob = Date.valueOf(dobField.getValue());
            }catch (Exception e){}
            city = cityField.getText();

            try {
                Connection conn =DatabaseConnection.Connector();
                Statement stmt;
                if (conn != null)
                {
                    rstatus.setText("Registration Successful");
                    stmt = conn.createStatement();
                    //String sql = "DELETE FROM accounts";
                    String sql = "INSERT INTO accounts VALUES ('Admin','"+fname+"','"+lname+"','"+uname+"','"+email+"','"+pass+"','"+phone+"','"+dob+"','"+city+"')";
                    stmt.executeUpdate(sql);
                    conn.commit();
                    stmt.close();
                    conn.close();
                }
            }
            catch (Exception e){}
        }
    }

}
