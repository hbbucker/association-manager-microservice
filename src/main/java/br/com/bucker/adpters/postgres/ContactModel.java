package br.com.bucker.adpters.postgres;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "contact")
@Getter
@RegisterForReflection
@NoArgsConstructor
public class ContactModel extends TenancyModel {
    @Column
    String email;
    @Column
    String phone;
    @ManyToOne
    @JoinColumn(name = "associate_id")
    AssociateModel associate;

    @Builder
    public ContactModel(Long tenantId,
                        UUID id,
                        String email,
                        String phone,
                        AssociateModel associate) {
        this.tenantId = tenantId;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.associate = associate;
    }
}
