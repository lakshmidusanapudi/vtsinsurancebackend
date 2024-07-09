package com.learner.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="healthinsurance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthInsuranceDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String type=PolicyType.HEALTH.toString();
    private String email;
    private String policyNo;
    private String policyId;
    private String policyName;
    @Lob
	@Column(length = 65535)
    private String existing_medical_condition;
    @Lob
	@Column(length = 65535)
    private String current_medication;
    @Lob
    private Blob documentimage;
    private String status;
}
