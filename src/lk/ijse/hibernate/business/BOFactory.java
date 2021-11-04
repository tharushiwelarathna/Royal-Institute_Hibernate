package lk.ijse.hibernate.business;

import lk.ijse.hibernate.business.custom.impl.CourseBOImpl;
import lk.ijse.hibernate.business.custom.impl.RegistrationBOImpl;
import lk.ijse.hibernate.business.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance() {
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO>T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();

            default:
                return null;
        }
    }

}
