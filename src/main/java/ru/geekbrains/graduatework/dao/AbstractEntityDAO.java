package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractEntityDAO<T,X> {

    private final Class<T> clazz;
    private static HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public AbstractEntityDAO(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    //Получить объект по его id
    public T getById(X id) {
        try (Session session = connectorUtil.getSession()) {
            T obj = session.get(clazz, (Serializable) id);
            System.out.println(obj);
            return  obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    //Получить список объектов по заданному диапазону
//        public List<T> getItems(int from, int count) {
//            Query query = getCurrentSession().createQuery(clazz , "from " + clazz.getName());
//            query.setFirstResult(offset);
//            query.setMaxResults(count);
//            return (List<T>) query.getSingleResult();
//        }

    //Получить все объекты данного типа
    public List<T> getAll() {
        try (Session session = connectorUtil.getSession()) {
            Query query = session.createQuery("FROM " + clazz.getName(), clazz);
            List objs = query.getResultList();
            for (Object obj : objs) {
                System.out.println(obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Узнать количество объектов
    public int getCount() {
        try (Session session = connectorUtil.getSession()) {
            System.out.println(clazz.getName());
            Query query = session.createQuery("SELECT COUNT(*) FROM " + clazz.getName());
            System.out.println(query);
            Long count = (Long) query.getSingleResult();
            int totalCount = count.intValue();
            System.out.println(count);
            return totalCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Добавить объект в базу
    public void save(final T entity) {
        try (Session session = connectorUtil.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Обновить объект по id в базе
    abstract void update();
//        try (Session session = connectorUtil.getSession()) {
//            T obj = session.get(clazz, (Serializable) id);
//            System.out.println(obj);
//            obj.
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    //    Удалить объект по id из базы
    public void deleteByID(X id) {
        try (Session session = connectorUtil.getSession()) {
            session.beginTransaction();
            T obj = session.get(clazz, (Serializable) id);
            System.out.println(obj);
            session.delete(obj);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
