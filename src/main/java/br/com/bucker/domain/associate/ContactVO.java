package br.com.bucker.domain.associate;

import br.com.bucker.domain.shared.BasicEntity;
import br.com.bucker.domain.shared.Tenancy;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@RegisterForReflection
public class ContactVO implements BasicEntity {
    Tenancy tenant;
    UUID id;
    String email;
    String phone;

    protected ContactVO(Tenancy tenant, UUID id, String email, String phone) {
        this.tenant = tenant;
        this.email = email;
        this.phone = phone;

        if (id == null) {
            this.id = UUID.randomUUID();
        }
    }

    @Override
    public Tenancy getTenant() {
        return this.tenant;
    }
}

