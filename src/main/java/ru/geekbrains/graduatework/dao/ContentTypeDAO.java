package ru.geekbrains.graduatework.dao;

import jdk.jfr.ContentType;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

/**
 * Класс ContentTypeDAO. Наследуется от абстрактного класса AbstractEntityDAO. Доступ к данным сущности тип содержимого.
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ContentTypeDAO extends AbstractEntityDAO<ContentType, Integer>{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public ContentTypeDAO() {
        super(ContentType.class);
    }


    /**
     * Метод изменения сведений о типе содержимого в базе данных.
     * При вызове метода сначала необходимо указать ID типа содержимого.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {

    }
}
