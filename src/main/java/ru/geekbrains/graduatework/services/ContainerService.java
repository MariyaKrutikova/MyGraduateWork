package ru.geekbrains.graduatework.services;
import ru.geekbrains.graduatework.dao.ContainerDAO;
import ru.geekbrains.graduatework.models.*;

import java.util.List;

/**
 * Класс ContainerService.
 * Имеет поле <b>CONTAINER_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ContainerService {
    /**
     * Поле контейненр ДАО
     * */
    private final ContainerDAO CONTAINER_DAO = new ContainerDAO ();

    /**
     * Конструктор по умолчанию
     * */
    public ContainerService() {
    }

    /**
     * Метод получения контейнера по ID
     * @param id объекта
     * @return контейнер
     * */
    public Container getById(int id){
        return CONTAINER_DAO.getById(id);
    }

    /**
     * Метод получения всех контейнеров
     * @return список всех контейнеров
     * */
    public List<Container> getAll(){
        return CONTAINER_DAO.getAll();
    }

    /**
     * Метод получения количества всех контейнеров
     * @return количество контейнеров
     * */
    public int getCount(){
        return CONTAINER_DAO.getCount();
    }

    /**
     * Метод добавления нового контейнера
     */
    public void save(Container container){
        CONTAINER_DAO.save(container);
    }

    /**
     * Метод изменения сведений о контейнера
     * */
    public void update(){
        CONTAINER_DAO.update();
    }

    /**
     * Метод удаления контейнера по id
     * */
    public void deleteByID(int id){
        CONTAINER_DAO.deleteByID(id);
    }
}
