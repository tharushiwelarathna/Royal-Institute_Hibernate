package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity, ID extends Serializable> {
    public boolean add(Entity entity) throws Exception;

    public boolean update(Entity entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public Entity find(ID id) throws Exception;

    public List<Entity> getAll() throws Exception;
}
