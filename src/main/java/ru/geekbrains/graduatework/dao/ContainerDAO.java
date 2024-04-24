package ru.geekbrains.graduatework.dao;
import org.hibernate.Session;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;


/**
 * Класс ContainerDAO. Наследуется от абстрактного класса AbstractEntityDAO.Доступ к данным сущности контейнер
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ContainerDAO extends AbstractEntityDAO<Container, Integer>{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public ContainerDAO() {
        super(Container.class);
    }

    /**
     * Метод изменения сведений о контейнере в базе данных.
     * При вызове метода сначала необходимо указать ID контейнера.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {
        Container container = new Container();
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id контейнера, сведения по которому будут изменены: ");
            int id = scanner.nextInt();
            container = session.get(Container.class, (Serializable) id);
            if (container == null) System.out.println("Запись с таким id не существует");
            else {
                System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + container);

                System.out.println("ВВЕДИТЕ НОВОЕ НАЗВАНИЕ: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                container.setContainerName(name);
                session.beginTransaction();
                session.update(container);
                session.getTransaction().commit();
                System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + container);
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
