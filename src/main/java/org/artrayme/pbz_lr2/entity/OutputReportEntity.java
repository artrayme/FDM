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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "output_report")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OutputReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String workerFIO;
    private String workerPost;

    @OneToMany(mappedBy = "outputReport")
    @ToString.Exclude
    private List<InventoryUnitEntity> inventory = new ArrayList<>();

    @ManyToOne
    //    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        OutputReportEntity that = (OutputReportEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
