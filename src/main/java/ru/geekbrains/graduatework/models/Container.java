package ru.geekbrains.graduatework.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.containers")
public class Container {

    @Id
    private int containerID;

    @Column(name = "containerName")
    private String containerName;

    public Container(int containerID, String containerName) {
        this.containerID = containerID;
        this.containerName = containerName;
    }

    public Container() {
    }

    @Override
    public String toString() {
        return  "containerID= " + containerID +
                ", containerName= " + containerName ;
    }
}
