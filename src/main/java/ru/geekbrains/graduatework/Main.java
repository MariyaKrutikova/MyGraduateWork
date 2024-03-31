package ru.geekbrains.graduatework;

import ru.geekbrains.graduatework.dao.*;
import ru.geekbrains.graduatework.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        HibernateConnectionUtil connectorUtil = new HibernateConnectionUtil();
//        try (Session session = connectorUtil.getSession()) {
//            String id = "1.2024";
//            Query query = session.createQuery("FROM Certificate where registrationNumber =:registrationNumber", Certificate.class);
//            query.setParameter("registrationNumber", id);
//            List certificates = query.getResultList();
//            for (Object certificate: certificates) {
//                System.out.println(certificate.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        LocalDate date = LocalDate.of(2014, 3, 19);
        Container container = new Container();
        ContentType contentType = new ContentType();
        ReviewStatus reviewStatus = new ReviewStatus();


        Certificate certificate = new Certificate("10.2024", "61/01-2024", LocalDate.of(2014, 3, 19), new Container(2,"BU77"), new ContentType(2,"ОГ2"), new ReviewStatus(2, "На рассмотрении в подразделении"), new Organisation(7, "ОАО ГСМ"), "ЭЗ-45-1");
        Container container1 = new Container(11, "BU137");
        CertificateDAO certificateDAO = new CertificateDAO();
        ContainerDAO containerDAO = new ContainerDAO();
        ContentTypeDAO contentTypeDAO = new ContentTypeDAO();
        OrganisationDAO  organisationDAO = new OrganisationDAO();
        RefusalReasonDAO refusalReasonDAO = new RefusalReasonDAO();
        ReviewStatusDAO reviewStatusDAO = new ReviewStatusDAO();
        OrganisationTypeDAO organisationTypeDAO = new OrganisationTypeDAO();

        Organisation organisation = new Organisation(13, "Тру-ту-ту", "Курск", "11110000222", new OrganisationType(1,"expert"));
        RefusalReason reason = new RefusalReason(7,"Фигня полная");
//        ReviewStatus status = new ReviewStatus(reviewStatusDAO.getCount()+1, "Поступило на повторное рассмотрение");
        OrganisationType organisationType = new OrganisationType(3,"заявитель");

//       ____________СЕРТИФИКАТЫ___________________
//        certificateDAO.getById("1.2022");
//        certificateDAO.getAll();
//        certificateDAO.getCount();
//        certificateDAO.save(certificate);
//        certificateDAO.deleteByID("10.2024");
//        certificateDAO.update();

//        List<Certificate> certificates;
//        certificates =  certificateDAO.getActivCertificate();
//        certificates.forEach(System.out::println);
//        certificateDAO.getCountOfActivCertificate();

//         List<Certificate> certificates;
//        certificates =  certificateDAO.getIssueCertificatesForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
//            certificateDAO.getCountOfIssueCertificatesForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
//        certificateDAO.getCertificatesForSpecificContainer();
//        certificateDAO.getCountOfCertificatesForSpecificContainer();
//        certificateDAO.getCertificatesForSpecificOrganisation();
//        certificateDAO.getCountCertificatesForSpecificOrganisation();
//        certificateDAO.getRefusalForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
//        certificateDAO.getRefusalForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
        certificateDAO.getCountOfRefusalForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));




//____________________Контейнеры___________________
//        containerDAO.getById(10);
//        containerDAO.getAll();
//        containerDAO.getCount();
//        containerDAO.save(container1);
//        containerDAO.deleteByID(11);
//        containerDAO.update();
//        containerDAO.deleteByID(11);

//____________________Тип содержимого___________________
//        TODO: ВЫБРАСЫВАЕТ ИСКЛЮЧЕНИЕ. РАЗОБРАТЬСЯ !!!!
//        contentTypeDAO.getById(10);
//        contentTypeDAO.getAll();
//        contentTypeDAO.getCount();
//        contentTypeDAO.save(container1);
//        contentTypeDAO.deleteByID(10);
//        contentTypeDAO.update();
//        contentTypeDAO.deleteByID(11);

//        ____________________Организации__________________
//        organisationDAO.getById(10);
//        organisationDAO.getAll();
//        organisationDAO.getCount();
//        organisationDAO.save(organisation);
//        organisationDAO.deleteByID(13);
//        organisationDAO.update();

//        ____________________Причина отказа__________________
//        refusalReasonDAO.getById(8);
//        refusalReasonDAO.getAll();
//        refusalReasonDAO.getCount();
//        refusalReasonDAO.save(reason);
//        refusalReasonDAO.deleteByID(7);
//        refusalReasonDAO.update();

//        ____________________Статус рассмотрения__________________
//        reviewStatusDAO.getById(8);
//        reviewStatusDAO.getAll();
//        reviewStatusDAO.getCount();
//        reviewStatusDAO.save(status);
//        reviewStatusDAO.deleteByID(9);
//        reviewStatusDAO.update();

//        ____________________Тип организации__________________
//        organisationTypeDAO.getById(4);
//        organisationTypeDAO.getAll();
//        organisationTypeDAO.getCount();
//        organisationTypeDAO.save(organisationType);
//        organisationTypeDAO.deleteByID(4);
//        organisationTypeDAO.update();
    }
}

