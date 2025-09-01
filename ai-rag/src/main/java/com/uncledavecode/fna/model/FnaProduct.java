package com.uncledavecode.fna.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FnaProduct {
    private Long id;
    private Long fnaId;
    private Long pofId;
    private String status;
    private String version;
    private Boolean isActive;
}
