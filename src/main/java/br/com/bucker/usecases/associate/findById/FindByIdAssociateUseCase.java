package br.com.bucker.usecases.associate.findById;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.ports.database.associate.AssociateRepository;
import br.com.bucker.ports.database.associate.AssociateRepositoryQualifier;
import br.com.bucker.ports.mapper.AssociateMapper;
import br.com.bucker.usecases.BasicUseCase;
import br.com.bucker.usecases.associate.findById.dto.input.FindByIdAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.findById.dto.output.FindByIdAssociateUseCaseOutputDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FindByIdAssociateUseCase implements BasicUseCase<FindByIdAssociateUseCaseInputDTO, FindByIdAssociateUseCaseOutputDTO, FindByIdAssociateUseCaseException> {

    final AssociateRepository<AssociateModel> repository;
    final AssociateMapper mapper;

    @Inject
    public FindByIdAssociateUseCase(
            @AssociateRepositoryQualifier AssociateRepository<AssociateModel> repository,
            AssociateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FindByIdAssociateUseCaseOutputDTO execute(FindByIdAssociateUseCaseInputDTO input) throws FindByIdAssociateUseCaseException {
        Optional<AssociateModel> associateModel = repository.getByUuid(input.getId());
        if (associateModel.isEmpty()) {
            throw new FindByIdAssociateUseCaseException("associate.not.found", "Associate not found", "Associate not found");
        }

        AssociateEntity associate = mapper.toDomain(associateModel.get());
        if (!associate.isValid()) {
            throw new FindByIdAssociateUseCaseException("associate.not.valid", associate.errorMessage(), "Associate is not valid");
        }
        return mapper.toFindByIdOutput(associateModel.get());
    }
}
