package ru.geekbrains.graduatework.services;
import ru.geekbrains.graduatework.dao.RefusalReasonDAO;
import ru.geekbrains.graduatework.models.RefusalReason;

import java.util.List;

/**
 * Класс RefusalReasonService.
 * Имеет поле <b>REFUSAL_REASON_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class RefusalReasonService {
    /**
     * Поле ДАО
     * */
    private final RefusalReasonDAO REFUSAL_REASON_DAO =new RefusalReasonDAO();

    /**
     * Конструктор по умолчанию
     * */
    public RefusalReasonService() {
    }

    /**
     * Метод получения причины отказа по ID
     * @param id объекта
     * @return причина отказа
     * */
    public RefusalReason getById(int id){
        return REFUSAL_REASON_DAO.getById(id);
    }

    /**
     * Метод получения всех причин отказа
     * @return список всех причин отказа
     * */
    public List<RefusalReason> getAll(){
        return REFUSAL_REASON_DAO.getAll();
    }

    /**
     * Метод получения количества всех причин отказа
     * @return количество причин отказа
     * */
    public int getCount(){
        return REFUSAL_REASON_DAO.getCount();
    }

    /**
     * Метод добавления новой причины отказа
     */
    public void save(RefusalReason refusalReason){
        REFUSAL_REASON_DAO.save(refusalReason);
    }

    /**
     * Метод изменения причины отказа
     * */
    public void update(){
        REFUSAL_REASON_DAO.update();
    }

    /**
     * Метод удаления причины отказа по id
     * */
    public void deleteByID(int id){
        REFUSAL_REASON_DAO.deleteByID(id);
    }
}
