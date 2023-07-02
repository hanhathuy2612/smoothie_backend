package com.huyhn.smoothie.ingredient.entity;

import com.huyhn.smoothie.ingredient.enumerate.IngredientType;
import com.huyhn.smoothie.ingredient.enumerate.UnitType;

public interface IIngredient {
    double getQuantity();
    UnitType getUnitType();
    double getQuantityPerMilliliter();
    IngredientType getIngredientType();
    double amountByMillilitre (double quantity);
}
