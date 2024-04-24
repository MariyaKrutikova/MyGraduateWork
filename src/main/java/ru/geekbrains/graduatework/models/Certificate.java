package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс сертификатов со свойствами <b>registrationNumber</b>, <b>referenceNumber</b>, <b>registrationDate</b>,
 * <b>container</b>, <b>contentType</b>, <b>contentDescription</b>, <b>reviewStatus</b>, <b>organisation</b>,
 * <b>expertConclusion</b>, <b>issueDate</b>, <b>endDate</b>, <b>refusalReason</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.certificates")
public class Certificate {

   /**
    * Поле регистрационный номер
    * */
   @Id
   @Column(name = "registrationNumber")
   private String registrationNumber;

   /**
    * Поле исходящий номер
    * */
   @Column(name = "referenceNumber")
   private String referenceNumber;

   /**
    * Поле дата регистрации
    * */
   @Column(name = "registrationDate")
   private LocalDate registrationDate;

   /**
    * Поле контейнер
    * */
   @ManyToOne(targetEntity = Container.class)
   @JoinColumn(name = "containerID")
   private Container container;

   /**
    * Поле тип содержимого
    * */
   @ManyToOne(targetEntity = ContentType.class)
   @JoinColumn(name = "contentTypeID")
   private ContentType contentType;

   /**
    * Поле описание содержимого
    * */
   @Column(name = "contentDescription")
   private String contentDescription;

   /**
    * Поле статус рассмотрения
    * */
   @ManyToOne(targetEntity = ReviewStatus.class)
   @JoinColumn(name = "reviewStatusID")
   private ReviewStatus reviewStatus;

   /**
    * Поле организация
    * */
   @ManyToOne(targetEntity = Organisation.class)
   @JoinColumn(name = "organisationID")
   private Organisation organisation;

   /**
    * Поле экспертное заключение
    * */
   @Column(name = "expertConclusion")
   private String expertConclusion;

   /**
    * Поле дата выдачи
    * */
   @Column(name = "issueDate")
   private LocalDate issueDate;

   /**
    * Поле срок действия
    * */
   @Column(name = "endDate")
   private LocalDate endDate;

   /**
    * Поле причина отказа
    * */
   @ManyToOne(targetEntity = RefusalReason.class)
   @JoinColumn(name = "refusalReasonID")
   private RefusalReason refusalReason;


   /**
    * Конструктор - создания объета с определенными значениями.
    * Следует использовать при внесении в базу данных только что зарегистрированного сертификата.
    * @param registrationNumber - регистрационный номер
    * @param referenceNumber - исходящий номер
    * @param registrationDate - дата регистрации
    * @param container - контейнер
    * @param contentType - тип содержимого
    * @param contentDescription - описание содержимого
    * @param reviewStatus - статус пересмотра
    * @param organisation - организация
    * @param expertConclusion - экспертное заключение
    * @see Certificate#Certificate()
    * */
   public Certificate(String registrationNumber,
                      String referenceNumber,
                      LocalDate registrationDate,
                      Container container,
                      ContentType contentType,
                      String contentDescription,
                      ReviewStatus reviewStatus,
                      Organisation organisation,
                      String expertConclusion) {
      this.registrationNumber = registrationNumber;
      this.referenceNumber = referenceNumber;
      this.registrationDate = registrationDate;
      this.container = container;
      this.contentType = contentType;
      this.contentDescription = contentDescription;
      this.reviewStatus = reviewStatus;
      this.organisation = organisation;
      this.expertConclusion = expertConclusion; }


   /**
    * Конструктор по умолчанию
    * */
   public Certificate() {
   }

   /**
    * Конструктор - создания объета с определенными значениями.
    * Следует использовать при внесении в базу данных уже действующих сертификатов.
    * @param registrationNumber - регистрационный номер
    * @param referenceNumber - исходящий номер
    * @param registrationDate - дата регистрации
    * @param container - контейнер
    * @param contentType - тип содержимого
    * @param contentDescription - описание содержимого
    * @param reviewStatus - статус пересмотра
    * @param organisation - организация
    * @param expertConclusion - экспертное заключение
    * @param issueDate - дата выдачи
    * @param endDate - срок действия
    * @see Certificate#Certificate()
    * */
   public Certificate(String registrationNumber,
                      String referenceNumber,
                      LocalDate registrationDate,
                      Container container,
                      ContentType contentType,
                      String contentDescription,
                      ReviewStatus reviewStatus,
                      Organisation organisation,
                      String expertConclusion,
                      LocalDate issueDate,
                      LocalDate endDate){
      this.registrationNumber = registrationNumber;
      this.referenceNumber = referenceNumber;
      this.registrationDate = registrationDate;
      this.container = container;
      this.contentType = contentType;
      this.contentDescription = contentDescription;
      this.reviewStatus = reviewStatus;
      this.organisation = organisation;
      this.expertConclusion = expertConclusion;
      this.issueDate = issueDate;
      this.endDate = endDate;
   }

   /**
    * Метод получения информации о сертификате
    * @return возвращает запись из базы данных по определенному сертификату
    */
   @Override
   public String toString() {
      return
              "registrationNumber= " + registrationNumber +
              ", referenceNumber= " + referenceNumber +
              ", registrationDate= " + registrationDate +
              ", container= " + container.getContainerName() +
              ", content= " + contentType.getContentType() +
              ", contentDescription=" + contentDescription +
              ", reviewStatus= " + reviewStatus.getReviewStatus() +
              ", organisation=" + organisation.getOrganisationName() +
              ", expertConclusion=" + expertConclusion +
              ", issueDate= " + issueDate +
              ", endDate= " + endDate +
              ", refusalReason= " + refusalReason.getRefusalReason() +
              '}';
   }
}
