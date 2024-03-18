package br.com.bucker.usecases.associate.findall;

import lombok.Getter;

public enum AssociationUseCaseConditionsEnum {
    CPF("cpf = :cpf", "cpf"),
    NAME("name ILIKE :name", "name"),
    CITY("city ILIKE :city", "city"),
    STATE("state ILIKE :state", "state"),
    COUNTRY("country ILIKE :country", "country");

    @Getter
    final String condition;
    @Getter
    final String field;

    AssociationUseCaseConditionsEnum(String condition, String field) {
        this.condition = condition;
        this.field = field;
    }
}
