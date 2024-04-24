package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.Container;
import ru.geekbrains.graduatework.models.RefusalReason;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Класс RefusalReasonDAO. Наследуется от абстрактного класса AbstractEntityDAO. Доступ к данным сущности причина отказа.
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class RefusalReasonDAO extends AbstractEntityDAO<RefusalReason,Integer>{
    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public RefusalReasonDAO() {
        super(RefusalReason.class);
    }

    /**
     * Метод изменения сведений о причине отказа в базе данных.
     * При вызове метода сначала необходимо указать ID причины отказа.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id причины отказа, сведения по которой будут изменены: ");
            int id = scanner.nextInt();
            RefusalReason refusalReason = session.get(RefusalReason.class, (Serializable) id);
            if (refusalReason == null) System.out.println("Запись с таким id не существует");
            else {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
