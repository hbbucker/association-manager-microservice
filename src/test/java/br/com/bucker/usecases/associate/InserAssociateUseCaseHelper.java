package br.com.bucker.usecases.associate;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.domain.shared.Tenancy;
import br.com.bucker.domain.associate.AddressVO;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.domain.associate.ContactVO;
import br.com.bucker.domain.associate.MilitaryPersonnelInformationVO;
import br.com.bucker.domain.shared.CPFDocumentVO;
import br.com.bucker.domain.shared.PersonalDocumentVO;
import br.com.bucker.domain.shared.RGDocumentVO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseAddressDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseContactDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCaseMilitaryPersonnelInformationDTO;
import br.com.bucker.usecases.associate.insert.dto.InsertAssociateUseCasePersonalDocumentDTO;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class InserAssociateUseCaseHelper {

    public static InsertAssociateUseCaseInputDTO createInput() {
        LocalDate birthDate = LocalDate.of(2000, 1, 1);
        LocalDate aspirantDate = LocalDate.of(2000, 1, 1);
        return InsertAssociateUseCaseInputDTO.builder()
                .name("name")
                .birthDate(birthDate)
                .address(InsertAssociateUseCaseAddressDTO.builder()
                        .street("street")
                        .city("city")
                        .country("country")
                        .state("state")
                        .zipCode("zipCode")
                        .build())
                .documents(InsertAssociateUseCasePersonalDocumentDTO.builder()
                        .cpf("42081521091")
                        .rg("123456")
                        .rgOrgExpeditor("SSP/TT")
                        .build())
                .militaryPersonnelInformation(
                        InsertAssociateUseCaseMilitaryPersonnelInformationDTO.builder()
                                .trainingRegiment("trainingRegiment")
                                .lastRank("lastRank")
                                .aspirantDate(aspirantDate)
                                .lastMilitaryOrganization("lastMilitaryOrganization")
                                .build())
                .contacts(List.of(InsertAssociateUseCaseContactDTO.builder()
                        .email("email")
                        .phone("phone")
                        .build()))
                .build();
    }

    public static InsertAssociateUseCaseInputDTO createInputWihoutAddress() {
        LocalDate birthDate = LocalDate.of(2000, 1, 1);
        LocalDate aspirantDate = LocalDate.of(2000, 1, 1);
        return InsertAssociateUseCaseInputDTO.builder()
                .name("name")
                .birthDate(birthDate)
                .documents(InsertAssociateUseCasePersonalDocumentDTO.builder()
                        .cpf("42081521091")
                        .rg("123456")
                        .rgOrgExpeditor("SSP/TT")
                        .build())
                .militaryPersonnelInformation(
                        InsertAssociateUseCaseMilitaryPersonnelInformationDTO.builder()
                                .trainingRegiment("trainingRegiment")
                                .lastRank("lastRank")
                                .aspirantDate(aspirantDate)
                                .lastMilitaryOrganization("lastMilitaryOrganization")
                                .build())
                .contacts(List.of(InsertAssociateUseCaseContactDTO.builder()
                        .email("email")
                        .phone("phone")
                        .build()))
                .build();
    }

    public static AssociateEntity createDomainFromInput(InsertAssociateUseCaseInputDTO input) {
        return AssociateEntity.builder()
                .tenant(Tenancy.builder().id(input.tenant()).build())
                .name(input.name())
                .birthDate(input.birthDate())
                .address(input.address() != null ? createAddressFromInput(input.address()) : null)
                .documents(input.documents() != null ? createDocumentFromInput(input.documents()) : null)
                .militaryPersonnelInformation(createMilitaryPersonnelInformationFromInput(input.militaryPersonnelInformation()))
                .contacts(createContactsFromInput(input.contacts()))
                .build();
    }

    private static Collection<? extends ContactVO> createContactsFromInput(List<InsertAssociateUseCaseContactDTO> input) {
        return List.of(ContactVO.builder()
                .email(input.get(0).email())
                .phone(input.get(0).phone())
                .build());
    }

    private static MilitaryPersonnelInformationVO createMilitaryPersonnelInformationFromInput(InsertAssociateUseCaseMilitaryPersonnelInformationDTO input) {
        return MilitaryPersonnelInformationVO.builder()
                .trainingRegiment(input.trainingRegiment())
                .lastRank(input.lastRank())
                .aspirantDate(input.aspirantDate())
                .lastMilitaryOrganization(input.lastMilitaryOrganization())
                .build();
    }

    private static PersonalDocumentVO createDocumentFromInput(InsertAssociateUseCasePersonalDocumentDTO documents) {
        return PersonalDocumentVO.builder()
                .cpf(CPFDocumentVO.builder()
                        .cpf(documents.cpf())
                        .build())
                .rg(RGDocumentVO.builder()
                        .rg(documents.rg())
                        .rgOrgExpeditor(documents.rgOrgExpeditor())
                        .build())
                .build();
    }

    private static AddressVO createAddressFromInput(InsertAssociateUseCaseAddressDTO address) {
        return AddressVO.builder()
                .street(address.street())
                .city(address.city())
                .country(address.country())
                .state(address.state())
                .zipCode(address.zipCode())
                .build();
    }

    public static AssociateModel createModelFromDomain(AssociateEntity entity) {
        return AssociateModel.builder()
                .build();
    }

    public static InsertAssociateUseCaseInputDTO createInputWihoutDocuments() {
        LocalDate birthDate = LocalDate.of(2000, 1, 1);
        LocalDate aspirantDate = LocalDate.of(2000, 1, 1);
        return InsertAssociateUseCaseInputDTO.builder()
                .name("name")
                .birthDate(birthDate)
                .address(InsertAssociateUseCaseAddressDTO.builder()
                        .street("street")
                        .city("city")
                        .country("country")
                        .state("state")
                        .zipCode("zipCode")
                        .build())
                .militaryPersonnelInformation(
                        InsertAssociateUseCaseMilitaryPersonnelInformationDTO.builder()
                                .trainingRegiment("trainingRegiment")
                                .lastRank("lastRank")
                                .aspirantDate(aspirantDate)
                                .lastMilitaryOrganization("lastMilitaryOrganization")
                                .build())
                .contacts(List.of(InsertAssociateUseCaseContactDTO.builder()
                        .email("email")
                        .phone("phone")
                        .build()))
                .build();
    }
}
