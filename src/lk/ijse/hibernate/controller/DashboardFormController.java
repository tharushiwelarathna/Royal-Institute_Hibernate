package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane root;
    public AnchorPane mainRoot;

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        this.mainRoot.getChildren().clear();
        this.mainRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashboardForm.fxml")));

    }

    public void btnStudentManagementOnAction(ActionEvent actionEvent) throws IOException {
            initUi("StudentForm.fxml");
    }

    public void btnCourseManagementOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegistrationForm.fxml");
    }

    public void btnFindOnAction(ActionEvent actionEvent) throws IOException {
        initUi("FindForm.fxml");
    }
    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location)));


    }

}
