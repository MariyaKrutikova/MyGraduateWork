package ru.geekbrains.graduatework.models;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.organisationtype")
public class OrganisationType {

    @Id
    @Column(name = "organisationTypeID")
    int organisationTypeID;

    @Column(name = "organisationTypeName")
    String organisationTypeName;

    public OrganisationType() {
    }

    public OrganisationType(int organisationTypeID, String organisationTypeName) {
        this.organisationTypeID = organisationTypeID;
        this.organisationTypeName = organisationTypeName;
    }

    @Override
    public String toString() {
        return
                "organisationTypeID = " + organisationTypeID +
                ", organisationTypeName = " + organisationTypeName;
    }
}
