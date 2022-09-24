package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class logWindowController {
    public JFXButton btnIdCancel;
    public AnchorPane logInForm;
    public JFXTextField txtFldUserName;
    public JFXPasswordField txtFldPassword;
    public Label lblAttempts;
    public JFXButton btnLogId;
    private Stage stage = null;

    public void btnCancel(ActionEvent actionEvent) {

        Stage stage = (Stage) btnIdCancel.getScene().getWindow();
        stage.close();
    }

    public void btnLog(ActionEvent actionEvent) throws IOException {

        if (txtFldPassword.getText().equals("1") & txtFldUserName.getText().equals("1")) {
            URL resource = getClass().getResource("../view/windowThree.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) btnIdCancel.getScene().getWindow();
            window.setScene(new Scene(load));
            closeWindow();
        } else {
            lblAttempts.setVisible(true);
        }
    }

    void getStage(Stage stage) {
        this.stage = stage;
    }

    public void closeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/windowThree.fxml"));
        Parent parent = loader.load();
        windowThreeController controller = loader.getController();
        controller.clearWindow(stage);

    }

    //==============Enter button=====================
    public void txtUserNameOnAction(ActionEvent actionEvent) {
        txtFldPassword.requestFocus();
    }
    //======================================
}
