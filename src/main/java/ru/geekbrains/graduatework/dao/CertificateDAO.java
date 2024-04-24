package ru.geekbrains.graduatework.dao;
import org.hibernate.Session;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.utils.HibernateConnectionUtil;
import javax.persistence.Query;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс CertificateDAO. Наследуется от абстрактного класса AbstractEntityDAO
 * Имеет поле <b>CONNECTION_UTIL</b> и <b>connectorUtil</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class CertificateDAO extends AbstractEntityDAO<Certificate,String> {

    private static final HibernateConnectionUtil CONNECTION_UTIL = new HibernateConnectionUtil();

    /**
     * Конструктор для создания обекта класса CertificateDAO
     * */
    public CertificateDAO() {
        super(Certificate.class);
    }


    /**
     * Метод изменения сведений о сертификате в базе данных.
     * При вызове метода сначала необходимо указать регистрационный номер сертификата.
     * Затем выбрать поле, в которое будут вноситься изменения и указать новое значение для выбранного поля.
     * */
    @Override
    public void update() {
        try (Session session = CONNECTION_UTIL.getSession(); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите регистрационный номер сертификата, в который необходимо внести изменения: ");
            String regNum = scanner.next();
            Certificate certificate = session.get(Certificate.class, (Serializable) regNum);
            if (certificate == null) System.out.println("Запись с таким id не существует");
            else {
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
                        " 11 - refusalReason");
                int num = scanner.nextInt();
                System.out.println(num);
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
                        certificate.setRegistrationDate(LocalDate.of(year, month, day));
                        session.beginTransaction();
                        session.update(certificate);
                        session.getTransaction().commit();
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                    case 3 -> {
                        System.out.println("Введите название контейнера, на которое необходимо изменить: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
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
                        if (containers.isEmpty()) {
                            ContainerDAO dao = new ContainerDAO();
                            int count = dao.getCount();
                            Container newObject = new Container(Math.toIntExact(count) + 1, name);
                            System.out.println(newObject);
                            session.beginTransaction();
                            dao.save(newObject);
                            certificate.setContainer(newObject);
                            session.getTransaction().commit();
                        }
                        /* размер списка 1, те в таблице контейнеров есть один такой контейнер, то
                         * сразу обновляем на него в выбранном сертификате*/
                        if (!containers.isEmpty()) {
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

                        if (contentTypes.isEmpty()) {
                            ContentTypeDAO  dao = new ContentTypeDAO();
                            int count = dao.getCount();
                            ContentType newObject = new ContentType(Math.toIntExact(count)+1,name);
                            System.out.println(newObject);
                            session.beginTransaction();
                            dao.save((jdk.jfr.ContentType) newObject);
                            certificate.setContentType(newObject);
                            session.getTransaction().commit();
                        }

                        if (!contentTypes.isEmpty()) {
                            ContentType newObject = (ContentType) contentTypes.get(0);
                            session.beginTransaction();
                            certificate.setContentType(newObject);
                            session.getTransaction().commit();
                        }
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                    case 5 -> {
                        System.out.println("Введите новое описание ОГ: ");
                        scanner.nextLine();
                        String description = scanner.nextLine();
                        certificate.setContentDescription(description);
                        session.beginTransaction();
                        session.update(certificate);
                        session.getTransaction().commit();
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                    case 6 -> {
                        System.out.println("Введите новый статус: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        String hql = "FROM ReviewStatus where reviewStatus =: reviewStatus";
                        Query query = session.createQuery(hql, ReviewStatus.class);
                        query.setParameter("reviewStatus", name);
                        List reviewStatuses = query.getResultList();

                        if (reviewStatuses.isEmpty()) {
                            ReviewStatusDAO dao = new ReviewStatusDAO();
                            int count = dao.getCount();
                            ReviewStatus newObject = new ReviewStatus(Math.toIntExact(count) + 1, name);
                            System.out.println(newObject);
                            session.beginTransaction();
                            dao.save(newObject);
                            certificate.setReviewStatus(newObject);
                            session.getTransaction().commit();
                        }

                        if (!reviewStatuses.isEmpty()) {
                            ReviewStatus newObject = (ReviewStatus) reviewStatuses.get(0);
                            session.beginTransaction();
                            certificate.setReviewStatus(newObject);
                            session.getTransaction().commit();
                        }
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                    case 7 -> {
                        System.out.println("Введите новую организацию: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        String hql = "FROM Organisation where organisationName =: organisationName";
                        Query query = session.createQuery(hql, Organisation.class);
                        query.setParameter("organisationName", name);
                        List organisations = query.getResultList();


                        if (organisations.isEmpty()) {
                            OrganisationDAO dao = new OrganisationDAO();
                            int count = dao.getCount();
                            Organisation newObject = new Organisation(Math.toIntExact(count) + 1, name);
                            System.out.println(newObject);
                            session.beginTransaction();
                            dao.save(newObject);
                            certificate.setOrganisation(newObject);
                            session.getTransaction().commit();
                        }

                        if (!organisations.isEmpty()) {
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
                        certificate.setIssueDate(LocalDate.of(year, month, day));
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
                        certificate.setEndDate(LocalDate.of(year, month, day));
                        session.beginTransaction();
                        session.update(certificate);
                        session.getTransaction().commit();
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                    case 11 -> {
                        System.out.println("Введите новую причину отказа: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        String hql = "FROM RefusalReason where refusalReason =: refusalReason";
                        Query query = session.createQuery(hql, RefusalReason.class);
                        query.setParameter("refusalReason", name);
                        List refusalReasons = query.getResultList();


                        if (refusalReasons.isEmpty()) {
                            RefusalReasonDAO dao = new RefusalReasonDAO();
                            int count = dao.getCount();
                            RefusalReason newObject = new RefusalReason(Math.toIntExact(count) + 1, name);
                            System.out.println(newObject);
                            session.beginTransaction();
                            dao.save(newObject);
                            certificate.setRefusalReason(newObject);
                            session.getTransaction().commit();
                        }

                        if (!refusalReasons.isEmpty()) {
                            RefusalReason newObject = (RefusalReason) refusalReasons.get(0);
                            session.beginTransaction();
                            certificate.setRefusalReason(newObject);
                            session.getTransaction().commit();
                        }
                        System.out.println("ИЗМЕНЕНИЯ УСПЕШНО ВНЕСЕНЫ \n" + certificate);
                    }
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
    * Метод для получения списока сертификатов, действующих на данный момент
    * @return список сертификатов List<Certificate>
    * */
    public List<Certificate> getActivCertificate(){
        try (Session session = CONNECTION_UTIL.getSession()) {
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
     * Метод получения количества сертификатов, действующих на данный момент
     * @return количество действующих сертификатов
     * */
    public int getCountOfActivCertificate(){
        CertificateDAO certificateDAO = new CertificateDAO();
        int count = certificateDAO.getActivCertificate().size();
        System.out.println(count);
        return count;
    }

    /**
     * Метод получения списока сертификатов, выданных за указанный период
     * @return список сертификатов, выданных за определенный мемент
     * */
    public List<Certificate> getIssueCertificatesForPeriod(LocalDate startDate, LocalDate endDate){

        try (Session session = CONNECTION_UTIL.getSession()) {
            String hgl = "FROM Certificate WHERE issueDate BETWEEN :startDate and :endDate";
            Query query = session.createQuery(hgl, Certificate.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            List certs  = query.getResultList();
            if (certs.isEmpty()) System.out.println("За указанный период сертификаты не выдавались");
//            else certs.forEach(System.out::println);
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод получения количество сертификатов, выданных за определенный период
     * @return количество сертификатов, выданных за определенный период
     * */
    public int getCountOfIssueCertificatesForPeriod(LocalDate start, LocalDate end){
        CertificateDAO certificateDAO = new CertificateDAO();
        int count = certificateDAO.getIssueCertificatesForPeriod(start,end).size();
        System.out.println(count);
        return count;
    }

    /**
     * Метод получения списока сертификатов на определенный контейнер
     * @return список сертификатов на определенный контейнер
     * */
    public List<Certificate> getCertificatesForSpecificContainer(){
        List<Certificate> certs = new ArrayList<>();
        try (Session session = CONNECTION_UTIL.getSession(); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите название контейнера: ");
            String name = scanner.next();
            String hqlContainer = "FROM Container where containerName =: containerName";
            List containers = session.createQuery(hqlContainer, Container.class).setParameter("containerName", name).getResultList();
            if (containers.isEmpty()) System.out.println("Сертификаты на данный контейнер не выдавались.");
            if (containers.size() == 1) {
                Container container = (Container) containers.get(0);
                String hqlCertif = "FROM Certificate WHERE containerID =: containerID";
                certs = session.createQuery(hqlCertif, Certificate.class).setParameter("containerID", container.getContainerID()).getResultList();
                return certs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certs;
    }

    /**
     * Метод получения количество сертификатов на определенный контейнер
     * @return количество сертификатов на определенный контейнер
     * */
    public int getCountOfCertificatesForSpecificContainer() {
        CertificateDAO certificateDAO = new CertificateDAO();
        List<Certificate> certs = certificateDAO.getCertificatesForSpecificContainer();
        int count;
        if (certs.isEmpty()) {
            count = 0;
        }
        else {
            count = certs.size();
            System.out.println(count);
        }
        return count;
    }

    /**
     * Метод получения списока сертификатов, по заявлениям определенной организации
     * @return список сертификатов, по заявлениям определенной организации
     * */
    public List<Certificate> getCertificatesForSpecificOrganisation(){
        List<Certificate> certs = new ArrayList<>();
        try (Session session = CONNECTION_UTIL.getSession(); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите организацию: ");
            String name = scanner.nextLine();
            String hqlContainer = "FROM Organisation where organisationName =: organisationName";
            List organisations = session.createQuery(hqlContainer, Organisation.class).setParameter("organisationName", name).getResultList();
            if (organisations.isEmpty()) System.out.println("Сертификаты данной организации не выдавались.");
            if (organisations.size() == 1) {
                Organisation organisation = (Organisation) organisations.get(0);
                String hqlCertif = "FROM Certificate WHERE organisationID =: organisationID";
                certs = session.createQuery(hqlCertif, Certificate.class).setParameter("organisationID", organisation.getOrganisationID()).getResultList();
                return certs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certs;
    }

    /**
     * Метод получения количество сертификатов, по заявлениям определенной организации
     * @return количество сертификатов, по заявлениям определенной организации
     * */
    public int getCountOfCertificatesForSpecificOrganisation() {
        CertificateDAO certificateDAO = new CertificateDAO();
        List organisations = certificateDAO.getCertificatesForSpecificOrganisation();
        int count;
        if (organisations.isEmpty()) {
            count = 0;
        }
        else {
            count = organisations.size();
        }
        System.out.println(count);
        return count;
    }

    /**
     * Метод получения списока сертификатов, по которым было отказано в выдаче
     *
     * @return список сертификатов, по которым было отказано в выдаче
     */
    public List getAllRefusal(){
        List certs = new ArrayList<>();
        try (Session session = CONNECTION_UTIL.getSession()) {
            String hgl = "FROM Certificate WHERE reviewStatusID = 8 ";
            Query query = session.createQuery(hgl, Certificate.class);
            certs = query.getResultList();
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certs;
    }

    /**
     * Метод получения количество сертификатов, по которым было отказано в выдаче
     * @return количество сертификатов, по которым было отказано в выдаче
     * */

    public int getCountOfAllRefusal(){
        CertificateDAO certificateDAO = new CertificateDAO();
        List organisations = certificateDAO.getAllRefusal();
        int count;
        if (organisations.isEmpty()) {
            count = 0;
        }
        else {
            count = organisations.size();
        }
        System.out.println(count);
        return count;
    }

    /**
     * Метод получения списока сертификатов, по которым было отказано в выдаче за определенный период
     * @return список сертификатов, по которым было отказано в выдаче за определенный период
     * */
    public List<Certificate> getRefusalForPeriod(LocalDate start, LocalDate end){
        List certs = new ArrayList<>();
        try (Session session = CONNECTION_UTIL.getSession()) {
            String hgl1 = "FROM Certificate WHERE registrationDate BETWEEN :startDate and :endDate AND reviewStatusID = 8";
            Query query = session.createQuery(hgl1, Certificate.class);
//            String hgl2 = "issueDate BETWEEN :startDate and :endDate";
            query.setParameter("startDate", start);
            query.setParameter("endDate", end);
            certs = query.getResultList();
            return certs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  certs;
    }

    /**
     * Метод получения количество сертификатов, по которым было отказано в выдаче за определенный период
     * @return количество сертификатов, по которым было отказано в выдаче за определенный период
     * */
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

    /**
     * Метод контроля регламентных сроков на согласование и утверждение сертификатов.
     * Проверяется соблюдение сроков по согласованию, направлению в ФОИВы и утверждение
     * */
    public void deadlinesMonitoring(){
        try (Session session = CONNECTION_UTIL.getSession()) {
            String hgl1 = "FROM Certificate WHERE reviewStatusID = 1";
            Query query1 = session.createQuery(hgl1, Certificate.class);
            List<Certificate> certificatesOnRegistration = query1.getResultList();
            System.out.println("Регистрация сертификатов: ");
            for (Certificate cert: certificatesOnRegistration) {
                long days = LocalDate.now().toEpochDay() - cert.getRegistrationDate().toEpochDay();
                if (days < 3) System.out.println(cert.getRegistrationNumber() + " " + (3 - days) + " дней до передачи в подразделение");
                if (days == 3) System.out.println(cert.getRegistrationNumber() + " " + "сертификат должен быть в подразделении сегодня. Измените статус рассмотрения на 2!");
                if (days > 3) System.out.println(cert.getRegistrationNumber() + " время на регистрации превышено на" + " " + (days - 3) + " " + "дня");
            }
            System.out.println();

            String hgl2 = "FROM Certificate WHERE reviewStatusID = 2";
            Query query2 = session.createQuery(hgl2, Certificate.class);
            List<Certificate> certificatesInDepartment = query2.getResultList();
            System.out.println("Рассмотрение в подразделении: ");
            for (Certificate cert: certificatesInDepartment) {
                long days = LocalDate.now().toEpochDay() - cert.getRegistrationDate().toEpochDay();
                if (days < 18) System.out.println(cert.getRegistrationNumber() + " " + (18 - days) + " дней на согласование в подразделении и отправки на согласование в ФОИВы");
                if (days == 18) System.out.println(cert.getRegistrationNumber() + " " + "сертификат должен быть направлен на согласование в ФОИВы или возвращен заявителю. Следует изменить статус рассмотрения!");
                if (days > 18) System.out.println(cert.getRegistrationNumber() + " время на рассмотрении в подразделении превышено на" + " " + (days - 18) + " " + "дня");
            }
            System.out.println();

            String hgl3 = "FROM Certificate WHERE reviewStatusID = 3";
            Query query3 = session.createQuery(hgl3, Certificate.class);
            List<Certificate> certificatesOnFOIV = query3.getResultList();
            System.out.println("Согласование в ФОИВах: ");
            for (Certificate cert: certificatesOnFOIV) {
                long days = LocalDate.now().toEpochDay() - cert.getRegistrationDate().toEpochDay();
                if (days < 48) System.out.println(cert.getRegistrationNumber() + " " + (48 - days) + " дней на согласование в ФОИВах");
                if (days == 48) System.out.println(cert.getRegistrationNumber() + " " + "сертификат должен быть возвращен из ФОИВов и направлен на утверждение или заявителю без согласования");
                if (days > 48) System.out.println(cert.getRegistrationNumber() + " время на согласование в ФОИВах превышено на" + " " + (days - 48) + " " + "дня");
            }
            System.out.println();

            String hgl4 = "FROM Certificate WHERE reviewStatusID = 4";
            Query query4 = session.createQuery(hgl4, Certificate.class);
            List<Certificate> certificatesOnApproval = query4.getResultList();
            System.out.println("Утверждение: ");
            for (Certificate cert: certificatesOnApproval) {
                long days = LocalDate.now().toEpochDay() - cert.getRegistrationDate().toEpochDay();
                if (days < 51) System.out.println(cert.getRegistrationNumber() + " " + (51 - days) + " дней на утверждение");
                if (days == 51) System.out.println(cert.getRegistrationNumber() + " " + "сертификат должен быть утвержден и направлен заявителю");
                if (days > 51) System.out.println(cert.getRegistrationNumber() + " время на утверждение превышено на" + " " + (days - 51) + " " + "дня");
            }
            System.out.println();


            String hgl5 = "FROM Certificate WHERE reviewStatusID = 5";
            Query query5 = session.createQuery(hgl4, Certificate.class);
            List<Certificate> certificatesForcopy = query4.getResultList();
            System.out.println("Подготовка копий: ");
            for (Certificate cert: certificatesForcopy) {
                long days = LocalDate.now().toEpochDay() - cert.getRegistrationDate().toEpochDay();
                if (days < 54) System.out.println(cert.getRegistrationNumber() + " " + (54 - days) + " дней на подготовку копий");
                if (days == 54) System.out.println(cert.getRegistrationNumber() + " " + "копии должны быть готовы и направлены заявителю");
                if (days > 54)System.out.println(cert.getRegistrationNumber() + " время на подготовку копий превышено на" + " " + (days - 54) + " " + "дня");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}