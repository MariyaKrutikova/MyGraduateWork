package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.certificates")
public class Certificate {

   @Id
   @Column(name = "registrationNumber")
   private String registrationNumber;

   @Column(name = "referenceNumber")
   private String referenceNumber;

   @Column(name = "registrationDate")
   private LocalDate registrationDate;

   @ManyToOne(targetEntity = Container.class)
   @JoinColumn(name = "containerID")
   private Container container;

   @ManyToOne(targetEntity = ContentType.class)
   @JoinColumn(name = "contentTypeID")
   private ContentType contentType;

   @Column(name = "contentDescription")
   private String contentDescription;

   @ManyToOne(targetEntity = ReviewStatus.class)
   @JoinColumn(name = "reviewStatusID")
   private ReviewStatus reviewStatus;

   @ManyToOne(targetEntity = Organisation.class)
   @JoinColumn(name = "organisationID")
   private Organisation organisation;

   @Column(name = "expertConclusion")
   private String expertConclusion;

   @Column(name = "issueDate")
   private LocalDate issueDate;

   @Column(name = "endDate")
   private LocalDate endDate;

   @ManyToOne(targetEntity = RefusalReason.class)
   @JoinColumn(name = "refusalReasonID")
   private RefusalReason refusalReason;


   /*Конструктор с основными полями. Для только поступившего сертификата*/
   public Certificate(String registrationNumber,
                      String referenceNumber,
                      LocalDate registrationDate,
                      Container container,
                      ContentType contentType,
                      ReviewStatus reviewStatus,
                      Organisation organisation,
                      String expertConclusion) {
      this.registrationNumber = registrationNumber;
      this.referenceNumber = referenceNumber;
      this.registrationDate = registrationDate;
      this.container = container;
      this.contentType = contentType;
      this.reviewStatus = reviewStatus;
      this.organisation = organisation;
      this.expertConclusion = expertConclusion; }


   /*Конструктор по умолчанию*/
   public Certificate() {
   }

   /*Конструктор для уже выданного сертификата*/
   public Certificate(String registrationNumber,
                      String referenceNumber,
                      LocalDate registrationDate,
                      Container container,
                      ContentType contentType,
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
      this.reviewStatus = reviewStatus;
      this.organisation = organisation;
      this.expertConclusion = expertConclusion;
      this.issueDate = issueDate;
      this.endDate = endDate;
   }

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
