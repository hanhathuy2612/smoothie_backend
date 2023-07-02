package com.huyhn.smoothie.ingredient.entity;

import com.huyhn.smoothie.ingredient.enumerate.IngredientType;
import com.huyhn.smoothie.ingredient.enumerate.UnitType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Table(name = "ingredient")
@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Ingredient implements IIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;

    private double quantityPerMilliliter;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private IngredientType ingredientType;

    private String colorCode;

    @Override
    public double amountByMillilitre(double quantity) {
        return getQuantityPerMilliliter() * quantity;
    }
}
