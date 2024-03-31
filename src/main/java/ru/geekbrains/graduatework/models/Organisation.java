package ru.geekbrains.graduatework.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificatedb.organisations")
public class Organisation {

    @Id
    @Column(name = "organisationID")
    private int organisationID;

    @Column(name = "organisationName")
    private String organisationName;

    @Column(name = "organisationAddress")
    private String organisationAddress;

    @Column(name = "organisationPhone")
    private String organisationPhone;

    @ManyToOne(targetEntity = OrganisationType.class)
    @JoinColumn(name = "organisationTypeID")
    private OrganisationType organisationType;

    public Organisation(int organisationID, String organisationName, String organisationAddress, String organisationPhone, OrganisationType organisationType) {
        this.organisationID = organisationID;
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        this.organisationPhone = organisationPhone;
        this.organisationType = organisationType;
    }

    public Organisation(int organisationID,String organizationName) {
        this.organisationID = organisationID;
        this.organisationName = organizationName;
    }

    public Organisation() {
    }

    @Override
    public String toString() {
        return "organisationID = " + organisationID +
                ", organisationName = " + organisationName +
                ", organisationAddress = " + organisationAddress +
                ", organisationPhone = " + organisationPhone +
                ", organisationType = " + organisationType.getOrganisationTypeName();
    }
}
