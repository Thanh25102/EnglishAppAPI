package com.buimanhthanh.englishappapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {
    private Integer id;
    private String name;
    private String description;
    private String repersent;
    private String type;
}
