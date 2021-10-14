package org.artrayme.pbz_lr2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "inventory_unit")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InventoryUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private Long count;

    @ManyToOne
//    @JoinColumn(name="WAREHOUSE_ID")
    private WarehouseEntity warehouse;

//    @ManyToOne
//    @JoinColumn(name="INPUT_REPORT_ID")
//    private InputReportEntity inputReport;

//    @ManyToOne
//    @JoinColumn(name="OUTPUT_REPORT_ID")
//    private OutputReportEntity outputReport;

//    @ManyToOne
//    @JoinColumn(name="FACTORY_ID")
//    private FactoryEntity factory;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        InventoryUnitEntity that = (InventoryUnitEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
