package br.com.bucker.ports.restful.associate;

import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.insert.InsertAssociateException;

import java.util.UUID;

public interface AssociateRestFul {
    AssociateRestOutputDTO getById(UUID id) throws FindByIdAssociateUseCaseException;

    AssociateRestOutputDTO insert(AssociateRestInputDTO input) throws InsertAssociateException;

}
