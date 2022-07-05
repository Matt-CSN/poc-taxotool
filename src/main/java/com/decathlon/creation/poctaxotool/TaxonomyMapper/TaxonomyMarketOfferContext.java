package com.decathlon.creation.poctaxotool.TaxonomyMapper;

import com.decathlon.creation.poctaxotool.Taxonomy.TaxonomyItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaxonomyMarketOfferContext {
    private Long id;
    private Integer viewOrder;
    private Boolean mandatory;
    private Boolean recommended;
    private TaxonomyMarketOfferEnum taxonomyMarketOffer;

    public static TaxonomyMarketOfferContext formTaxonomyItemEntity(TaxonomyItemEntity taxonomyItemEntity) {
        return TaxonomyMarketOfferContext.builder()
                .id(taxonomyItemEntity.getId())
                .viewOrder(1)
                .mandatory(taxonomyItemEntity.getMandatory())
                .recommended(taxonomyItemEntity.getRecommended())
                .taxonomyMarketOffer(TaxonomyMarketOfferEnum.getByTrigram(taxonomyItemEntity.getContextTrigram()))
                .build();
    }
}
