package com.huyhn.smoothie.ingredient.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class ShellSmoothieRequest {
    @Builder.Default
    private double numberOfMilliliter = 300;
}
