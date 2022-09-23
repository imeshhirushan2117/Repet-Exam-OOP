package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import parkSystemPackge.Driver;


import java.util.ArrayList;

public class addDriveWindowController {
    public AnchorPane addDriverFormId;
    public JFXButton btnAddDriverIdOne;
    public JFXTextField txtAddDriverNameId;
    public JFXTextField txtAddDriverLicenseNoId;
    public JFXTextField txtAddDriverAddressId;
    public JFXTextField txtAddDriverNicId;
    public JFXTextField txtAddDriverContactNoId;
    public String name;
    public String driverNic;
    public String licenseNum;
    public String driverAddress;
    public int driverContactNum;
    public static ObservableList driversList = FXCollections.observableArrayList();

    public static ObservableList getDriversList() {
        return driversList;
    }

    public void texDriverNameOnAction(ActionEvent actionEvent) {

    }

    public void btnAddDriverIdOneOnAction(ActionEvent actionEvent) {

         name = txtAddDriverNameId.getText();
         driverNic = txtAddDriverNicId.getText();
         licenseNum = txtAddDriverLicenseNoId.getText();
         driverAddress = txtAddDriverAddressId.getText();

        try {
            driverContactNum = Integer.parseInt(txtAddDriverContactNoId.getText());
        } catch (NumberFormatException e) {
            System.out.println("contact number not string");
        }
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        Driver drivers1 = new Driver(name,driverNic,licenseNum,driverAddress,driverContactNum);
        drivers.add(drivers1);
        clearField();


        for (Driver temp : drivers) {
            driversList.add(temp);
        }

    }

    public void clearField() {
        txtAddDriverNameId.clear();
        txtAddDriverNicId.clear();
        txtAddDriverLicenseNoId.clear();
        txtAddDriverContactNoId.clear();
        txtAddDriverAddressId.clear();
    }
}
