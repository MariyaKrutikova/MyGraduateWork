package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс статуса рассмотрения со свойствами <b>reviewStatusID</b> и <b>reviewStatus</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.reviewstatus")
public class ReviewStatus {
    /**
     * Поле ID статуса рассмотрения
     * */
    @Id
    @Column(name = "reviewStatusID")
    private int reviewStatusID;

    /**
     * Поле статуса рассмотрения
     * */
    @Column(name = "reviewStatus")
    private String reviewStatus;

    /**
     * Конструктор по умолчанию
     * */
    public ReviewStatus() {
    }
    /**
     * Метод получения информации о статусе рассмотрения
     * @return возвращает запись из базы данных об определенном статусе рассмотрения
     */
   @Override
    public String toString() {
        return
                "statusID = " + reviewStatusID +
                ", statusName = " + reviewStatus ;
    }
}
