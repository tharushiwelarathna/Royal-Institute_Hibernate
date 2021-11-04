package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.RegistrationBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.RegisterDAO;
import lk.ijse.hibernate.dto.CourseDTO;
import lk.ijse.hibernate.dto.RegistrationDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Course;
import lk.ijse.hibernate.entity.Registration;
import lk.ijse.hibernate.entity.Student;

public class RegistrationBOImpl implements RegistrationBO {

    RegisterDAO daoImpl = DAOFactory.getInstance().getDao(DAOType.REGISTRATION);

    @Override
    public boolean save(RegistrationDTO dto) throws Exception {

        StudentDTO studentDTO = dto.getStudentDTO();
        Student student = new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getDob(), studentDTO.getGender());
        CourseDTO courseDTO = dto.getCourseDTO();
        Course course = new Course(courseDTO.getCode(), courseDTO.getCourseName(),courseDTO.getCourseType(), courseDTO.getDuration());
        return daoImpl.add(new Registration(dto.getRegNo(),dto.getRegDate(),dto.getRegFee(),student,course));


    }
}
