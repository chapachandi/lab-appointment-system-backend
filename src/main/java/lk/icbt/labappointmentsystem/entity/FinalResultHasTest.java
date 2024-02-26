package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class FinalResultHasTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultHasTestId;


    private String description;
    private Boolean isActive;
    private String createdBy;
    private Timestamp createdDate;
}
