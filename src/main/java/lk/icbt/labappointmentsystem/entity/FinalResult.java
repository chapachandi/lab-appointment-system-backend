package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
public class FinalResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultId;


    private String description;
    private String createdBy;
    private Timestamp createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToMany(mappedBy = "finalResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalResultHasTest> finalResultHasTestList;
}
