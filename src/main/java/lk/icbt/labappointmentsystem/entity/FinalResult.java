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
public class FinalResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultId;


    private String description;
    private String createdBy;
    private Timestamp createdDate;
}
