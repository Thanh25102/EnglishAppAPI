package com.buimanhthanh.englishappapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Integer id;
    private String name;
    private String target;
    private String description;

}
