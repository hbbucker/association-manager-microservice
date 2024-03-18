package br.com.bucker.ports.database.associate;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssociateRepository<M> extends PanacheRepository<M> {
    Optional<M> getById(Long id);

    Optional<M> getByUuid(UUID uuid);

    List<M> findByName(String name);

    List<M> findAllPaging(String stringQuery, Parameters parameters, Sort sort, int page, int pageSize);

    void save(M associateEntity);

    void update(M associateEntity);

    void delete(UUID id);
}
