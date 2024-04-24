package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс контейнеров со свойствами <b>containerID</b> и <b>containerName</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.containers")
public class Container {

    /**
     * Поле ID контейнера
     * */
    @Id
    private int containerID;

    /**
     * Поле название контейнера
     * */
    @Column(name = "containerName")
    private String containerName;

    /**
     * Конструктор по умолчанию
     * */
    public Container() {
    }
    /**
     * Метод получения информации о контейнере
     * @return возвращает запись из базы данных об определенном контейнере
     */
    @Override
    public String toString() {
        return  "containerID= " + containerID +
                ", containerName= " + containerName ;
    }
}
