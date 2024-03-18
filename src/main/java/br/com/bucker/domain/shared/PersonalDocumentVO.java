package br.com.bucker.domain.shared;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;

@Getter
@RegisterForReflection
public class PersonalDocumentVO extends Notifications implements BasicValidation {
    CPFDocumentVO cpf;
    RGDocumentVO rg;

    @Builder
    protected PersonalDocumentVO(CPFDocumentVO cpf, RGDocumentVO rg) {
        this.cpf = cpf;
        this.rg = rg;

        this.validate();
    }

    @Override
    public void validate() {
        cpf.getNotifications().forEach(this::addNotification);
        rg.getNotifications().forEach(this::addNotification);
    }
}
