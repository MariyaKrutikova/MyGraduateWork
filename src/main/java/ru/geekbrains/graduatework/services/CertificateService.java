package ru.geekbrains.graduatework.services;

import ru.geekbrains.graduatework.dao.CertificateDAO;
import ru.geekbrains.graduatework.models.Certificate;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс CertificateService.
 * Имеет поле <b>CONNECTION_UTILCERTIFICATE_DAO</b>
 * @author Maria Krutikova
 * @version 1
 * */
public class CertificateService {
    /**
     * Поле сертификат ДАО
     * */
    private final CertificateDAO CERTIFICATE_DAO = new CertificateDAO();

    /**
     * Конструктор по умолчанию
     * */
    public CertificateService() {
    }

    /**
     * Метод получения сертификата по ID
     * @param id объекта типа String
     * @return сертификат
     * */
    public Certificate getById(String id){
        return CERTIFICATE_DAO.getById(id);
    }

    /**
     * Метод получения всех сертификатов
     * @return список всех сертификатов
     * */
    public List<Certificate> getAll(){
        return CERTIFICATE_DAO.getAll();
    }


    /**
     * Метод получения количества всех сертификатов
     * @return количество сертификатов
     * */
    public int getCount() {
        return CERTIFICATE_DAO.getCount();
    }

/**
 * Метод добавления нового сертификата
*/
    public void save(Certificate certificate){
        CERTIFICATE_DAO.save(certificate);
    }
    /**
     * Метод изменения сертификата
     * */
    public void update(){
        CERTIFICATE_DAO.update();
    }

    /**
     * Метод удаления сертификата по id
     * */
    public void deleteByID(String id){
        CERTIFICATE_DAO.deleteByID(id);
    }

    /**
     * Метод для получения списока сертификатов, действующих на данный момент
     * @return список сертификатов List<Certificate>
     * */
    public List<Certificate> getActivCertificate(){
        return CERTIFICATE_DAO.getActivCertificate();
    }

    /**
     * Метод получения количества сертификатов, действующих на данный момент
     * @return количество действующих сертификатов
     * */
    public int getCountOfActivCertificate(){
       return CERTIFICATE_DAO.getCountOfActivCertificate();
    }

    /**
     * Метод получения списока сертификатов, выданных за указанный период
     * @return список сертификатов, выданных за определенный мемент
     * */
    public List<Certificate> getIssueCertificatesForPeriod(LocalDate startDate, LocalDate endDate) {
        return CERTIFICATE_DAO.getIssueCertificatesForPeriod(startDate, endDate);
    }

    /**
     * Метод получения количество сертификатов, выданных за определенный период
     * @return количество сертификатов, выданных за определенный период
     * */
    public int getCountOfIssueCertificatesForPeriod(LocalDate start, LocalDate end){
        return CERTIFICATE_DAO.getCountOfIssueCertificatesForPeriod(start, end);
    }

    /**
     * Метод получения списока сертификатов на определенный контейнер
     * @return список сертификатов на определенный контейнер
     * */
    public List<Certificate> getCertificatesForSpecificContainer(){
        return CERTIFICATE_DAO.getCertificatesForSpecificContainer();
    }

    /**
     * Метод получения количество сертификатов на определенный контейнер
     * @return количество сертификатов на определенный контейнер
     * */
    public int getCountOfCertificatesForSpecificContainer(){
        return CERTIFICATE_DAO.getCountOfCertificatesForSpecificContainer();
    }

    /**
     * Метод получения списока сертификатов, по заявлениям определенной организации
     * @return список сертификатов, по заявлениям определенной организации
     * */
    public List<Certificate> getCertificatesForSpecificOrganisation(){
        return CERTIFICATE_DAO.getCertificatesForSpecificOrganisation();
    }

    /**
     * Метод получения количество сертификатов, по заявлениям определенной организации
     * @return количество сертификатов, по заявлениям определенной организации
     * */
    public int getCountCertificatesForSpecificOrganisation(){
        return CERTIFICATE_DAO.getCountOfCertificatesForSpecificOrganisation();
    }


    /**
     * Метод получения списока сертификатов, по которым было отказано в выдаче
     * @return список сертификатов, по которым было отказано в выдаче
     * */
    public List<Certificate> getAllRefusal(){
        return CERTIFICATE_DAO.getAllRefusal();
    }


    public int getCountOfAllRefusal(){
        return CERTIFICATE_DAO.getCountOfAllRefusal();
    }
    /**
     * Метод получения списока сертификатов, по которым было отказано в выдаче за определенный период
     * @return список сертификатов, по которым было отказано в выдаче за определенный период
     * */
    public List<Certificate> getRefusalForPeriod(LocalDate start, LocalDate end){
        return CERTIFICATE_DAO.getRefusalForPeriod(start,end);
    }

    /**
     * Метод получения количество сертификатов, по которым было отказано в выдаче за определенный период
     * @return количество сертификатов, по которым было отказано в выдаче за определенный период
     * */
    public int getCountOfRefusalForPeriod(LocalDate start, LocalDate end){
        return CERTIFICATE_DAO.getCountOfRefusalForPeriod(start, end);
    }

   public void deadlinesMonitoring(){
       CERTIFICATE_DAO.deadlinesMonitoring();
   }
}
