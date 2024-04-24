package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс типа содержимого со свойствами <b>contentTypeID</b> и <b>contentType</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.contenttype")
public class ContentType {

    /**
     * Поле ID содержимого
     * */
    @Id
    @Column(name = "contentTypeID")
    private int contentTypeID;

    /**
     * Поле тип содержимого
     * */
    @Column(name = "contentType")
    private String contentType;

    /**
     * Конструктор по умолчанию
     * */
    public ContentType() {
    }

    /**
     * Метод получения информации о типе содержимого
     * @return возвращает запись из базы данных об определенном содержимом
     */
    @Override
    public String toString() {
        return
                "contentID=" + contentTypeID +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
