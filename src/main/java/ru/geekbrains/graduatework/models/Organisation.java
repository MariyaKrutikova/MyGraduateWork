package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс организаций со свойствами <b>organisationID</b>, <b>organisationName</b>, <b>organisationAddress</b>,<b>organisationPhone</b> и <b>organisationType</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.organisations")
public class Organisation {

    /**
     * Поле ID организации
     * */
    @Id
    @Column(name = "organisationID")
    private int organisationID;

    /**
     * Поле название организации
     * */
    @Column(name = "organisationName")
    private String organisationName;

    /**
     * Поле адрес организации
     * */
    @Column(name = "organisationAddress")
    private String organisationAddress;

    /**
     * Поле тип организации
     * */
    @Column(name = "organisationPhone")
    private String organisationPhone;

    /**
     * Поле ID содержимого
     * */
    @ManyToOne(targetEntity = OrganisationType.class)
    @JoinColumn(name = "organisationTypeID")
    private OrganisationType organisationType;

    /**
     * Конструктор - создания объета с определенными значениями.
     * Следует использовать при внесении в базу данных только что зарегистрированного сертификата.
     * @param organisationID - ID организации
     * @param organizationName - название организации
     * @see Organisation#Organisation()
     * */
    public Organisation(int organisationID,String organizationName) {
        this.organisationID = organisationID;
        this.organisationName = organizationName;
    }
    /**
     * Конструктор по умолчанию
     * */
    public Organisation() {
    }
    /**
     * Метод получения информации об организации
     * @return возвращает запись из базы данных об определенной организации
     * */
    @Override
    public String toString() {
        return "organisationID = " + organisationID +
                ", organisationName = " + organisationName +
                ", organisationAddress = " + organisationAddress +
                ", organisationPhone = " + organisationPhone +
                ", organisationType = " + organisationType.getOrganisationTypeName();
    }
}
