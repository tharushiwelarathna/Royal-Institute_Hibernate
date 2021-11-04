package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.CourseBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.SuperDAO;
import lk.ijse.hibernate.dao.custom.impl.CourseDAOImpl;
import lk.ijse.hibernate.dto.CourseDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Course;
import lk.ijse.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAOImpl daoImpl = DAOFactory.getInstance().getDao(DAOType.COURSE);

    @Override
    public boolean add(CourseDTO dto) throws Exception {
        return daoImpl.add(new Course(
                dto.getCode(),
                dto.getCourseName(),
                dto.getCourseType(),
                dto.getDuration()
        ));
    }

    @Override
    public boolean update(CourseDTO dto) throws Exception {
        return daoImpl.update(new Course(
                dto.getCode(),
                dto.getCourseName(),
                dto.getCourseType(),
                dto.getDuration()
        ));
    }

    @Override
    public boolean delete(String s) throws Exception {
        return daoImpl.delete(s);
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<Course> all = daoImpl.getAll();
        ArrayList<CourseDTO> dtoList = new ArrayList<>();

        for (Course s : all) {
            dtoList.add(new CourseDTO(
                    s.getCode(),
                    s.getCourseName(),
                    s.getCourseType(),
                    s.getDuration()
            ));
        }
        return dtoList;
    }

    @Override
    public CourseDTO find(String s) throws Exception {
        return null;
    }

    @Override
    public List<String> getCourseName() throws Exception {
        return daoImpl.getCourseName();
    }

}
