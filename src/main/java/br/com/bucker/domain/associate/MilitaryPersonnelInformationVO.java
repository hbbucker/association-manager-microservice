package br.com.bucker.domain.associate;

import br.com.bucker.domain.shared.BasicValidation;
import br.com.bucker.domain.shared.Notifications;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@RegisterForReflection
public class MilitaryPersonnelInformationVO extends Notifications implements BasicValidation {
    String trainingRegiment;
    LocalDate aspirantDate;
    String lastRank;
    String lastMilitaryOrganization;

    @Builder
    private MilitaryPersonnelInformationVO(String trainingRegiment, LocalDate aspirantDate, String lastRank, String lastMilitaryOrganization) {
        this.trainingRegiment = trainingRegiment;
        this.aspirantDate = aspirantDate;
        this.lastRank = lastRank;
        this.lastMilitaryOrganization = lastMilitaryOrganization;

        this.validate();
    }

    @Override
    public void validate() {
        // do nothing
    }
}
