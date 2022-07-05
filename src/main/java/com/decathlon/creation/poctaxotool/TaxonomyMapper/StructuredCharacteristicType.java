package com.decathlon.creation.poctaxotool.TaxonomyMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StructuredCharacteristicType {
    private Integer id;
    private String name = "Stucturation name in DDFS";

    StructuredCharacteristicType(Integer id) {
        this.id = id;
    }
}
