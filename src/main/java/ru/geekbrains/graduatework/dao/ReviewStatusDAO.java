package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.Certificate;
import ru.geekbrains.graduatework.models.RefusalReason;
import ru.geekbrains.graduatework.models.ReviewStatus;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Класс ReviewStatusDAO. Наследуется от абстрактного класса AbstractEntityDAO. Доступ к данным сущности статус пересмотра.
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class ReviewStatusDAO extends  AbstractEntityDAO<ReviewStatus, Integer> {
    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public ReviewStatusDAO() {
        super(ReviewStatus.class);
    }

    /**
     * Метод изменения сведений о статусе пересмотра в базе данных.
     * При вызове метода сначала необходимо указать ID статуса пересмотра.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id статуса, сведения по которому будут изменены: ");
            int id = scanner.nextInt();
            ReviewStatus reviewStatus = session.get(ReviewStatus.class, (Serializable) id);
            if (reviewStatus == null) System.out.println("Запись с таким id не существует");
            else {
                System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + reviewStatus);

                System.out.println("ВВЕДИТЕ НОВЫЙ СТАТУС: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                reviewStatus.setReviewStatus(name);
                session.beginTransaction();
                session.update(reviewStatus);
                session.getTransaction().commit();
                System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + reviewStatus);
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
