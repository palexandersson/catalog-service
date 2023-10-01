package com.polarbookshop.catalogservice.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "ISBN cannot be blank")
        String isbn,
        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotBlank(message = "Author cannot be blank")
        String author,
        @NotNull(message = "The book price must be defined.")
        @Positive(message = "Book price must be greater than zero.")
        Double price
) {
}
