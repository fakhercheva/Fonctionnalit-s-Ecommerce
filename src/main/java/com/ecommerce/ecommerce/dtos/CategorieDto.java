package com.ecommerce.ecommerce.dtos;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategorieDto {
    private Long id;

    private String nom;

    private String description;

    // ref to parent category id
    private Long parentId;

    private List<Long> sousCategoreisIds;

    private List<Long> produitsIds;
}
