package ru.geekbrains.graduatework.models;

import javax.persistence.*;
//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.contenttype")
public class ContentType {

    @Id
    @Column(name = "contentTypeID")
    private int contentTypeID;

    @Column(name = "contentType")
    private String contentType;


    public ContentType(int contentID, String contentType) {
        this.contentTypeID = contentID;
        this.contentType = contentType;
    }

    public ContentType() {
    }


    @Override
    public String toString() {
        return
                "contentID=" + contentTypeID +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
