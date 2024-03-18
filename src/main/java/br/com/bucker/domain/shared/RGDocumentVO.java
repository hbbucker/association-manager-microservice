package br.com.bucker.domain.shared;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;

@Getter
@RegisterForReflection
public class RGDocumentVO extends Notifications implements BasicValidation {
    String rg;
    String rgOrgExpeditor;

    @Builder
    protected RGDocumentVO(String rg, String rgOrgExpeditor) {
        this.rg = rg;
        this.rgOrgExpeditor = rgOrgExpeditor;

        this.validate();
    }

    @Override
    public void validate() {
        this.isValidRg();
    }

    private void isValidRg() {
        if (rg == null) {
            addNotification("document.rg", "RG is required");
        }

        if (rgOrgExpeditor == null) {
            addNotification("document.rgOrgExpeditor", "RG Org expeditor is required");
        }

        this.rgOrgExpeditor = this.removeNumbers();
        this.rg = this.removeString();

        if (rg.length() < 6 || !rg.chars().allMatch(Character::isDigit)) {
            addNotification("document.rg.number", rg + " is not a valid RG number");
        }
    }

    private String removeNumbers() {
        if (rgOrgExpeditor == null) {
            return null;
        }

        return rgOrgExpeditor.replaceAll("[^a-zA-Z/\\-]", "");
    }

    private String removeString() {
        return rg.replaceAll("\\D", "");
    }
}
