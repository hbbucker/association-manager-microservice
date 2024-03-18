package br.com.bucker.domain.associate;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@RegisterForReflection
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AddressVO {
    String street;
    String number;
    String complement;
    String city;
    String state;
    String zipCode;
    String country;
}
