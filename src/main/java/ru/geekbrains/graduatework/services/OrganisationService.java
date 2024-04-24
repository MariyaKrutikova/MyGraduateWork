package ru.geekbrains.graduatework.services;
import ru.geekbrains.graduatework.dao.OrganisationDAO;
import ru.geekbrains.graduatework.models.Organisation;

import java.util.List;

/**
 * Класс OrganisationService.
 * Имеет поле <b>ORGANISATION_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class OrganisationService {
    /**
     * Поле ДАО
     * */
    private final OrganisationDAO ORGANISATION_DAO = new OrganisationDAO();
    /**
     * Конструктор по умолчанию
     * */
    public OrganisationService() {
    }

    /**
     * Метод получения организации по ID
     * @param id объекта
     * @return организация
     * */
    public Organisation getById(int id){
        return ORGANISATION_DAO.getById(id);
    }

    /**
     * Метод получения всех организаций
     * @return список всех организаций
     * */
    public List<Organisation> getAll(){
        return ORGANISATION_DAO.getAll();
    }

    /**
     * Метод получения количества всех организаций
     * @return количество организаций
     * */
    public int getCount(){
        return ORGANISATION_DAO.getCount();
    }

    /**
     * Метод добавления новой организации
     */
    public void save(Organisation organisation){
        ORGANISATION_DAO.save(organisation);
    }
    /**
     * Метод изменения сведений об организации
     * */
    public void update(){
        ORGANISATION_DAO.update();
    }

    /**
     * Метод удаления организации по id
     * */
    public void deleteByID(int id){
        ORGANISATION_DAO.deleteByID(id);
    }
}

