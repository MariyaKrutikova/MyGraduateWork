package ru.geekbrains.graduatework.dao;
import org.hibernate.Session;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;


/**
 * data access objec. Доступ к данным сущности контейнер*/
public class ContainerDAO extends AbstractEntityDAO{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public ContainerDAO() {
        super(Container.class);
    }

    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id контейнера, сведения по которому будут изменены: ");
            int id = scanner.nextInt();
            Container container = session.get(Container.class, (Serializable) id);
            System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + container);

            System.out.println("ВВЕДИТЕ НОВОЕ НАЗВАНИЕ: ");
            String name = scanner.next();
            container.setContainerName(name);
            session.beginTransaction();
            session.update(container);
            session.getTransaction().commit();
            System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + container);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
