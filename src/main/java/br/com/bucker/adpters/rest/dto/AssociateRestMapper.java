package br.com.bucker.adpters.rest.dto;

import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.input.FindAllAssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.adpters.rest.dto.output.FindAllAssociateRestOutputDTO;
import br.com.bucker.usecases.associate.findall.input.FindAllAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.findall.output.FindAllAssociateUseCaseOuputDTO;
import br.com.bucker.usecases.associate.findbyid.dto.output.FindByIdAssociateUseCaseOutputDTO;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AssociateRestMapper {

    @Mapping(target = "name", source = "name")
    AssociateRestOutputDTO toOutput(FindByIdAssociateUseCaseOutputDTO findByIdAssociateUseCaseOutputDTO);

    AssociateRestOutputDTO toOutput(InsertAssociateUseCaseOutupuDTO output);

    InsertAssociateUseCaseInputDTO toInserUsecasetInput(AssociateRestInputDTO input);

    FindAllAssociateUseCaseInputDTO toFindAllUsecaseInput(FindAllAssociateRestInputDTO input);

    FindAllAssociateRestOutputDTO toFindAllOutput(FindAllAssociateUseCaseOuputDTO output);
}
