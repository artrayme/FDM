package org.artrayme.pbz_lr2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "inventory_unit")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class InventoryUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "type")
    private String type;

    @NonNull
    @Min(1)
    @Column(name = "count")
    private Long count;

    @ManyToOne
    @JoinColumn(name = "input_report_id", foreignKey = @ForeignKey(name = "FK_INVENTORY_TO_INPUT_REPORT"))
    private InputReportEntity inputReport;

    @ManyToOne
    @JoinColumn(name = "output_report_id", foreignKey = @ForeignKey(name = "FK_INVENTORY_TO_OUTPUT_REPORT"))
    private OutputReportEntity outputReport;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InventoryUnitEntity that = (InventoryUnitEntity) o;
        return type.equals(that.type) && count.equals(that.count) && Objects.equals(inputReport, that.inputReport) && Objects.equals(outputReport, that.outputReport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, count, inputReport, outputReport);
    }
}
