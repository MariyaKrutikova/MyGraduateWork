package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.OrganisationType;
import ru.geekbrains.graduatework.models.RefusalReason;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Класс OrganisationTypeDAO. Наследуется от абстрактного класса AbstractEntityDAO. Доступ к данным сущности тип организации.
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class OrganisationTypeDAO extends AbstractEntityDAO<OrganisationType, Integer>{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public OrganisationTypeDAO() {
        super(OrganisationType.class);
    }

    /**
     * Метод изменения сведений о типе организации в базе данных.
     * При вызове метода сначала необходимо указать ID типа организации.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {
        OrganisationType organisationType = new OrganisationType();
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id тип организации, в который будут вноситься изменения: ");
            int id = scanner.nextInt();
            organisationType = session.get(OrganisationType.class, (Serializable) id);
            if (organisationType == null) System.out.println("Запись с таким id не существует");
            else {
                System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + organisationType);

                System.out.println("ВВЕДИТЕ НОВОЕ НАЗВАНИЕ: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                organisationType.setOrganisationTypeName(name);
                session.beginTransaction();
                session.update(organisationType);
                session.getTransaction().commit();
                System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisationType);
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
