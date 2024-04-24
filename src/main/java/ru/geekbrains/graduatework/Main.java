package ru.geekbrains.graduatework;

import ru.geekbrains.graduatework.dao.*;
import ru.geekbrains.graduatework.models.*;
import ru.geekbrains.graduatework.services.*;
import ru.geekbrains.graduatework.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

// Для запуска необходимо раскомментировать нужны метод

//       _____________________СЕРТИФИКАТЫ___________________

        CertificateService sertService = new CertificateService();
        List<Certificate> certificates = new ArrayList<>();

//        sertService.getById("1.2024");
//        sertService.getAll();

//        sertService.getCount();

//        Certificate certificate = new Certificate("15.2024", "89/03-2024", LocalDate.of(2024, 4, 5), new Container(10,"Package30"), new ContentType(4,"ОГ4"),"шлаки производства", new ReviewStatus(2, "На рассмотрении в подразделении"), new Organisation(10, "ООО Перевозка"), "5327-ЭЗ");
//        sertService.save(certificate);

//        sertService.update();

//        sertService.deleteByID("17.2024");

//        certificates = sertService.getActivCertificate();
//        certificates.forEach(System.out::println);

//        sertService.getCountOfActivCertificate();

//        certificates = sertService.getIssueCertificatesForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
//        certificates.forEach(System.out::println);

//        sertService.getCountOfIssueCertificatesForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));

//        certificates = sertService.getCertificatesForSpecificContainer();
//        certificates.forEach(System.out::println);

//        sertService.getCountOfCertificatesForSpecificContainer();

//        certificates = sertService.getCertificatesForSpecificOrganisation();
//        certificates.forEach(System.out::println);

//        sertService.getCountCertificatesForSpecificOrganisation();

//        certificates = sertService.getAllRefusal();
//        certificates.forEach(System.out::println);
//
//        sertService.getCountOfAllRefusal();
//
//        certificates = sertService.getRefusalForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));
//        certificates.forEach(System.out::println);

//        sertService.getCountOfRefusalForPeriod(LocalDate.of(2022, 12,31), LocalDate.of(2024, 01,01));

//        sertService.deadlinesMonitoring();



//______________________________КОНТЕЙНЕРЫ___________________

        ContainerService contService = new ContainerService();
        Container container = new Container(11, "УКТОГ-21");

//        contService.getById(7);
//        contService.getAll();
//        contService.getCount();
//        contService.save(container);
//        contService.deleteByID(11);
//        contService.update();


//_____________________________ТИП СОДЕРЖИМОГО___________________
//
        ContentTypeService contentService = new ContentTypeService();
        ContentType contentType = new ContentType(11,"ОГ11");

        contentService.getById(1);
//        contentService.getAll();
//        contentService.getCount();
//        contentService.save(content);
//        contentService.deleteByID(10);
//        contentService.update();
//

//        ________________________ОРГАНИЗАЦИИ__________________

        OrganisationService orgService = new OrganisationService();
        Organisation organisation = new Organisation(13, "Тру-ту-ту", "Курск", "11110000222", new OrganisationType(1,"expert"));

//        orgService.getById(10);
//        orgService.getAll();
//        orgService.getCount();
//        orgService.save(organisation);
//        orgService.deleteByID(13);
//        orgService.update();

//        ____________________ПРИЧИНЫ ОТКАЗА__________________

        RefusalReasonService refService = new RefusalReasonService();
        RefusalReason reason = new RefusalReason("п.3 АР");

//        refService.getById(6);
//        refService.getAll();
//        refService.getCount();
//        refService.save(reason);
//        refService.deleteByID(13);
//        refService.update();

//        ____________________СТАТУС РАССМОТРЕНИЯ__________________

        ReviewStatusService revService = new ReviewStatusService();
        ReviewStatus status = new ReviewStatus(9,"Потеряно");

//        revService.getById(7);
//        revService.getAll();
//        revService.getCount();
//        revService.save(status);
//        revService.deleteByID(9);
//        revService.update();

//        ____________________ТИП ОРГАНИЗАЦИИ__________________

        OrganisationTypeService orgTypeService = new OrganisationTypeService();
        OrganisationType organisationType = new OrganisationType(3, "уполномоченный представитель");

//        orgTypeService.getById(5);
//        orgTypeService.getAll();
//        orgTypeService.getCount();
//        orgTypeService.save(organisationType);
//        orgTypeService.deleteByID(3);
//        orgTypeService.update();
    }
}

