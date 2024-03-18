package br.com.bucker.usecases.associate.translate;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.adpters.postgres.ContactModel;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.domain.associate.ContactVO;
import br.com.bucker.ports.mapper.AssociateMapper;
import br.com.bucker.usecases.associate.findAll.output.FindAllAssociateUseCaseOuputDTO;
import br.com.bucker.usecases.associate.findById.dto.output.FindByIdAssociateUseCaseOutputDTO;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface AssociateUseCaseMapper extends AssociateMapper {

    @Mappings({
            @Mapping(target = "tenant.id", source = "tenant"),
            @Mapping(target = "documents.rg.rg", source = "documents.rg"),
            @Mapping(target = "documents.rg.rgOrgExpeditor", source = "documents.rgOrgExpeditor"),
            @Mapping(target = "documents.cpf.cpf", source = "documents.cpf")
    })
    AssociateEntity toDomain(InsertAssociateUseCaseInputDTO input);

    @Mappings({
            @Mapping(target = "tenant.id", source = "tenantId"),
            @Mapping(target = "address.street", source = "street"),
            @Mapping(target = "address.number", source = "number"),
            @Mapping(target = "address.complement", source = "complement"),
            @Mapping(target = "address.city", source = "city"),
            @Mapping(target = "address.country", source = "country"),
            @Mapping(target = "address.state", source = "state"),
            @Mapping(target = "address.zipCode", source = "zipCode"),
            @Mapping(target = "documents.rg.rg", source = "rg"),
            @Mapping(target = "documents.rg.rgOrgExpeditor", source = "rgOrgExpeditor"),
            @Mapping(target = "documents.cpf.cpf", source = "cpf"),
            @Mapping(target = "militaryPersonnelInformation.trainingRegiment", source = "trainingRegiment"),
            @Mapping(target = "militaryPersonnelInformation.aspirantDate", source = "aspirantDate"),
            @Mapping(target = "militaryPersonnelInformation.lastRank", source = "lastRank"),
            @Mapping(target = "militaryPersonnelInformation.lastMilitaryOrganization", source = "lastMilitaryOrganization")
    })
    AssociateEntity toDomain(AssociateModel input);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "tenantId", source = "tenant.id"),
            @Mapping(target = "street", source = "address.street"),
            @Mapping(target = "number", source = "address.number"),
            @Mapping(target = "complement", source = "address.complement"),
            @Mapping(target = "city", source = "address.city"),
            @Mapping(target = "country", source = "address.country"),
            @Mapping(target = "state", source = "address.state"),
            @Mapping(target = "zipCode", source = "address.zipCode"),
            @Mapping(target = "rg", source = "documents.rg.rg"),
            @Mapping(target = "rgOrgExpeditor", source = "documents.rg.rgOrgExpeditor"),
            @Mapping(target = "cpf", source = "documents.cpf.cpf"),
            @Mapping(target = "trainingRegiment", source = "militaryPersonnelInformation.trainingRegiment"),
            @Mapping(target = "aspirantDate", source = "militaryPersonnelInformation.aspirantDate"),
            @Mapping(target = "lastRank", source = "militaryPersonnelInformation.lastRank"),
            @Mapping(target = "lastMilitaryOrganization", source = "militaryPersonnelInformation.lastMilitaryOrganization")
    })
    AssociateModel toModel(AssociateEntity associateEntity);

    @Mapping(target = "tenantId", source = "tenant.id")
    ContactModel toContactModel(ContactVO contact);

    List<ContactModel> toContactModel(List<ContactVO> contact);

    @Mappings({
            @Mapping(target = "address.street", source = "street"),
            @Mapping(target = "address.number", source = "number"),
            @Mapping(target = "address.complement", source = "complement"),
            @Mapping(target = "address.city", source = "city"),
            @Mapping(target = "address.country", source = "country"),
            @Mapping(target = "address.state", source = "state"),
            @Mapping(target = "address.zipCode", source = "zipCode"),
            @Mapping(target = "contacts", source = "contacts"),
            @Mapping(target = "documents.rg", source = "rg"),
            @Mapping(target = "documents.rgOrgExpeditor", source = "rgOrgExpeditor"),
            @Mapping(target = "documents.cpf", source = "cpf"),
            @Mapping(target = "militaryPersonnelInformation.trainingRegiment", source = "trainingRegiment"),
            @Mapping(target = "militaryPersonnelInformation.aspirantDate", source = "aspirantDate"),
            @Mapping(target = "militaryPersonnelInformation.lastRank", source = "lastRank"),
            @Mapping(target = "militaryPersonnelInformation.lastMilitaryOrganization", source = "lastMilitaryOrganization")
    })
    FindByIdAssociateUseCaseOutputDTO toFindByIdOutput(AssociateModel associateModel);

    @Mappings({
            @Mapping(target = "tenant", source = "tenant.id"),
            @Mapping(target = "documents.rg", source = "documents.rg.rg"),
            @Mapping(target = "documents.rgOrgExpeditor", source = "documents.rg.rgOrgExpeditor"),
            @Mapping(target = "documents.cpf", source = "documents.cpf.cpf"),
    })
    InsertAssociateUseCaseOutupuDTO toInsertAssociateOutput(AssociateEntity associateEntity);

    @Mapping(target = "associates", source = "associateModel")
    FindAllAssociateUseCaseOuputDTO toFindAllOutput(List<AssociateModel> associateModel);

    @Mappings({
            @Mapping(target = "cpf", source = "documents.cpf.cpf"),
            @Mapping(target = "city", source = "address.city"),
            @Mapping(target = "state", source = "address.state"),
            @Mapping(target = "country", source = "address.country")
    })
    FindAllAssociateUseCaseOuputDTO.Associate toAssociate(AssociateModel associateModel);

}
