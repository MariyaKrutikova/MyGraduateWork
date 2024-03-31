package ru.geekbrains.graduatework.dao;
import com.sun.xml.bind.v2.TODO;
import org.hibernate.Session;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;
import javax.persistence.Query;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CertificateDAO extends AbstractEntityDAO {

    private static final HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
    public CertificateDAO() {
        super(Certificate.class);
    }


    @Override
    public void update() {
        try (Session session = connectorUtil.getSession()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите регистрационный номер сертификата, в который необходимо внести изменения: ");
            String regNum = scanner.next();
            Certificate certificate = session.get(Certificate.class, (Serializable) regNum);
            System.out.println("ИЗМЕНЕНИЯ БУДУТ ВНОСИТЬСЯ В:   " + certificate);

            System.out.println("Необходимо изменить: \n" +
                    " 1 - referenceNumber \n" +
                    " 2 - registrationDate \n" +
                    " 3 - container \n" +
                    " 4 - contentType \n" +
                    " 5 - contentDescription \n" +
                    " 6 - reviewStatus \n" +
                    " 7 - organisation \n" +
                    " 8 - expertConclusion \n" +
                    " 9 - issueDate \n" +
                    " 10 - endDate \n" +
                    " 11 - refusalReason" );
            int num = scanner.nextInt();
            System.out.println( num);
            switch (num) {
                case 1 -> {
                    System.out.println("Введите новый исходящий номер: ");
                    String refNum = scanner.next();
                    certificate.setReferenceNumber(refNum);
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 2 -> {
                    System.out.println("Введите год: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите месяц: ");
                    int month = scanner.nextInt();
                    System.out.println("Введите день: ");
                    int day = scanner.nextInt();
                    certificate.setRegistrationDate(LocalDate.of(year,month,day));
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 3 -> {
                    System.out.println("Введите название контейнера, на которое необходимо изменить: ");
                    String name = scanner.next();
                    /*Ищем в таблице контейнеров контейнер с введенным названием.
                    * Результат записываем в список.
                    * Проверяем размер полученного списка.
                    * */
                    String hql = "FROM Container where containerName =: containerName";
                    Query query = session.createQuery(hql, Container.class);
                    query.setParameter("containerName", name);
                    List containers = query.getResultList();

                    /* Если список пуст, то сначала добавляем в таблицу контейеров новый контейнер,
                     * потом обновляем на него в выбранном сертификате*/
                    if (containers.isEmpty()){
                        ContainerDAO dao = new ContainerDAO();
                       int count = dao.getCount();
                        Container newObject = new Container(Math.toIntExact(count)+1,name);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        certificate.setContainer(newObject);
                        session.getTransaction().commit();
                    }
                    /* размер списка 1, те в таблице контейнеров есть один такой контейнер, то
                     * сразу обновляем на него в выбранном сертификате*/
                    if (containers.size()==1){
                        Container newObject = (Container) containers.get(0);
                        session.beginTransaction();
                        certificate.setContainer(newObject);
                        session.getTransaction().commit();
                    }
                    else {
                        Container newObject = (Container) containers.get(0);
                        session.beginTransaction();
                        certificate.setContainer(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 4 -> {
                    System.out.println("Введите тип ОГ, на которое необходимо изменить: ");
                    String name = scanner.next();

                    String hql = "FROM ContentType where contentType =: contentType";
                    Query query = session.createQuery(hql, ContentType.class);
                    query.setParameter("contentType", name);
                    List contentTypes = query.getResultList();

                    if (contentTypes.isEmpty()){
                        ContentTypeDAO  dao = new ContentTypeDAO();
                        int count = dao.getCount();
                        ContentType newObject = new ContentType(Math.toIntExact(count)+1,name);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        certificate.setContentType(newObject);
                        session.getTransaction().commit();
                    }

                    if (contentTypes.size()==1){
                        ContentType newObject = (ContentType) contentTypes.get(0);
                        session.beginTransaction();
                        certificate.setContentType(newObject);
                        session.getTransaction().commit();
                    }

                    else {
                        ContentType newObject = (ContentType) contentTypes.get(0);
                        session.beginTransaction();
                        certificate.setContentType(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 5 -> {
                    System.out.println("Введите новое описание ОГ: ");
                    String description = scanner.next();
                    certificate.setContentDescription(description);
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 6 -> {
                    System.out.println("Введите новый статус: ");
                    String name = scanner.next();

                    String hql = "FROM ReviewStatus where reviewStatus =: reviewStatus";
                    Query query = session.createQuery(hql, ReviewStatus.class);
                    query.setParameter("reviewStatus", name);
                    List reviewStatuses = query.getResultList();

                    if (reviewStatuses.isEmpty()){
                        ReviewStatusDAO  dao = new ReviewStatusDAO();
                        int count = dao.getCount();
                        ReviewStatus newObject = new ReviewStatus(Math.toIntExact(count)+1,name);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        certificate.setReviewStatus(newObject);
                        session.getTransaction().commit();
                    }

                    if (reviewStatuses.size()==1){
                        ReviewStatus newObject = (ReviewStatus) reviewStatuses.get(0);
                        session.beginTransaction();
                        certificate.setReviewStatus(newObject);
                        session.getTransaction().commit();
                    }

                    else {
                        ReviewStatus newObject = (ReviewStatus) reviewStatuses.get(0);
                        session.beginTransaction();
                        certificate.setReviewStatus(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 7 -> {
                    System.out.println("Введите новую организацию: ");
                    String name = scanner.next();

                    String hql = "FROM Organisation where organisationName =: organisationName";
                    Query query = session.createQuery(hql, Organisation.class);
                    query.setParameter("organisationName", name);
                    List organisations = query.getResultList();

                  //TODO Доработать ввод данных оборганизации!!!

                    if (organisations.isEmpty()){
                        OrganisationDAO dao = new OrganisationDAO();
                        int count = dao.getCount();
                        Organisation newObject = new Organisation(Math.toIntExact(count)+1,name);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        certificate.setOrganisation(newObject);
                        session.getTransaction().commit();
                    }

                    if (organisations.size()==1){
                        Organisation newObject = (Organisation) organisations.get(0);
                        session.beginTransaction();
                        certificate.setOrganisation(newObject);
                        session.getTransaction().commit();
                    }

                    else {
                        Organisation newObject = (Organisation) organisations.get(0);
                        session.beginTransaction();
                        certificate.setOrganisation(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }

                case 8 -> {
                    System.out.println("Введите номер нового экспертного заключения: ");
                    String conclusion = scanner.next();
                    certificate.setExpertConclusion(conclusion);
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 9 -> {
                    System.out.println("Введите год: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите месяц: ");
                    int month = scanner.nextInt();
                    System.out.println("Введите день: ");
                    int day = scanner.nextInt();
                    certificate.setIssueDate(LocalDate.of(year,month,day));
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 10 -> {
                    System.out.println("Введите год: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите месяц: ");
                    int month = scanner.nextInt();
                    System.out.println("Введите день: ");
                    int day = scanner.nextInt();
                    certificate.setEndDate(LocalDate.of(year,month,day));
                    session.beginTransaction();
                    session.update(certificate);
                    session.getTransaction().commit();
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
                case 11 -> {
                    System.out.println("Введите новую причину отказа: ");
                    String name = scanner.next();

                    String hql = "FROM RefusalReason where refusalReason =: refusalReason";
                    Query query = session.createQuery(hql, RefusalReason.class);
                    query.setParameter("refusalReason", name);
                    List refusalReasons = query.getResultList();

                    //TODO Доработать ввод данных оборганизации!!!

                    if (refusalReasons.isEmpty()){
                        ReviewStatusDAO dao = new ReviewStatusDAO();
                        int count = dao.getCount();
                        RefusalReason newObject = new RefusalReason(Math.toIntExact(count)+1,name);
                        System.out.println(newObject);
                        session.beginTransaction();
                        dao.save(newObject);
                        certificate.setRefusalReason(newObject);
                        session.getTransaction().commit();
                    }

                    if (refusalReasons.size()==1){
                        RefusalReason newObject = (RefusalReason) refusalReasons.get(0);
                        session.beginTransaction();
                        certificate.setRefusalReason(newObject);
                        session.getTransaction().commit();
                    }

                    else {
                        RefusalReason newObject = (RefusalReason) refusalReasons.get(0);
                        session.beginTransaction();
                        certificate.setRefusalReason(newObject);
                        session.getTransaction().commit();
                    }
                    System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                }
            }
        scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //TODO описать все методы!!!!!
    /**
    * Метод возвращающий список сертификатов, действующих на данный момент
    * @return List<Certificate>
    * */
    public List<Certificate> getActivCertificate(){
        try (Session session = connectorUtil.getSession()) {
            String hgl = "FROM Certificate WHERE endDate > current_date()";
            Query query = session.createQuery(hgl, Certificate.class);
            List certs = query.getResultList();
//            certs.forEach(System.out::println);
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * Метод количество сертификатов, действующих на данный момент
     * @return count of certificate int
     * */
    public int getCountOfActivCertificate(){
        CertificateDAO certificateDAO = new CertificateDAO();
        int count = certificateDAO.getActivCertificate().size();
        System.out.println(count);
        return count;
    }
/**
 * Метод возвращающий список сертификатов, выданных за указанный период
 * */
    public List<Certificate> getIssueCertificatesForPeriod(LocalDate startDate, LocalDate endDate){
        try (Session session = connectorUtil.getSession()) {
            String hgl = "FROM Certificate WHERE issueDate BETWEEN :startDate and :endDate";
            Query query = session.createQuery(hgl, Certificate.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            List certs = query.getResultList();
            certs.forEach(System.out::println);
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * Метод возвращает количество сертификатов, выданных за определенный период
     * @return count of certificate int
     * */
    public int getCountOfIssueCertificatesForPeriod(LocalDate start, LocalDate end){
        CertificateDAO certificateDAO = new CertificateDAO();
        int count = certificateDAO.getIssueCertificatesForPeriod(start,end).size();
        System.out.println(count);
        return  0;
    }

    public List<Certificate> getCertificatesForSpecificContainer(){
        try (Session session = connectorUtil.getSession(); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите название контейнера: ");
            String name = scanner.next();
            String hqlContainer = "FROM Container where containerName =: containerName";
            List containers = session.createQuery(hqlContainer, Container.class).setParameter("containerName", name).getResultList();

            if (containers.isEmpty()) System.out.println("Сертификаты на данный контейнер не выдавались.");
            if (containers.size() == 1) {
                Container container = (Container) containers.get(0);
                String hqlCertif = "FROM Certificate WHERE containerID =: containerID";
                List certs = session.createQuery(hqlCertif, Certificate.class).setParameter("containerID", container.getContainerID()).getResultList();
                certs.forEach(System.out::println);
                return certs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCountOfCertificatesForSpecificContainer() {
        CertificateDAO certificateDAO = new CertificateDAO();
        List containers = certificateDAO.getCertificatesForSpecificContainer();
        int count = 0;
        if (containers.isEmpty()) System.out.println("Сертификаты на данный контейнер не выдавались.");
        else {
            count = containers.size();
            System.out.println(count);
        }
        return count;
    }

    public List<Certificate> getCertificatesForSpecificOrganisation(){
        try (Session session = connectorUtil.getSession(); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите организацию: ");
//            scanner.nextLine();
            String name = scanner.nextLine();
            String hqlContainer = "FROM Organisation where organisationName =: organisationName";
            List organisations = session.createQuery(hqlContainer, Organisation.class).setParameter("organisationName", name).getResultList();

            if (organisations.isEmpty()) System.out.println("Сертификаты данной организации не выдавались.");
            if (organisations.size() == 1) {
                Organisation organisation = (Organisation) organisations.get(0);
                String hqlCertif = "FROM Certificate WHERE organisationID =: organisationID";
                List certs = session.createQuery(hqlCertif, Certificate.class).setParameter("organisationID", organisation.getOrganisationID()).getResultList();
                certs.forEach(System.out::println);
                return certs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCountCertificatesForSpecificOrganisation() {
        CertificateDAO certificateDAO = new CertificateDAO();
        List organisations = certificateDAO.getCertificatesForSpecificOrganisation();
        int count = 0;
        if (organisations.isEmpty()) System.out.println("Сертификаты  данной организации не выдавались.");
        else {
            count = organisations.size();
            System.out.println(count);
        }
        return count;
    }

    public List<Certificate> getAllRefusal(){
        try (Session session = connectorUtil.getSession()) {
            String hgl = "FROM Certificate WHERE reviewStatusID = 8 ";
            Query query = session.createQuery(hgl, Certificate.class);
            List certs = query.getResultList();
            certs.forEach(System.out::println);
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public List<Certificate> getRefusalForPeriod(LocalDate start, LocalDate end){
        try (Session session = connectorUtil.getSession()) {
            String hgl1 = "FROM Certificate WHERE registrationDate BETWEEN :startDate and :endDate AND reviewStatusID = 8";
            Query query = session.createQuery(hgl1, Certificate.class);
//            String hgl2 = "issueDate BETWEEN :startDate and :endDate";
            query.setParameter("startDate", start);
            query.setParameter("endDate", end);
            List certs = query.getResultList();
            certs.forEach(System.out::println);
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public int getCountOfRefusalForPeriod(LocalDate start, LocalDate end){
        CertificateDAO certificateDAO = new CertificateDAO();
        List refusals = certificateDAO.getRefusalForPeriod(start,end);
        int count = 0;
        if (refusals.isEmpty()) System.out.println("Отказов за указанный период не было.");
        else {
            count = refusals.size();
            System.out.println(count);
        }
        return count;
    }

}

