package br.com.bucker.adpters.rest;

import br.com.bucker.adpters.rest.dto.AssociateRestMapper;
import br.com.bucker.adpters.rest.dto.input.AssociateRestInputDTO;
import br.com.bucker.adpters.rest.dto.output.AssociateRestOutputDTO;
import br.com.bucker.ports.restful.associate.AssociateRestFul;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCase;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.findbyid.dto.input.FindByIdAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.InsertAssociateException;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCase;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import io.quarkus.resteasy.reactive.links.InjectRestLinks;
import io.quarkus.resteasy.reactive.links.RestLink;
import io.quarkus.resteasy.reactive.links.RestLinkType;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.UUID;

@Path("/associates")
@Produces(MediaType.APPLICATION_JSON)
public class AssociateRest implements AssociateRestFul {

    final FindByIdAssociateUseCase findById;
    final InsertAssociateUseCase insert;
    final AssociateRestMapper mapper;

    @Inject
    public AssociateRest(
            FindByIdAssociateUseCase findById,
            InsertAssociateUseCase insert,
            AssociateRestMapper mapper) {
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

    @POST
    @Override
    @ResponseStatus(201)
    @RestLink(rel = "self")
    @InjectRestLinks(RestLinkType.INSTANCE)
    public AssociateRestOutputDTO insert(AssociateRestInputDTO input) throws InsertAssociateException {
        InsertAssociateUseCaseInputDTO insertAssociateUseCaseInputDTO = mapper.toInsertInput(input);

        return mapper.toOutput(insert.execute(insertAssociateUseCaseInputDTO));
    }

}
