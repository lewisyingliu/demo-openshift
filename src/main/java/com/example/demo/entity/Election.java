package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "elections")
@EntityListeners(AuditingEntityListener.class)
public class Election extends UserDateAudit {

    @NotBlank
    @Size(max = 128)
    private String code;

    @NotBlank
    @Size(max = 128)
    private String title;

    @NotNull
    private LocalDate electionDate;

    private LocalDate advanceVoteDate;

    private LocalDate nominationPeriodDate;

    @NotNull
    private boolean defaultTag = false;

    private Integer serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 128)
    private EElection status = EElection.PrePublished;

}
