package ru.geekbrains.graduatework.dao;

import org.hibernate.Session;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;

import javax.persistence.Query;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrganisationDAO extends  AbstractEntityDAO{
    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public OrganisationDAO() {
        super(Organisation.class);
    }

    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id организации,сведения по которой будут изменены: ");
            int id = scanner.nextInt();
            Organisation organisation = session.get(Organisation.class, (Serializable) id);
            System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + organisation);

            System.out.println("Необходимо изменить: \n" +
                    " 1 - organisationName \n" +
                    " 2 - organisationAddress \n" +
                    " 3 - organisationPhone \n" +
                    " 4 - organisationType \n");
            int num = scanner.nextInt();
            System.out.println( num);
            switch (num) {
                case 1 -> {
                    System.out.println("Введите новое название: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    organisation.setOrganisationName(name);
                    session.beginTransaction();
                    session.update(organisation);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisation);
                }
                case 2 -> {
                    System.out.println("Введите новый адрес: ");
                    scanner.nextLine();
                    String address = scanner.nextLine();
                    organisation.setOrganisationAddress(address);
                    session.beginTransaction();
                    session.update(organisation);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisation);
                }
                case 3 -> {
                    System.out.println("Введите новый телефон: ");
                    scanner.nextLine();
                    String phone = scanner.nextLine();
                    organisation.setOrganisationPhone(phone);
                    session.beginTransaction();
                    session.update(organisation);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisation);
                }
                case 4 -> {
                    System.out.println("Введите тип организации, который следует указать: ");
                    scanner.nextLine();
                    String type = scanner.nextLine();

                    String hql = "FROM OrganisationType where organisationTypeName =: organisationType";
                    Query query = session.createQuery(hql, OrganisationType.class);
                    query.setParameter("organisationType", type);
                    List organisationTypes = query.getResultList();
                    System.out.println(organisationTypes);

                    if (organisationTypes.isEmpty()){
                        OrganisationTypeDAO dao = new OrganisationTypeDAO();
                        int count = dao.getCount();
                        OrganisationType newObject = new OrganisationType(Math.toIntExact(count)+1,type);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        organisation.setOrganisationType(newObject);
                        session.getTransaction().commit();
                    }

                    if (organisationTypes.size()==1){
                        OrganisationType newObject = (OrganisationType) organisationTypes.get(0);
                        session.beginTransaction();
                        organisation.setOrganisationType(newObject);
                        session.getTransaction().commit();
                    }
                    else {
                        OrganisationType newObject = (OrganisationType) organisationTypes.get(0);
                        session.beginTransaction();
                        organisation.setOrganisationType(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + organisation);
                }
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
