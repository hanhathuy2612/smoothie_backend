package com.huyhn.smoothie.ingredient.dto;

import com.huyhn.smoothie.ingredient.entity.Ingredient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@SuperBuilder
@NoArgsConstructor
public class ShellSmoothieResponse {

    private Map<String, Double> smoothieTracker;

    @Builder.Default
    private List<Ingredient> ingredients = new ArrayList<>();
}
