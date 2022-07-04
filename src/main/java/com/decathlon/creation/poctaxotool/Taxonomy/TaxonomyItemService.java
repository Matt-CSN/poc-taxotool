package com.decathlon.creation.poctaxotool.Taxonomy;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaxonomyItemService {
    @Setter(onMethod = @__({@Autowired}))
    private ITaxonomyItemRepository taxonomyItemRepository;

    public TaxonomyItemEntity createTaxonomyItemEntity(Long idProductNature, Long idStructuration, String context, Boolean mandatory, Boolean recommended) throws Exception {
        log.info("POST -- TaxonomyItem for ProductNature={} ; Structuration={} ; context={} ; mandatory={} ; recommended={}",  idProductNature,  idStructuration,  context,  mandatory,  recommended);
        try {
            return taxonomyItemRepository.save(new TaxonomyItemEntity(idProductNature,  idStructuration,  context,  mandatory,  recommended));
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public TaxonomyItemEntity getTaxonomyItemEntity(Long idTaxonomyItem) throws Exception {
        log.info("GET -- TaxonomyItem for id={}",  idTaxonomyItem);
        try {
            return taxonomyItemRepository.findById(idTaxonomyItem).get();
        } catch (Exception exception) {
            log.error("Error -- ", exception);
            throw new Exception(exception.getMessage());
        }
    }
}
