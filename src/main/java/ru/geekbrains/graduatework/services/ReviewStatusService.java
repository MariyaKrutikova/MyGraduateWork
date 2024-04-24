package ru.geekbrains.graduatework.services;

import ru.geekbrains.graduatework.dao.ReviewStatusDAO;
import ru.geekbrains.graduatework.models.ReviewStatus;

import java.util.List;

/**
 * Класс ReviewStatusService.
 * Имеет поле <b>REVIEW_STATUS_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ReviewStatusService {
    /**
     * Поле ДАО
     * */
    private final ReviewStatusDAO REVIEW_STATUS_DAO =new ReviewStatusDAO();

    /**
     * Конструктор по умолчанию
     * */
    public ReviewStatusService() {
    }

    /**
     * Метод получения статуса пересмотра по ID
     * @param id объекта
     * @return статус пересмотра
     * */
    public ReviewStatus getById(int id){
        return REVIEW_STATUS_DAO.getById(id);
    }

    /**
     * Метод получения всех статусов пересмотра
     * @return список всех статусов пересмотра
     * */
    public List<ReviewStatus> getAll(){
        return REVIEW_STATUS_DAO.getAll();
    }

    /**
     * Метод получения количества всех статусов пересмотра
     * @return количество статусов пересмотра
     * */
    public int getCount(){
        return REVIEW_STATUS_DAO.getCount();
    }

    /**
     * Метод добавления нового статуса пересмотра
     */
    public void save(ReviewStatus reviewStatus){
        REVIEW_STATUS_DAO.save(reviewStatus);
    }

    /**
     * Метод изменения статуса пересмотра
     * */
    public void update(){
        REVIEW_STATUS_DAO.update();
    }

    /**
     * Метод удаления статуса пересмотра по id
     * */
    public void deleteByID(int id){
        REVIEW_STATUS_DAO.deleteByID(id);
    }
}
