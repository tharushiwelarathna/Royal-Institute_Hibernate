package lk.ijse.hibernate.business.custom;

import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.dto.RegistrationDTO;

public interface RegistrationBO extends SuperBO {
    public boolean save(RegistrationDTO dto) throws Exception;
}
