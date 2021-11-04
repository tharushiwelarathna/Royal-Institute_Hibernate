package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.entity.Course;

import javax.swing.*;
import java.util.List;

public interface CourseDAO extends SuperDAO<Course, String> {
    public List<String> getCourseName() throws Exception;

}
