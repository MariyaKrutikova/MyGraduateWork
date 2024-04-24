package ru.geekbrains.graduatework.services;

import ru.geekbrains.graduatework.dao.ContentTypeDAO;
import ru.geekbrains.graduatework.models.ContentType;

import java.util.List;
/**
 * Класс ContentTypeService.
 * Имеет поле <b>CONTENT_TYPE_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ContentTypeService {
    /**
     * Поле тип содержимого ДАО
     * */
    private final ContentTypeDAO CONTENT_TYPE_DAO = new ContentTypeDAO();

    /**
     * Конструктор по умолчанию
     * */
    public ContentTypeService() {
    }

    /**
     * Метод получения типа содержимого по ID
     * @param id объекта
     * @return тип содержимого
     * */
    public ContentType getById(int id){
        return (ContentType) CONTENT_TYPE_DAO.getById(id);
    }

    /**
     * Метод получения всех типов содержимого
     * @return список всех типов содержимого
     * */
    public List<jdk.jfr.ContentType> getAll(){
        return CONTENT_TYPE_DAO.getAll();
    }

    /**
     * Метод получения количества типов содержимого
     * @return количество типов содержимого
     * */
    public int getCount(){
        return CONTENT_TYPE_DAO.getCount();
    }

    /**
     * Метод добавления нового типа содержимого
     */
    public void save(ContentType contentType){
        CONTENT_TYPE_DAO.save((jdk.jfr.ContentType) contentType);
    }

    /**
     * Метод изменения типа содержимого
     * */
    public void update(){
        CONTENT_TYPE_DAO.update();
    }

    /**
     * Метод удаления по id
     * */
    public void deleteByID(int id){
        CONTENT_TYPE_DAO.deleteByID(id);
    }
}
