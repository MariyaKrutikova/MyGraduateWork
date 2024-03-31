package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.OrganisationType;
import ru.geekbrains.graduatework.models.RefusalReason;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import java.io.Serializable;
import java.util.Scanner;

public class OrganisationTypeDAO extends AbstractEntityDAO{

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public OrganisationTypeDAO() {
        super(OrganisationType.class);
    }

    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id тип организации, в который будут вноситься изменения: ");
            int id = scanner.nextInt();
            OrganisationType organisationType = session.get(OrganisationType.class, (Serializable) id);
            System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + organisationType);

            System.out.println("ВВЕДИТЕ НОВОЕ НАЗВАНИЕ: ");
            String name = scanner.next();
            organisationType.setOrganisationTypeName(name);
            session.beginTransaction();
            session.update(organisationType);
            session.getTransaction().commit();
            System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisationType);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
