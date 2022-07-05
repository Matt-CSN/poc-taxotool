package com.decathlon.creation.poctaxotool.TaxonomyMapper;

import com.decathlon.creation.poctaxotool.Taxonomy.TaxonomyItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaxonomyItemDDFS {
    private Long id;
    private Integer productNatureID;
    private String status;

    private StructuredCharacteristicType structuredCharacteristicType;

    @Builder.Default
    private List<TaxonomyMarketOfferContext> taxonomyMarketOfferContexts = new ArrayList<>();

    public static TaxonomyItemDDFS fromTaxonomyItemEntity(TaxonomyItemEntity taxonomyItemEntity) {
        return TaxonomyItemDDFS.builder()
                .id(taxonomyItemEntity.getId())
                .productNatureID(taxonomyItemEntity.getIdProductNature())
                .status("active")
                .structuredCharacteristicType(new StructuredCharacteristicType(taxonomyItemEntity.getIdStructuration()))
                .build();
    }

    public static List<TaxonomyItemDDFS> fromTaxonomyItemEntities(List<TaxonomyItemEntity> taxonomyItemEntities) {
        List<TaxonomyItemDDFS> taxonomyItemsDDFS = new ArrayList<>();
        Map<Integer, List<TaxonomyItemEntity>> taxonomyItemEntitiesMap = convertToProductNatureMapList(taxonomyItemEntities);
        List<Integer> productNatureIDs = new ArrayList<>();
        taxonomyItemEntitiesMap.forEach(((productNatureID, taxonomyItemsEntities) -> {
            if (!productNatureIDs.contains(productNatureID) && !taxonomyItemsEntities.isEmpty()) {
                productNatureIDs.add(productNatureID);
                taxonomyItemsDDFS.add(TaxonomyItemDDFS.fromTaxonomyItemEntity(taxonomyItemsEntities.get(0)));
            }
            taxonomyItemsDDFS
                    .forEach(taxonomyItemDDFS -> taxonomyItemDDFS.setTaxonomyMarketOfferContextFromTaxonomyItemEntities(taxonomyItemEntitiesMap.get(taxonomyItemDDFS.getProductNatureID())));
        }));
        return taxonomyItemsDDFS;
    }

    private static Map<Integer, TaxonomyItemEntity> convertToProductNatureMap(List<TaxonomyItemEntity> taxonomyItemEntities) {
        return taxonomyItemEntities.stream()
                .collect(Collectors.toMap(TaxonomyItemEntity::getIdProductNature, Function.identity()));
    }

    public static Map<Integer, List<TaxonomyItemEntity>> convertToProductNatureMapList(List<TaxonomyItemEntity> taxonomyItemEntities) {
        return taxonomyItemEntities.stream().collect(
                Collectors.groupingBy(TaxonomyItemEntity::getIdProductNature, HashMap::new, Collectors.toCollection(ArrayList::new))
        );
    }

    public void setTaxonomyMarketOfferContextFromTaxonomyItemEntities(List<TaxonomyItemEntity> taxonomyItemEntities) {
        List<TaxonomyMarketOfferContext> taxonomyMarketOfferContexts = new ArrayList<>();
        taxonomyItemEntities.forEach(taxonomyItemEntity -> {
            if (taxonomyItemEntity.getIdProductNature().equals(this.productNatureID)) {
                taxonomyMarketOfferContexts.add(TaxonomyMarketOfferContext.formTaxonomyItemEntity(taxonomyItemEntity));
            }
        });
        this.taxonomyMarketOfferContexts = taxonomyMarketOfferContexts;
    }

    public void addTaxonomyMarketOfferContextFromTaxonomyItemEntity(TaxonomyItemEntity taxonomyItemEntity) {
        if (Objects.equals(taxonomyItemEntity.getId(), this.id)) {
            this.taxonomyMarketOfferContexts.add(TaxonomyMarketOfferContext.formTaxonomyItemEntity(taxonomyItemEntity));
        }
    }
}
