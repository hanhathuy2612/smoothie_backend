package com.huyhn.smoothie.ingredient.dto.mapper;

import com.huyhn.smoothie.ingredient.dto.IngredientDTO;
import com.huyhn.smoothie.ingredient.entity.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public Ingredient toCreateEntity(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .ingredientType(ingredientDTO.getIngredientType())
                .quantity(ingredientDTO.getQuantity())
                .unitType(ingredientDTO.getUnitType())
                .quantityPerMilliliter(ingredientDTO.getQuantityPerMilliliter())
                .build();
    }

    public IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .ingredientType(ingredient.getIngredientType())
                .quantity(ingredient.getQuantity())
                .unitType(ingredient.getUnitType())
                .quantityPerMilliliter(ingredient.getQuantityPerMilliliter())
                .build();
    }
}
