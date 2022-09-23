package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.inParkingTm;
import view.tm.onDeliveryTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class windowThreeController {
    public AnchorPane windowThreeForm;
    public JFXComboBox cmbInParkingAndOnDelivery;
    public JFXButton btnLogOutId;
    public TableView <inParkingTm> tblInParkId;
    public TableView <onDeliveryTm> tblOnDeliveryId;
    public TableColumn tblVehicleNumber;
    public TableColumn tblVehicleType;
    public TableColumn tblParkingSlot;
    public TableColumn tblParkedTime;
    public String no;
    public String type;
    public String slotNo;
    public String dateTime;
    public String name;


    static ArrayList<inParkingTm> tmArrayList =  new ArrayList();
    static ArrayList<onDeliveryTm> tmOnDeliveryArrayList =new ArrayList();

    public TableColumn tblVehicleNumberTwoId;
    public TableColumn tblVehicleTypeTwoId;
    public TableColumn tblParkingSlotId;
    public TableColumn tblParkedIdTimeId;

    public void btnLogOutOne(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage) windowThreeForm.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
    }
    public void  clearWindow(Stage stage)  {
       // System.out.println("Cancel Window");
        stage.close();
    }

    public void parkOnAction(){
        inParkingTm inParkingTm = new inParkingTm(no,type,slotNo,dateTime);
        tblInParkId.getItems().addAll(inParkingTm);

    }

    public void initialize(){

        cmbInParkingAndOnDelivery.getItems().addAll("In Parking", "On Delivery");
        cmbInParkingAndOnDelivery.setValue("In Parking");
        tblInParkId.setItems(FXCollections.observableArrayList(tmArrayList));

        tblVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        tblVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblParkingSlot.setCellValueFactory(new PropertyValueFactory<>("vehicleParkingSlotNum"));
        tblParkedTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));

        //=====================================

        tblOnDeliveryId.setItems(FXCollections.observableArrayList(tmOnDeliveryArrayList));

        tblVehicleNumberTwoId.setCellValueFactory(new PropertyValueFactory<>("vehicleNum"));
        tblVehicleTypeTwoId.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblParkingSlotId.setCellValueFactory(new PropertyValueFactory<>("DriverName"));
        tblParkedIdTimeId.setCellValueFactory(new PropertyValueFactory<>("leftTime"));


    }
    public void cmbInParkingAndOnDeliveryOnAction(ActionEvent actionEvent) {
        if (cmbInParkingAndOnDelivery.getValue().equals("On Delivery")) {
            btnLogOutId.setVisible(false);

            tblInParkId.setVisible(false);
            tblOnDeliveryId.setVisible(true);
        } else {
            btnLogOutId.setVisible(true);

            tblInParkId.setVisible(true);
            tblOnDeliveryId.setVisible(false);
        }

    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/addVehicleWindow.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/addDreiveWindow.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void setData(String no, String type, String slotNo, String dateTime){
        this.no=no;
        this.type=type;
        this.slotNo=slotNo;
        this.dateTime=dateTime;
    }
    public void setDataDelivery (String no, String type, String name, String dateTime){
        this.no=no;
        this.type=type;
        this.name=name;
        this.dateTime=dateTime;
    }

    public  void trigger (){

        tmArrayList.add(new inParkingTm(no,type,slotNo,dateTime));
    }


    public void triggerDelivery() {
        tmOnDeliveryArrayList .add(new onDeliveryTm(no,type,name,dateTime));
    }


}
