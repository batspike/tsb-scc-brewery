package com.samcancode.web.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDto extends BaseItem {

    @Builder
    public CustomerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, String name,
                       List<CreditCardDto> creditCards) {
        super(id, version, createdDate, lastModifiedDate);
        this.name = name;
        this.creditCards = creditCards;
    }

    private String name;
    private List<CreditCardDto> creditCards;
}