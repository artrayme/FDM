package org.artrayme.pbz_lr2.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String telephoneNumber;

    @OneToMany(mappedBy = "warehouse")
    @ToString.Exclude
    private List<InventoryUnitEntity> inventory = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FACTORY_ID")
    private FactoryEntity factory;

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
}
