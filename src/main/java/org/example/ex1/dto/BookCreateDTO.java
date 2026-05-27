package org.example.ex1.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookCreateDTO {
    @NotBlank(message = "Name must be don't Empty !!")
    private String name;

    @NotBlank(message = "Category must be don't Empty !!")
    private String category;

    @NotBlank(message = "author must be don't Empty !!")
    private String author;

    @NotNull(message = "price must be don't Empty !!")
    @Min(value = 0, message = "Price must be min 0 !")
    private Double price;
}
