package com.huyhn.smoothie.ingredient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huyhn.smoothie.ingredient.enumerate.IngredientType;
import com.huyhn.smoothie.ingredient.enumerate.UnitType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class IngredientDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private double quantity;

    private double quantityPerMilliliter;

    private UnitType unitType;

    private IngredientType ingredientType;
}
