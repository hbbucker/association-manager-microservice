package br.com.bucker.adpters.rest;

import br.com.bucker.shared.dto.ResponseErrorsDomainExceptionDTO;
import br.com.bucker.shared.dto.ResponseExceptionDTO;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.insert.InsertAssociateException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class AssociateMapperExceptions {

    ObjectMapper mapper = new ObjectMapper();

    @ServerExceptionMapper
    public RestResponse<ResponseExceptionDTO> mapException(FindByIdAssociateUseCaseException x) {
        ResponseErrorsDomainExceptionDTO[] errors;

        try {
            errors = mapper.readValue(x.getErrors(), ResponseErrorsDomainExceptionDTO[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ResponseExceptionDTO responseExceptionDTO = ResponseExceptionDTO.builder()
                .key(x.getKey())
                .message(x.getMessage())
                .errors(errors)
                .build();
        return RestResponse.status(Response.Status.NOT_FOUND, responseExceptionDTO);
    }

    @ServerExceptionMapper
    public RestResponse<ResponseExceptionDTO> mapException(InsertAssociateException x) {
        ResponseErrorsDomainExceptionDTO[] errors;

        try {
            errors = mapper.readValue(x.getErrors(), ResponseErrorsDomainExceptionDTO[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ResponseExceptionDTO responseExceptionDTO = ResponseExceptionDTO.builder()
                .key(x.getKey())
                .message(x.getMessage())
                .errors(errors)
                .build();
        return RestResponse.status(Response.Status.BAD_REQUEST, responseExceptionDTO);
    }
}
