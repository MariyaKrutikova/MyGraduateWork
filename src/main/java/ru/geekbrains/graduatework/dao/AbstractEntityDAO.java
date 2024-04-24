package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Абстрактный класс AbstractEntityDAO с двумя обобщенными параметрами. T - тип объекта, Х - тип id объекта
 * Имеет поля <b>clazz</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public abstract class AbstractEntityDAO<T,X> {

    private final Class<T> clazz;
    private static HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();

    /**
     * Конструктор - создания объета с обобщенным параметром
     * */
    public AbstractEntityDAO(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    /**
     * Обобщенный метод получения объекта по его  ID
     * @param id объекта. Х - обощенный параметра обозначающий тип id
     * @return объект класса T
     * */
    public T getById(X id) {
        try (Session session = connectorUtil.getSession()) {
            T obj = session.get(clazz, (Serializable) id);
            if (obj == null) System.out.println("Записи с таким ID нет в таблице");
            else System.out.println(obj);
            return  obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Обобщенный метод получения всех объектов класса Т
     * @return список объектов класса T
     * */
    public List<T> getAll() {
        try (Session session = connectorUtil.getSession()) {
            Query query = session.createQuery("FROM " + clazz.getName(), clazz);
            List objs = query.getResultList();
            for (Object obj : objs) {
                System.out.println(obj.toString());
            }
            return objs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод получения количества всех объектов класса Т
     * @return количество объектов класса T
     * */
    public int getCount() {
        try (Session session = connectorUtil.getSession()) {
//            System.out.println(clazz.getName());
            Query query = session.createQuery("SELECT COUNT(*) FROM " + clazz.getName());
//            System.out.println(query);
            Long count = (Long) query.getSingleResult();
            int totalCount = count.intValue();
            System.out.println(count);
            return totalCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Метод добавления объекта класса Т в соответствующую таблицу базы данных
     * */
    public void save(final T entity) {
        try (Session session = connectorUtil.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Новая запись добавлена в таблицу");
    }

    /**
     * Абстрактный метод изменения объекта класса Т
     * */
    abstract void update();


    /**
     * Метод удаления объекта класса Т по id
     * */
    public void deleteByID(X id) {
        try (Session session = connectorUtil.getSession()) {
            session.beginTransaction();
            T obj = session.get(clazz, (Serializable) id);
            if (obj == null) System.out.println("Записи с таким ID нет в таблице");
            else {
                session.delete(obj);
                session.getTransaction().commit();
                session.close();
                System.out.println("Запись удалена из таблицы");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
