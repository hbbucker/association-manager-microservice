package br.com.bucker.adpters.rest.dto;

import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.usecases.associate.findbyid.dto.output.FindByIdAssociateUseCaseOutputDTO;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jarkata")
public interface AssociateRestMapper {

    AssociateRestOutputDTO toOutput(@NotNull FindByIdAssociateUseCaseOutputDTO findByIdAssociateUseCaseOutputDTO);

    AssociateRestOutputDTO toOutput(@NotNull InsertAssociateUseCaseOutupuDTO output);

    InsertAssociateUseCaseInputDTO toInsertInput(@NotNull AssociateRestInputDTO input);
}
