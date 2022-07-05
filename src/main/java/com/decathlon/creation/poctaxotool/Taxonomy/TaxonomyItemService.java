package com.decathlon.creation.poctaxotool.Taxonomy;

import com.decathlon.creation.poctaxotool.TaxonomyMapper.TaxonomyItemDDFS;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaxonomyItemService {
    @Setter(onMethod = @__({@Autowired}))
    private ITaxonomyItemRepository taxonomyItemRepository;

    public TaxonomyItemEntity createTaxonomyItemEntity(Integer idProductNature, Integer idStructuration, String context, Boolean mandatory, Boolean recommended) throws Exception {
        log.info("POST -- TaxonomyItem for ProductNature={} ; Structuration={} ; context={} ; mandatory={} ; recommended={}", idProductNature, idStructuration, context, mandatory, recommended);
        try {
            return taxonomyItemRepository.save(new TaxonomyItemEntity(idProductNature, idStructuration, context, mandatory, recommended));
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public TaxonomyItemEntity getTaxonomyItemEntity(Long idTaxonomyItem) throws Exception {
        log.info("GET -- TaxonomyItem for id={}", idTaxonomyItem);
        try {
            return taxonomyItemRepository.findById(idTaxonomyItem).get();
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public List<TaxonomyItemEntity> getTaxonomyItemEntitiesByProductNature(Integer productNatureID) throws Exception {
        log.info("GET -- TaxonomyItem for productNatureID={}", productNatureID);
        try {
            return taxonomyItemRepository.findAllByIdProductNature(productNatureID);
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public List<TaxonomyItemDDFS> getTaxonomyItemDDFS(Long idTaxonomyItem) throws Exception {
        log.info("GET -- TaxonomyItem for id={}", idTaxonomyItem);
        try {
            TaxonomyItemEntity taxonomyItemEntity = getTaxonomyItemEntity(idTaxonomyItem);
            TaxonomyItemDDFS taxonomyItemDDFS = TaxonomyItemDDFS.fromTaxonomyItemEntity(taxonomyItemEntity);
            taxonomyItemDDFS.setTaxonomyMarketOfferContextFromTaxonomyItemEntities(List.of(taxonomyItemEntity));
            return List.of(taxonomyItemDDFS);
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public List<TaxonomyItemDDFS> getTaxonomyItemsDDFSByProductNatureID(Integer productNatureID) throws Exception {
        log.info("GET -- TaxonomyItem for productNatureID={}", productNatureID);
        try {
            List<TaxonomyItemEntity> taxonomyItemEntities = getTaxonomyItemEntitiesByProductNature(productNatureID);
            return TaxonomyItemDDFS.fromTaxonomyItemEntities(taxonomyItemEntities);
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }
}
