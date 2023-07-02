package com.huyhn.smoothie.ingredient.controller;

import com.huyhn.smoothie.ingredient.dto.IngredientDTO;
import com.huyhn.smoothie.ingredient.dto.ShellSmoothieRequest;
import com.huyhn.smoothie.ingredient.dto.ShellSmoothieResponse;
import com.huyhn.smoothie.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAll() {
        return ResponseEntity.ok(ingredientService.getAll());
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> create(@RequestBody IngredientDTO dto) {
        return ResponseEntity.ok(ingredientService.create(dto));
    }

    @PostMapping("shell")
    public ResponseEntity<ShellSmoothieResponse> shellSmoothie(@RequestBody ShellSmoothieRequest request) {
        return ResponseEntity.ok(
                ingredientService.shellSmoothie(request)
        );
    }
}
