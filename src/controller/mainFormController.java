package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import parkSystemPackge.Bus;
import parkSystemPackge.CargoLorry;
import parkSystemPackge.Van;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class mainFormController {

    public static String numberOfVehicle;
    public static String typeOfVehicle;
    private final ObservableList parentDriversList = FXCollections.observableArrayList();
    private final ObservableList parentVehicleList = FXCollections.observableArrayList();
    public AnchorPane windowOne;
    public JFXComboBox cmbSelectVehicle;
    public JFXTextArea txtVehicleType;
    public JFXComboBox cmbDriver;
    public Label lblSlotNumber;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane logInForm;
    public JFXButton btnParkVehicleId;
    public JFXButton btnOnDeliveryShiftId;
    public String slotNo;
    public String setDate;
    public String dateTime;


    String[][] vehicle = {{"NA-3434", "Bus"}, {"KA-4563", "Van"}, {"58-3567", "Van"}, {"CCB-3568", "Van"}, {"GF-4358", "Van"}, {"CCB-3568", "Van"}, {"LM-6679", "Van"}, {"QA-3369", "Van"}, {"KB-3668", "Cargo Lorry"}, {"JJ-9878", "Cargo Lorry"}, {"GH-5772", "Cargo Lorry"}, {"XY-3536", "Cargo Lorry"}, {"YQ-3536", "Cargo Lorry"}, {"CBB-3566", "Cargo Lorry"}, {"QH-3444", "Cargo Lorry"}
    };
    Van v1 = new Van();
    Bus b1 = new Bus();
    CargoLorry c1 = new CargoLorry();

    private String name;

    public String dateAndTime() { // lode a table date And Time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public void btnParkVehicle(ActionEvent actionEvent) throws IOException {

        if (typeOfVehicle.equals("Van")) {
            v1.park(numberOfVehicle, typeOfVehicle);
        } else if (typeOfVehicle.equals("Bus")) {
            b1.park(numberOfVehicle, typeOfVehicle);
        } else if (typeOfVehicle.equals("Cargo Lorry")) {
            c1.park(numberOfVehicle, typeOfVehicle);
        }

        slotNo = lblSlotNumber.getText();
        setDate = dateAndTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/windowThree.fxml"));
        Parent parent = loader.load();
        windowThreeController controller = loader.getController();
        controller.setData(numberOfVehicle, typeOfVehicle, slotNo, setDate);
        controller.trigger();


    }


    public void btnOndDeliveryShift(ActionEvent actionEvent) throws IOException { //

        v1.leavePark(numberOfVehicle, typeOfVehicle);
        b1.leavePark(numberOfVehicle, typeOfVehicle);
        c1.leavePark(numberOfVehicle, typeOfVehicle);
        name = String.valueOf(cmbDriver.getValue());
        dateTime = dateAndTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/windowThree.fxml"));
        Parent parent = loader.load();
        windowThreeController controller= loader.getController();
        controller.setDataDelivery(numberOfVehicle,typeOfVehicle,name,dateTime);
        controller.triggerDelivery();
    }

    public void btnManagementLogIn(ActionEvent actionEvent) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/logWindow.fxml"));
        Parent parent = loader.load();
        logWindowController controller = loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage) windowOne.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void LocalTime() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void LocalDate() {

        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(DateFormatter.format(date));

    }

    public void initialize() throws InterruptedException {

        cmbAddValues();
        LocalTime();
        LocalDate();

        cmbDriver.setItems(parentDriversList); //add data to Driver cmb
        Bindings.bindContentBidirectional(parentDriversList, addDriveWindowController.getDriversList());

        cmbSelectVehicle.setItems(parentVehicleList); //add data to Driver cmb
        Bindings.bindContentBidirectional(parentVehicleList, addVehicleWindowController.getVehicleList());

    }

    public void cmbSelectVehicleOnAction(ActionEvent actionEvent) {

            for (int i = 0; i < vehicle.length; i++) {
                for (int j = 0; j < vehicle[1].length; j++) {
                    if (vehicle[i][0].equals(String.valueOf(cmbSelectVehicle.getValue()))) {
                        txtVehicleType.setText(vehicle[i][1]);
                        break;
                    }

                    numberOfVehicle = String.valueOf(cmbSelectVehicle.getValue());
                    typeOfVehicle = txtVehicleType.getText();
                    setParkingNumber();
                    break;

                }
            }
        }



    public void cmbAddValues() {
        for (int i = 0; i < vehicle.length; i++) {
            cmbSelectVehicle.getItems().addAll(vehicle[i][0]);
        }
    }

    private void setParkingNumber() {

        if (typeOfVehicle.equals("Van")) {
            lblSlotNumber.setText(v1.setSlot(numberOfVehicle, typeOfVehicle));


            if (v1.setSlot(numberOfVehicle, typeOfVehicle).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);

            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);

            }

        } else if (typeOfVehicle.equals("Bus")) {
            lblSlotNumber.setText(b1.setSlot(numberOfVehicle, typeOfVehicle));


            if (b1.setSlot(numberOfVehicle, typeOfVehicle).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);

            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);
            }

        } else if (typeOfVehicle.equals("Cargo Lorry")) {
            lblSlotNumber.setText(c1.setSlot(numberOfVehicle, typeOfVehicle));


            if (c1.setSlot(numberOfVehicle, typeOfVehicle).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);

            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);
            }

        }


    }


}
