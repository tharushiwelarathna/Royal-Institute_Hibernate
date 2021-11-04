package lk.ijse.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.business.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.hibernate.view.tm.StudentTM;
import org.hibernate.Session;
import org.hibernate.Transaction;
import lk.ijse.hibernate.util.FactoryConfiguration;

import java.util.List;

public class StudentFormController {
    @FXML
    private TableView<StudentTM> tblStudent;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML/*configuration.setProperties(properties);*/
    private TextField txtContact;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtDateOfBirth;


    StudentBOImpl boImpl = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize(){
        getAll();
        setCellValueFactory();
        tableListener();
    }

    private void tableListener(){
        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(StudentTM tm) {
        try {
            txtId.setText(tm.getId());
            txtName.setText(tm.getStudentName());
            txtAddress.setText(tm.getAddress());
            txtDateOfBirth.setText(String.valueOf(tm.getDob()));
            txtContact.setText(tm.getContact());
            txtGender.setText(tm.getGender());
        }catch (Exception e){

        }
    }

    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
    }

    void getAll() {
        try {
            ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
            List<StudentDTO> all = null;
            all = boImpl.getAll();
            for (StudentDTO dto : all) {
                Button btn = new Button("Delete");
                StudentTM tm = new StudentTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getDob(),
                        dto.getGender()
                );
                tmList.add(tm);
          }
            tblStudent.setItems(tmList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();
        try {
            if(boImpl.delete(id)){
                new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?").showAndWait();
                txtId.setText(null);
                txtGender.setText(null);
                txtContact.setText(null);
                txtDateOfBirth.setText(null);
                txtName.setText(null);
                txtAddress.setText(null);
                getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String dob = txtDateOfBirth.getText();
        String gender = txtGender.getText();
        try {
            if(boImpl.add(new StudentDTO(
                    id,
                    name,
                    address,
                    contact,
                    dob,
                    gender
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved..!").show();
                getAll();
                txtId.setText(null);
                txtGender.setText(null);
                txtContact.setText(null);
                txtDateOfBirth.setText(null);
                txtName.setText(null);
                txtAddress.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String dob = txtDateOfBirth.getText();
        String gender = txtGender.getText();
        try {
            if (boImpl.update(new StudentDTO(
                    id,
                    name,
                    address,
                    contact,
                    dob,
                    gender
            ))){
                txtId.setText(null);
                txtGender.setText(null);
                txtContact.setText(null);
                txtDateOfBirth.setText(null);
                txtName.setText(null);
                txtAddress.setText(null);
                //new Alert(Alert.AlertType.CONFIRMATION,"Updated..!").show();
                getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
