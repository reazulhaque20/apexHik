package com.apex.hik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AMS_MACHINES")
public class AmsMachine {
    @Id
    @Column(name = "MACHINE_ID", nullable = false)
    private Long id;

    @Column(name = "MACHINE_CODE", nullable = false, length = 15)
    private String machineCode;

    @Column(name = "MACHINE_NAME", nullable = false)
    private Long machineName;

    @Column(name = "MACHINE_BRAND", nullable = false)
    private Long machineBrand;

    @Column(name = "MACHINE_MODEL", nullable = false, length = 20)
    private String machineModel;

    @Column(name = "MACHINE_SERIAL", nullable = false, length = 20)
    private String machineSerial;

    @Column(name = "MACHINE_IP", nullable = false, length = 16)
    private String machineIp;

    @Column(name = "MACHINE_IP_PORT", nullable = false)
    private Long machineIpPort;

    @Column(name = "MACHINE_MAC", nullable = false, length = 20)
    private String machineMac;

    @Column(name = "MACHINE_USERNAME", nullable = false, length = 15)
    private String machineUsername;

    @Column(name = "MACHINE_PASSWORD", nullable = false, length = 200)
    private String machinePassword;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "COMPLEX_ID", nullable = false)
    private Long complexId;

    @Column(name = "FLOOR_LOCATION", nullable = false, length = 45)
    private String floorLocation;

    @Column(name = "MACHINE_GROUP", nullable = false)
    private Long machineGroup;

    @Column(name = "STATUS", nullable = false, length = 8)
    private String status;

    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @Column(name = "CREATED_DT", nullable = false)
    private LocalDate createdDt;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "UPDATED_DT")
    private LocalDate updatedDt;
}