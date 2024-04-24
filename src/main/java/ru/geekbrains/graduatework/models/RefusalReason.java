package ru.geekbrains.graduatework.models;
import javax.persistence.*;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс причин отказа со свойствами <b>refusalReasonID</b> и <b>refusalReason</b>
 * @author Maria Krutikova
 * @version 1
 * */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "certificatedb.refusalreasons")
public class RefusalReason {

    /**
     * Поле ID причины отказа
     * */
    @Id
    @Column(name = "refusalreasonID", nullable = true)
    private int refusalReasonID;

    /**
     * Поле причина отказа
     * */
    @Column(name = "refusalReason", nullable = true)
    private String refusalReason;
    /**
     * Конструктор по умолчанию
     * */
    public RefusalReason() {
    }

    public RefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    /**
     * Метод получения информации о причине отказе
     * @return возвращает запись из базы данных по конкретной причине отказе
     */
    @Override
    public String toString() {
        return
                "refusalReasonID = " + refusalReasonID +
                ", refusalReason = " + refusalReason ;
    }
}
