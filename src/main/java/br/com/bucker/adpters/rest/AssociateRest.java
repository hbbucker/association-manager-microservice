package br.com.bucker.adpters.rest;

import br.com.bucker.adpters.rest.dto.AssociateRestMapper;
import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.input.FindAllAssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.adpters.rest.dto.output.FindAllAssociateRestOutputDTO;
import br.com.bucker.ports.restful.associate.AssociateRestFul;
import br.com.bucker.usecases.associate.findall.FindAllAssociateUseCase;
import br.com.bucker.usecases.associate.findall.FindAllAssociateUseCaseException;
import br.com.bucker.usecases.associate.findall.input.FindAllAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCase;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.findbyid.dto.input.FindByIdAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCaseException;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCase;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import io.quarkus.resteasy.reactive.links.InjectRestLinks;
import io.quarkus.resteasy.reactive.links.RestLink;
import io.quarkus.resteasy.reactive.links.RestLinkType;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Path("/associates")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateRest implements AssociateRestFul {

    final FindAllAssociateUseCase findAll;
    final FindByIdAssociateUseCase findById;
    final InsertAssociateUseCase insert;
    final AssociateRestMapper mapper;

    @Inject
    public AssociateRest(
            FindAllAssociateUseCase findAll,
            FindByIdAssociateUseCase findById,
            InsertAssociateUseCase insert,
            AssociateRestMapper mapper) {
        this.findAll = findAll;
        this.findById = findById;
        this.insert = insert;
        this.mapper = mapper;
    }

    @GET
    @Override
    @Path("/{id}")
    @RestLink(rel = "self")
    @InjectRestLinks(RestLinkType.INSTANCE)
    public AssociateRestOutputDTO getById(@PathParam("id") UUID id) throws FindByIdAssociateUseCaseException {
        FindByIdAssociateUseCaseInputDTO inputUsecase = FindByIdAssociateUseCaseInputDTO.builder().id(id).build();

        return mapper.toOutput(findById.execute(inputUsecase));
    }

    @GET
    @Override
    @Path("/all")
    @RestLink(rel = "all")
    @InjectRestLinks(RestLinkType.INSTANCE)
    public FindAllAssociateRestOutputDTO getAll(FindAllAssociateRestInputDTO input) throws FindAllAssociateUseCaseException {
        FindAllAssociateUseCaseInputDTO useCaseInput = mapper.toFindAllUsecaseInput(input);

        return mapper.toFindAllOutput(findAll.execute(useCaseInput));
    }

    @POST
    @Override
    @ResponseStatus(201)
    @RestLink(rel = "self")
    @InjectRestLinks(RestLinkType.INSTANCE)
    public AssociateRestOutputDTO insert(AssociateRestInputDTO input) throws InsertAssociateUseCaseException {
        InsertAssociateUseCaseInputDTO insertAssociateUseCaseInputDTO = mapper.toInserUsecasetInput(input);

        return mapper.toOutput(insert.execute(insertAssociateUseCaseInputDTO));
    }

}
