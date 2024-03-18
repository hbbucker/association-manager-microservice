package br.com.bucker.domain.associate;

import br.com.bucker.domain.shared.BasicEntity;
import br.com.bucker.domain.shared.Notifications;
import br.com.bucker.domain.shared.PersonalDocumentVO;
import br.com.bucker.domain.shared.Tenancy;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@RegisterForReflection
public class AssociateEntity extends Notifications implements BasicEntity {
    Tenancy tenant;
    UUID id;
    String name;
    PersonalDocumentVO documents;
    MilitaryPersonnelInformationVO militaryPersonnelInformation;
    @Singular
    List<ContactVO> contacts;
    AddressVO address;
    LocalDate birthDate;

    protected AssociateEntity(Tenancy tenancy,
                              UUID id,
                              String name,
                              PersonalDocumentVO documents,
                              MilitaryPersonnelInformationVO militaryPersonnelInformation,
                              List<ContactVO> contacts,
                              AddressVO address,
                              LocalDate birthDate) {
        if (id == null) {
            this.id = UUID.randomUUID();
        }

        this.tenant = tenancy;
        this.name = name;
        this.documents = documents;
        this.militaryPersonnelInformation = militaryPersonnelInformation;
        this.contacts = contacts;
        this.address = address;
        this.birthDate = birthDate;

        this.validate();
    }

    public Tenancy getTenant() {
        return this.tenant;
    }

    @Override
    public void validate() {
        nameValidation();
        addressValidation();
        contactsValidation();
        birthDateValidation();
        documentsValidation();
        militaryPersonalInformationValidation();
    }

    private void nameValidation() {
        if (this.name == null) {
            addNotification("name", "Name is required");
        }
    }

    private void birthDateValidation() {
        if (this.birthDate == null) {
            addNotification("birthdate", "Birth Date is required");
        }
    }

    private void documentsValidation() {
        if (this.documents == null) {
            addNotification("document", "Documents is required");
            return;
        }

        if (!documents.isValid()) {
            addNotifications(documents.getNotifications());
        }
    }

    private void addressValidation() {
        if (this.address == null) {
            addNotification("street", "Address is required");
        }
    }

    private void contactsValidation() {
        if (this.contacts == null || this.contacts.isEmpty()) {
            addNotification("contract", "Contacts is required");
        }
    }

    private void militaryPersonalInformationValidation() {
        if (this.militaryPersonnelInformation == null) {
            addNotification("military.personal.information", "Military Personnel Information is required");
            return;
        }

        if (!this.militaryPersonnelInformation.isValid()) {
            addNotifications(this.militaryPersonnelInformation.getNotifications());
        }
    }
}
