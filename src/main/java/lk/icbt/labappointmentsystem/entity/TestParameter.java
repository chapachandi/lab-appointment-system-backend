package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class TestParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testParameterId;

    @NotBlank(message = "Patient name cannot be blank")
    private String patientName;

    @NotBlank(message = "Test name cannot be blank")
    private String testName;


    private BigDecimal price;
    private String createdBy;
    private Timestamp createdDate;

}
