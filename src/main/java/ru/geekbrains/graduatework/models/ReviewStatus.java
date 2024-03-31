package ru.geekbrains.graduatework.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.reviewstatus")
public class ReviewStatus {

    @Id
    @Column(name = "reviewStatusID")
    private int reviewStatusID;

    @Column(name = "reviewStatus")
    private String reviewStatus;

    public ReviewStatus(int statusID, String statusName) {
        this.reviewStatusID = statusID;
        this.reviewStatus = statusName;
    }

    public ReviewStatus() {
    }

   @Override
    public String toString() {
        return
                "statusID = " + reviewStatusID +
                ", statusName = " + reviewStatus ;
    }
}
