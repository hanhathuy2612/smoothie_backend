package com.huyhn.smoothie.ingredient.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class BaseResponse<T extends Serializable> {
    private boolean success;
    private T data;
}
