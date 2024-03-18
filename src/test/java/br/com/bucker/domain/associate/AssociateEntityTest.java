package br.com.bucker.domain.associate;

import br.com.bucker.domain.shared.CPFDocumentVO;
import br.com.bucker.domain.shared.PersonalDocumentVO;
import br.com.bucker.domain.shared.RGDocumentVO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class AssociateEntityTest {

        @Test
        void should_create_entity() {
            AddressVO address = AddressVO.builder()
                    .street("Rua 1")
                    .city("Cidade 1")
                    .state("Estado 1")
                    .zipCode("123456")
                    .country("Brasil")
                    .build();

            ContactVO contact = ContactVO.builder()
                    .email("teste@email.com")
                    .phone("123456789")
                    .build();

            MilitaryPersonnelInformationVO militaryPersonnelInformation = MilitaryPersonnelInformationVO.builder()
                    .aspirantDate(LocalDate.now())
                    .lastRank("TENENTE")
                    .lastMilitaryOrganization("CMO")
                    .trainingRegiment("20RCB")
                    .build();

            PersonalDocumentVO documents = PersonalDocumentVO.builder()
                    .cpf(CPFDocumentVO .builder().cpf("79320244120").build())
                    .rg(RGDocumentVO.builder()
                            .rg("123456")
                            .rgOrgExpeditor("SSP/MS")
                            .build())
                    .build();

            AssociateEntity associate = AssociateEntity.builder()
                    .name("Nome")
                    .documents(documents)
                    .address(address)
                    .birthDate(LocalDate.now())
                    .contact(contact)
                    .militaryPersonnelInformation(militaryPersonnelInformation)
                    .build();

            assertDoesNotThrow(associate::validate);
            assertTrue(associate.isValid());
        }
}