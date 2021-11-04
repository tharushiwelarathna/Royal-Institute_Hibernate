package lk.ijse.hibernate.business.custom;

import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.dto.CourseDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Course;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean add(CourseDTO dto) throws Exception;

    public boolean update(CourseDTO dto) throws Exception;

    public boolean delete(String s) throws Exception;

    public List<CourseDTO> getAll() throws Exception;

    public CourseDTO find(String s) throws Exception;

    public List<String> getCourseName() throws Exception;
}
