package br.com.bucker.adpters.rest.dto.output;

import br.com.bucker.usecases.associate.findall.output.FindAllAssociateUseCaseOuputDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Getter
@Builder
@RegisterForReflection
public class FindAllAssociateRestInputDTO {
    Integer page;
    Integer pageSize;
    Integer total;
    @Singular
    List<FindAllAssociateUseCaseOuputDTO.Associate> associates;

    @Builder
    @RegisterForReflection
    public record Associate (
            String name,
            String cpf,
            String city,
            String state,
            String country
    ){}
}
