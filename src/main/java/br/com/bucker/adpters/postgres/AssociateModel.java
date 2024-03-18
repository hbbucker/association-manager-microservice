package br.com.bucker.adpters.postgres;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.Registered;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "associate")
@Getter
@RegisterForReflection
@NoArgsConstructor
public class AssociateModel extends TenancyModel {
    @Column
    String name;
    @Column
    String cpf;
    @Column
    String rg;
    @Column(name = "rg_org_expeditor")
    String rgOrgExpeditor;
    @Column(name = "training_regiment")
    String trainingRegiment;
    @Column(name = "aspirant_date")
    LocalDate aspirantDate;
    @Column(name = "last_rank")
    String lastRank;
    @Column(name = "last_military_organization")
    String lastMilitaryOrganization;
    @OneToMany(mappedBy = "associate", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ContactModel> contacts = new ArrayList<>();
    @Column
    String street;
    @Column
    String number;
    @Column
    String complement;
    @Column
    String city;
    @Column
    String state;
    @Column(name = "zip_code")
    String zipCode;
    @Column
    String country;
    @Column(name = "birth_date")
    LocalDate birthDate;

    @Builder
    public AssociateModel(Long tenantId,
                          UUID id,
                          String name,
                          String cpf,
                          String rg,
                          String rgOrgExpeditor,
                          String trainingRegiment,
                          LocalDate aspirantDate,
                          String lastRank,
                          String lastMilitaryOrganization,
                          List<ContactModel> contacts,
                          String street,
                          String number,
                          String complement,
                          String city,
                          String state,
                          String zipCode,
                          String country,
                          LocalDate birthDate) {
        this.tenantId = tenantId;
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.rgOrgExpeditor = rgOrgExpeditor;
        this.trainingRegiment = trainingRegiment;
        this.aspirantDate = aspirantDate;
        this.lastRank = lastRank;
        this.lastMilitaryOrganization = lastMilitaryOrganization;
        contacts.forEach(c -> c.associate = this);
        this.contacts = (contacts);
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.birthDate = birthDate;
    }
}
