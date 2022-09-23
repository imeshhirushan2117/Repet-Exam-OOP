package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import parkSystemPackge.Vehicle;
import parkSystemPackge.vehicleData;

import java.util.ArrayList;
import java.util.Vector;

public class addVehicleWindowController {

    public static ObservableList vehicleList = FXCollections.observableArrayList();
    public JFXButton btnAddVehicleOneId;
    public JFXTextField txtVehicleNumberId;
    public JFXTextField txtMaximumWeightId;
    public JFXComboBox cmbVehicleTypeId;
    public JFXTextField txtNoOfPassengersId;
    private String number;
    private String type;
    private int weight;
    private int noPassenger;

    public static ObservableList getVehicleList() {
        return vehicleList;
    }

    public void btnAddVehicleOneOnAction(ActionEvent actionEvent) {

        number = txtVehicleNumberId.getText();
        type =(String) cmbVehicleTypeId.getValue();
        weight = Integer.parseInt(txtMaximumWeightId.getText());
        noPassenger = Integer.parseInt(txtNoOfPassengersId.getText());

        ArrayList <vehicleData> vehicleArrayList = new ArrayList<>();
        vehicleData vehicle = new vehicleData (number,type,weight,noPassenger);
        vehicleArrayList.add(vehicle);
        for (vehicleData temp : vehicleArrayList) {
            vehicleList.add(temp);
        }
        clearField();
    }

    public void cmbVehicleTypeOnAction(ActionEvent actionEvent) {

    }

    public void initialize(){

        cmbVehicleTypeId.getItems().addAll(
                "Van","Cargo Lorry","Bus"
        );
    }

    public void clearField() {
        txtVehicleNumberId.clear();
        txtMaximumWeightId.clear();
        txtNoOfPassengersId.clear();
    }
}

