package br.com.bucker.adpters.rest;

import br.com.bucker.shared.dto.ResponseErrorsDomainExceptionDTO;
import br.com.bucker.shared.dto.ResponseExceptionDTO;
import br.com.bucker.usecases.associate.findbyid.FindByIdAssociateUseCaseException;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCaseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class AssociateMapperExceptions {

    ObjectMapper mapper = new ObjectMapper();

    @ServerExceptionMapper
    public RestResponse<ResponseExceptionDTO> mapException(FindByIdAssociateUseCaseException x) {
        ResponseErrorsDomainExceptionDTO[] errors;

        errors = parseErrors(x.getErrors());

        ResponseExceptionDTO responseExceptionDTO = ResponseExceptionDTO.builder()
                .key(x.getKey())
                .message(x.getMessage())
                .errors(errors)
                .build();
        return RestResponse.status(Response.Status.NOT_FOUND, responseExceptionDTO);
    }

    private ResponseErrorsDomainExceptionDTO[] parseErrors(String x) {
        try {
            return mapper.readValue(x, ResponseErrorsDomainExceptionDTO[].class);
        } catch (JsonProcessingException e) {
            Log.error(e);
            return new ResponseErrorsDomainExceptionDTO[0];
        }
    }

    @ServerExceptionMapper
    public RestResponse<ResponseExceptionDTO> mapException(InsertAssociateUseCaseException x) {
        ResponseErrorsDomainExceptionDTO[] errors;

        errors = parseErrors(x.getErrors());

        ResponseExceptionDTO responseExceptionDTO = ResponseExceptionDTO.builder()
                .key(x.getKey())
                .message(x.getMessage())
                .errors(errors)
                .build();
        return RestResponse.status(Response.Status.BAD_REQUEST, responseExceptionDTO);
    }
}
