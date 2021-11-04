package lk.ijse.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.business.custom.impl.CourseBOImpl;
import lk.ijse.hibernate.dto.CourseDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.view.tm.CourseTM;
import lk.ijse.hibernate.view.tm.StudentTM;

import java.util.List;

public class CourseFormController {
    public TableView<CourseTM> tblCourse;


    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TextField txtcode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtDuration;

    CourseBOImpl boImpl = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize(){
        getAll();
        setCellValueFactory();
        tableListener();
    }

    private void tableListener(){
        tblCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(CourseTM tm) {
        try {
            txtcode.setText(tm.getCode());
            txtName.setText(tm.getCourseName());
            txtType.setText(tm.getCourseType());
            txtDuration.setText(tm.getDuration());
        }catch (Exception e){

        }
    }
    void getAll() {
        try {
            ObservableList<CourseTM> tmList = FXCollections.observableArrayList();
            List<CourseDTO> all = null;
            all = boImpl.getAll();
            for (CourseDTO dto : all) {
                Button btn = new Button("Delete");
                CourseTM tm = new CourseTM(
                        dto.getCode(),
                        dto.getCourseName(),
                        dto.getCourseType(),
                        dto.getDuration()
                );
                tmList.add(tm);
            }
            tblCourse.setItems(tmList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCellValueFactory(){
        colCode.setCellValueFactory(new PropertyValueFactory("code"));
        colName.setCellValueFactory(new PropertyValueFactory("courseName"));
        colType.setCellValueFactory(new PropertyValueFactory("courseType"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            if(boImpl.delete(txtcode.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "are you sure to delete?").showAndWait();
                txtDuration.setText(null);
                txtName.setText(null);
                txtcode.setText(null);
                txtType.setText(null);
                getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            if(boImpl.add(new CourseDTO(
                    txtcode.getText(),
                    txtName.getText(),
                    txtType.getText(),
                    txtDuration.getText()
            ))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
                txtDuration.setText(null);
                txtName.setText(null);
                txtcode.setText(null);
                txtType.setText(null);
                getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            if(boImpl.update(new CourseDTO(
                    txtcode.getText(),
                    txtName.getText(),
                    txtType.getText(),
                    txtDuration.getText()
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"updated..!").show();
                txtDuration.setText(null);
                txtName.setText(null);
                txtcode.setText(null);
                txtType.setText(null);
                getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
