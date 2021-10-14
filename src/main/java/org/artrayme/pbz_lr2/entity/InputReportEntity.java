//package org.artrayme.pbz_lr2.entity;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.Hibernate;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "input_report")
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class InputReportEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private LocalDate date;
//    private String workerFIO;
//    private String workerPost;
//
//    @OneToMany(mappedBy = "inputReport")
//    @ToString.Exclude
//    private List<InventoryUnitEntity> inventory = new ArrayList<>();
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
//            return false;
//        InputReportEntity that = (InputReportEntity) o;
//        return id != null && Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return 0;
//    }
//}
