package br.com.bucker.usecases.associate.findAll.output;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
@Builder
@RegisterForReflection
public class FindAllAssociateUseCaseOuputDTO {
        Integer page;
        Integer pageSize;
        Integer total;
        @Singular
        List<Associate> associates;

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
