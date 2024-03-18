package br.com.bucker.ports.mapper;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.adpters.postgres.ContactModel;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.domain.associate.ContactVO;
import br.com.bucker.usecases.associate.findAll.output.FindAllAssociateUseCaseOuputDTO;
import br.com.bucker.usecases.associate.findById.dto.output.FindByIdAssociateUseCaseOutputDTO;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;

import java.util.List;

public interface AssociateMapper {
    AssociateEntity toDomain(InsertAssociateUseCaseInputDTO input);
    AssociateEntity toDomain(AssociateModel input);
    AssociateModel toModel(AssociateEntity associateEntity);
    ContactModel toContactModel(ContactVO contact);
    List<ContactModel> toContactModel(List<ContactVO> contact);
    FindByIdAssociateUseCaseOutputDTO toFindByIdOutput(AssociateModel associateModel);
    InsertAssociateUseCaseOutupuDTO toInsertAssociateOutput(AssociateEntity associateEntity);
    FindAllAssociateUseCaseOuputDTO toFindAllOutput(List<AssociateModel> associateModel);
    FindAllAssociateUseCaseOuputDTO.Associate toAssociate(AssociateModel associateModel);
}
