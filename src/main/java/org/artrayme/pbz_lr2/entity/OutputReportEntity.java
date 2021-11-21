package org.artrayme.pbz_lr2.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "output_report")
public class OutputReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotBlank
    @Column(name = "worker_fio")
    private String workerFIO;

    @NotBlank
    @Column(name = "worker_post")
    private String workerPost;

    @OneToMany(mappedBy = "outputReport", orphanRemoval = true)
    @ToString.Exclude
    private List<InventoryUnitEntity> inventory = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false, foreignKey = @ForeignKey(name = "FK_OUTPUT_REPORT_TO_WAREHOUSE"))
    private WarehouseEntity warehouse;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OutputReportEntity that = (OutputReportEntity) o;
        return Objects.equals(date, that.date) && Objects.equals(workerFIO, that.workerFIO) && Objects.equals(workerPost, that.workerPost) && Objects.equals(inventory, that.inventory) && Objects.equals(warehouse, that.warehouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, workerFIO, workerPost, inventory, warehouse);
    }
}
