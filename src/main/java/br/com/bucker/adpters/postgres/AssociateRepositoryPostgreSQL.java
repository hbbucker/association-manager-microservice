package br.com.bucker.adpters.postgres;

import br.com.bucker.ports.database.associate.AssociateRepository;
import br.com.bucker.ports.database.associate.AssociateRepositoryQualifier;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@AssociateRepositoryQualifier
@ApplicationScoped
public class AssociateRepositoryPostgreSQL implements AssociateRepository<AssociateModel> {

    @Override
    public Optional<AssociateModel> getById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public Optional<AssociateModel> getByUuid(UUID uuid) {
        try (Stream<AssociateModel> stream = find("id", uuid).stream()) {
            return stream.findFirst();
        }
    }

    @Override
    public List<AssociateModel> findByName(String name) {
        try(Stream<AssociateModel> stream = find("name", name).stream()) {
            return stream.toList();
        }
    }

    @Override
    public List<AssociateModel> findAllPaging(String stringQuery, Parameters parameters, Sort sort, int page, int pageSize) {
        try(Stream<AssociateModel> stream = find(stringQuery, parameters, sort)
                .page(page, pageSize).stream()) {
            return stream.toList();
        }
    }

    @Override
    @Transactional
    public void save(AssociateModel associateEntity) {
        associateEntity.contacts.forEach(contact -> contact.associate = associateEntity);
        persist(associateEntity);
    }

    @Override
    @Transactional
    public void update(AssociateModel associateEntity) {
        associateEntity.contacts.forEach(contact -> contact.associate = associateEntity);
        persist(associateEntity);
    }

    @Override
    public void delete(UUID id) {
        delete("id", id);
    }
}
