package org.artrayme.pbz_lr2.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "warehouse", uniqueConstraints = { @UniqueConstraint(name = "WAREHOUSE_NAME_CONSTRAIN", columnNames = "name") })
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    @Column(name = "telephone")
    private String telephoneNumber;

    @OneToMany(mappedBy = "warehouse", orphanRemoval = true)
    @ToString.Exclude
    private List<InputReportEntity> inputReportEntities = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse", orphanRemoval = true)
    @ToString.Exclude
    private List<OutputReportEntity> outputReportEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "factory_id", nullable = false, foreignKey = @ForeignKey(name="FK_WAREHOUSE_TO_FACTORY"))
    private FactoryEntity factory;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WarehouseEntity warehouse = (WarehouseEntity) o;
        return Objects.equals(name, warehouse.name) && Objects.equals(factory, warehouse.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, factory);
    }
}
