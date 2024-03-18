package br.com.bucker.ports.restful.associate;

import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.input.FindAllAssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.adpters.rest.dto.output.FindAllAssociateRestOutputDTO;
import br.com.bucker.usecases.associate.findall.FindAllAssociateUseCaseException;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCaseException;

import java.util.UUID;

public interface AssociateRestFul {
    AssociateRestOutputDTO getById(UUID id) throws FindByIdAssociateUseCaseException;

    FindAllAssociateRestOutputDTO getAll(FindAllAssociateRestInputDTO input) throws FindAllAssociateUseCaseException;

    AssociateRestOutputDTO insert(AssociateRestInputDTO input) throws InsertAssociateUseCaseException;


}
