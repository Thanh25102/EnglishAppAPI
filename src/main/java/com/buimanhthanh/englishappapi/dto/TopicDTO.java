package com.buimanhthanh.englishappapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {
    private Integer id;
    private String represent;
    private String description;
    private String descriptiveMeaning;
    private Integer lessonId;
}
