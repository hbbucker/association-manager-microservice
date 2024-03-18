package br.com.bucker.usecases.associate.insert.dto.input;

import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseAddressDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseMilitaryPersonnelInformationDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCasePersonalDocumentDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseContactDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record InsertAssociateUseCaseInputDTO(
        Long tenant,
        String name,
        InsertAssociateUseCasePersonalDocumentDTO documents,
        InsertAssociateUseCaseMilitaryPersonnelInformationDTO militaryPersonnelInformation,
        List<InsertAssociateUseCaseContactDTO> contacts,
        InsertAssociateUseCaseAddressDTO address,
        LocalDate birthDate
) {}
