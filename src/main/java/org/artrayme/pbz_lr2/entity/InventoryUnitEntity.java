package org.artrayme.pbz_lr2.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
//@RequiredArgsConstructor(onConstructor = {type, count})
@AllArgsConstructor
@NoArgsConstructor
public class InventoryUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String type;

    @NonNull
    private Long count;

//    @ManyToOne
//    @JoinColumn(name="WAREHOUSE_ID")
//    private WarehouseEntity warehouse;

    @ManyToOne
//    @JoinColumn(name="INPUT_REPORT_ID")
    private InputReportEntity inputReport;

    @ManyToOne
//    @JoinColumn(name="OUTPUT_REPORT_ID")
    private OutputReportEntity outputReport;

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
