package br.com.bucker.usecases.associate.insert.dto.output;

import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseAddressDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseContactDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseMilitaryPersonnelInformationDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCasePersonalDocumentDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@RegisterForReflection
public record InsertAssociateUseCaseOutupuDTO(
        Long tenant,
        UUID id,
        String name,
        InsertAssociateUseCasePersonalDocumentDTO documents,
        InsertAssociateUseCaseMilitaryPersonnelInformationDTO militaryPersonnelInformation,
        List<InsertAssociateUseCaseContactDTO> contacts,
        InsertAssociateUseCaseAddressDTO address,
        LocalDate birthDate
) {
}
