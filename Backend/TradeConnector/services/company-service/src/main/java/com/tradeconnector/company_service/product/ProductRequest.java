package com.tradeconnector.company_service.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        Integer id,
        @NotNull
        @NotEmpty
        String name,
        @NotNull
        @NotEmpty
        String price,
        String stock,
        String description,
        Integer company_id

) {
}
