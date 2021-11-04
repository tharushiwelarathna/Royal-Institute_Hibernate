package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.Course;
import lk.ijse.hibernate.entity.Registration;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static Properties properties;
    private SessionFactory factory;

    private FactoryConfiguration(){
       // Configuration configuration = new Configuration().configure();
        properties = new Properties();

        try {
            //load property file
            properties.load(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("hibernate.properties"));

             factory = new Configuration().addAnnotatedClass(Student.class)
                     .addAnnotatedClass(Course.class)
                     .addAnnotatedClass(Registration.class)
                     .mergeProperties(properties).buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ?
                factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
