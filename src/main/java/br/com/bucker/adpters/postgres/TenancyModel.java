package br.com.bucker.adpters.postgres;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Getter
@RegisterForReflection
@MappedSuperclass
public class TenancyModel extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    @JdbcType(VarcharJdbcType.class)
    protected UUID id;

    @Column(name = "tenant_id")
    protected Long tenantId;


}
