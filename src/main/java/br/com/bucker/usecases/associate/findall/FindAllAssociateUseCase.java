package br.com.bucker.usecases.associate.findall;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.domain.shared.CPFDocumentVO;
import br.com.bucker.ports.database.associate.AssociateRepository;
import br.com.bucker.ports.database.associate.AssociateRepositoryQualifier;
import br.com.bucker.ports.mapper.AssociateMapper;
import br.com.bucker.usecases.BasicUseCase;
import br.com.bucker.usecases.associate.findall.input.FindAllAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.findall.output.FindAllAssociateUseCaseOuputDTO;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FindAllAssociateUseCase implements BasicUseCase<FindAllAssociateUseCaseInputDTO, FindAllAssociateUseCaseOuputDTO, FindAllAssociateUseCaseException> {

    final AssociateRepository<AssociateModel> repository;
    final AssociateMapper mapper;

    @Inject
    public FindAllAssociateUseCase(
            @AssociateRepositoryQualifier AssociateRepository<AssociateModel> repository,
            AssociateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FindAllAssociateUseCaseOuputDTO execute(FindAllAssociateUseCaseInputDTO input) throws FindAllAssociateUseCaseException {

        Parameters parameters = new Parameters();
        List<String> conditions = new ArrayList<>();

        addCpfCondition(input.cpf(), parameters, conditions);
        addNameCondition(input.name(), parameters, conditions);
        addCityCondition(input.city(), parameters, conditions);
        addStateCondition(input.state(), parameters, conditions);
        addCountryCondition(input.country(), parameters, conditions);

        List<AssociateModel> associateModels = repository
                .findAllPaging(
                        buildQuery(conditions),
                        parameters,
                        input.sort() == null ? Sort.by("name") : Sort.by(input.sort()),
                        input.page(),
                        input.pageSize());

        FindAllAssociateUseCaseOuputDTO output = mapper.toFindAllOutput(associateModels);

        output.setPage(input.page());
        output.setPageSize(input.pageSize());
        return output;
    }

    private String buildQuery(List<String> conditions) {
        StringBuilder query = new StringBuilder("1 = 1");
        conditions.forEach(condition -> query.append(" AND ").append(condition));
        return query.toString();
    }

    private void addCpfCondition(String input, Parameters parameters, List<String> conditions) {
        if (input == null) {
            return;
        }

        CPFDocumentVO cpf = CPFDocumentVO.builder()
                .cpf(input)
                .build();

        if (cpf.isValid()) {
            addStringCondition(cpf.getCpf(), AssociationUseCaseConditionsEnum.CPF, parameters, conditions);
        }
    }

    private void addNameCondition(String input, Parameters parameters, List<String> conditions) {
        addStringCondition(input, AssociationUseCaseConditionsEnum.NAME, parameters, conditions);
    }

    private void addCityCondition(String input, Parameters parameters, List<String> conditions) {
        addStringCondition(input, AssociationUseCaseConditionsEnum.CITY, parameters, conditions);
    }

    private void addStateCondition(String input, Parameters parameters, List<String> conditions) {
        addStringCondition(input, AssociationUseCaseConditionsEnum.STATE, parameters, conditions);
    }

    private void addCountryCondition(String input, Parameters parameters, List<String> conditions) {
        addStringCondition(input, AssociationUseCaseConditionsEnum.COUNTRY, parameters, conditions);
    }

    private void addStringCondition(String value, AssociationUseCaseConditionsEnum field, Parameters parameters, List<String> conditions) {
        if (value != null) {
            conditions.add(field.getCondition());
            parameters.and(field.getField(), value);
        }
    }
}
