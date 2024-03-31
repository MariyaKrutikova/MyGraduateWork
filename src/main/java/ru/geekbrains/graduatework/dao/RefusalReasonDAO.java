package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.Container;
import ru.geekbrains.graduatework.models.RefusalReason;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import java.io.Serializable;
import java.util.Scanner;

public class RefusalReasonDAO extends AbstractEntityDAO{
    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public RefusalReasonDAO() {
        super(RefusalReason.class);
    }

    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id причины отказа, сведения по которой будут изменены: ");
            int id = scanner.nextInt();
            RefusalReason refusalReason = session.get(RefusalReason.class, (Serializable) id);
            System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + refusalReason);

            System.out.println("ВВЕДИТЕ НОВУЮ ПРИЧИНУ: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            refusalReason.setRefusalReason(name);
            session.beginTransaction();
            session.update(refusalReason);
            session.getTransaction().commit();
            System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + refusalReason);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
