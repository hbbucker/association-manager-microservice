package br.com.bucker.domain.shared;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;

@Getter
@RegisterForReflection
public class CPFDocumentVO extends Notifications implements BasicValidation {
    String cpf;

    @Builder
    protected CPFDocumentVO(String cpf) {
        this.cpf = cpf;
        this.validate();
    }

    @Override
    public void validate() {
        isValidCpf();
    }

    private void isValidCpf() {
        if (cpf == null) {
            addNotification("document.cpf", "CPF is required");
        }

        this.cpf = this.removeString();

        if (cpf.length() != 11 || !cpf.chars().allMatch(Character::isDigit)) {
            addNotification("document.cpf", cpf + " is not a valid CPF number");
        }

        int[] numbers = cpf.chars().map(Character::getNumericValue).toArray();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += numbers[i] * (10 - i);
        }

        int firstCheckDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += numbers[i] * (11 - i);
        }
        sum += firstCheckDigit * 2;

        int secondCheckDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        if (firstCheckDigit != numbers[9] || secondCheckDigit != numbers[10]) {
            addNotification("cpf", cpf + " is not a valid CPF number");
        }
    }

    private String removeString() {
        return cpf.replaceAll("\\D", "");
    }
}
