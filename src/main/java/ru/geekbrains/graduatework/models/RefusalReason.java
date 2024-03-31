package ru.geekbrains.graduatework.models;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "certificatedb.refusalreasons")
public class RefusalReason {

    @Id
    @Column(name = "refusalreasonID", nullable = true)
    private int refusalReasonID;

    @Column(name = "refusalReason", nullable = true)
    private String refusalReason;

    public RefusalReason(int refusalReasonID, String refusalReason) {
        this.refusalReasonID = refusalReasonID;
        this.refusalReason = refusalReason;
    }

    public RefusalReason() {
    }

    @Override
    public String toString() {
        return
                "refusalReasonID = " + refusalReasonID +
                ", refusalReason = " + refusalReason ;
    }
}
