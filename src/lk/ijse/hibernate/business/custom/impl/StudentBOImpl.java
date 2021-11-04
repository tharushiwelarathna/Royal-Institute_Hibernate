package lk.ijse.hibernate.business.custom.impl;


import lk.ijse.hibernate.business.custom.StudentBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl daoImpl = DAOFactory.getInstance().getDao(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO dto) throws Exception {
        return daoImpl.add(new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getDob(),
                dto.getGender()
        ));
    }

    @Override
    public boolean update(StudentDTO dto) throws Exception {
        return daoImpl.update(new Student(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getDob(),
                dto.getGender()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return daoImpl.delete(id);
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<Student> all = daoImpl.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        for (Student s : all) {
            dtoList.add(new StudentDTO(
                    s.getId(),
                    s.getStudentName(),
                    s.getAddress(),
                    s.getContact(),
                    s.getDob(),
                    s.getGender()
            ));
        }
        return dtoList;

    }

    @Override
    public StudentDTO find(String s) throws Exception {
        Student student = daoImpl.find(s);

        return new StudentDTO(
                student.getId(),
                student.getStudentName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender()
        );
    }
}
