package lk.ijse.hibernate.business.custom;

import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO dto) throws Exception;

    public boolean update(StudentDTO dto) throws Exception;

    public boolean delete(String id) throws Exception;

    public List<StudentDTO> getAll() throws Exception;

    public StudentDTO find(String s) throws Exception;
}
