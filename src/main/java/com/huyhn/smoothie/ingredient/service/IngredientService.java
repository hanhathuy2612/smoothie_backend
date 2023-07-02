package com.huyhn.smoothie.ingredient.service;

import com.huyhn.smoothie.ingredient.dto.IngredientDTO;
import com.huyhn.smoothie.ingredient.dto.ShellSmoothieRequest;
import com.huyhn.smoothie.ingredient.dto.ShellSmoothieResponse;
import com.huyhn.smoothie.ingredient.dto.mapper.IngredientMapper;
import com.huyhn.smoothie.ingredient.entity.Ingredient;
import com.huyhn.smoothie.ingredient.exception.BadRequestException;
import com.huyhn.smoothie.ingredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    private static final String REMAIN_QUANTITY_IS_NOT_ENOUGH = "Remain quantity of %s is not enough";

    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream().map(
                ingredientMapper::toDTO
        ).collect(Collectors.toList());
    }

    public IngredientDTO create(IngredientDTO dto) {
        return ingredientMapper.toDTO(
                ingredientRepository.save(
                        ingredientMapper.toCreateEntity(dto)
                )
        );
    }

    @Transactional
    public ShellSmoothieResponse shellSmoothie(ShellSmoothieRequest request) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        Map<String, Double> smoothieTracker = new HashMap<>();

        for (Ingredient ingredient : ingredients) {
            double amountByMillilitre = ingredient.amountByMillilitre(request.getNumberOfMilliliter());
            double remainQuantity = ingredient.getQuantity() - amountByMillilitre;
            if (remainQuantity < 0) {
                throw new BadRequestException(
                        String.format(REMAIN_QUANTITY_IS_NOT_ENOUGH, ingredient.getIngredientType().name())
                );
            }

            ingredient = ingredient.toBuilder()
                    .quantity(remainQuantity)
                    .build();
            ingredientRepository.save(ingredient);
            smoothieTracker.put(ingredient.getIngredientType().name(), amountByMillilitre);
        }

        return ShellSmoothieResponse.builder()
                .ingredients(ingredients)
                .smoothieTracker(smoothieTracker)
                .build();
    }

}
