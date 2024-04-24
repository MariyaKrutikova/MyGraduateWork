package ru.geekbrains.graduatework.models;
import javax.persistence.*;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс типа организации со свойствами <b>organisationTypeID</b> и <b>organisationTypeName</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.organisationtype")
public class OrganisationType {

    /**
     * Поле ID типа организации
     * */
    @Id
    @Column(name = "organisationTypeID")
    int organisationTypeID;

    /**
     * Поле название типа организации
     * */
    @Column(name = "organisationTypeName")
    String organisationTypeName;

    /**
     * Конструктор по умолчанию
     * */
    public OrganisationType() {
    }

    /**
     * Метод получения информации о типе организации
     * @return возвращает запись из базы данных об определенном типе организации
     */
    @Override
    public String toString() {
        return
                "organisationTypeID = " + organisationTypeID +
                ", organisationTypeName = " + organisationTypeName;
    }
}
