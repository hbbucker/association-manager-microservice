package br.com.bucker.usecases.associate.insert;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.ports.database.associate.AssociateRepository;
import br.com.bucker.ports.database.associate.AssociateRepositoryQualifier;
import br.com.bucker.ports.mapper.AssociateMapper;
import br.com.bucker.usecases.BasicUseCase;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertAssociateUseCase
        implements BasicUseCase<InsertAssociateUseCaseInputDTO, InsertAssociateUseCaseOutupuDTO, InsertAssociateException> {

    final AssociateRepository<AssociateModel> repository;
    final AssociateMapper mapper;

    @Inject
    public InsertAssociateUseCase(
            @AssociateRepositoryQualifier AssociateRepository<AssociateModel> repository,
            AssociateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public InsertAssociateUseCaseOutupuDTO execute(InsertAssociateUseCaseInputDTO input) throws InsertAssociateException {
        AssociateEntity associate = mapper.toDomain(input);

        if (!associate.isValid()) {
            throw new InsertAssociateException("associate.insert.error",
                    associate.errorMessage(),
                    "Associate is not valid");
        }

        repository.save(mapper.toModel(associate));
        return mapper.toInsertAssociateOutput(associate);
    }
}
