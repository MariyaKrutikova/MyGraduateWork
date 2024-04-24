package ru.geekbrains.graduatework.services;
import ru.geekbrains.graduatework.dao.OrganisationTypeDAO;
import ru.geekbrains.graduatework.models.OrganisationType;
import java.util.List;

/**
 * Класс OrganisationTypeService.
 * Имеет поле <b>ORGANISATION_TYPE_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class OrganisationTypeService {
    /**
     * Поле ДАО
     * */
    private final OrganisationTypeDAO ORGANISATION_TYPE_DAO = new OrganisationTypeDAO();
    /**
     * Конструктор по умолчанию
     * */
    public OrganisationTypeService() {
    }

    /**
     * Метод получения типа организации по ID
     * @param id объекта
     * @return тип организации
     * */
    public OrganisationType getById(int id){
        return ORGANISATION_TYPE_DAO.getById(id);
    }

    /**
     * Метод получения всех типов организации
     * @return список всех типов организации
     * */
    public List<OrganisationType> getAll(){
        return ORGANISATION_TYPE_DAO.getAll();
    }

    /**
     * Метод получения количества всех типов организации
     * @return количество типов организации
     * */
    public int getCount(){
        return ORGANISATION_TYPE_DAO.getCount();
    }

    /**
     * Метод добавления нового типа организации
     */
    public void save(OrganisationType organisationType){
        ORGANISATION_TYPE_DAO.save(organisationType);
    }

    /**
     * Метод изменения сведений о типе организации
     * */
    public void update(){
        ORGANISATION_TYPE_DAO.update();
    }

    /**
     * Метод удаления контейнера по id
     * */
    public void deleteByID(int id){
        ORGANISATION_TYPE_DAO.deleteByID(id);
    }
}
