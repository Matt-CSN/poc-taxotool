package com.decathlon.creation.poctaxotool.Taxonomy;

import com.decathlon.creation.poctaxotool.TaxonomyMapper.TaxonomyItemDDFS;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Taxonomy Items", produces = "application/json")
public class TaxonomyItemController {
    @Setter(onMethod = @__({@Autowired}))
    private TaxonomyItemService taxonomyItemService;

    @PostMapping(value = "taxonomy-item")
    @Operation(description = "CREATE a TAXONOMY ITEM")
    public ResponseEntity<TaxonomyItemEntity> createTaxonomyItem(
            @Parameter(required = true, description = "DDFS product nature id", example = "1234") @RequestParam("productNature") Integer idProductNature,
            @Parameter(required = true, description = "DDFS structuration id", example = "1234") @RequestParam("structuration") Integer idStructuration,
            @Parameter(required = true, description = "DDFS trigram context", example = "dkt") @RequestParam("context") String context,
            @Parameter(required = true, description = "Is this taxonomy mandatory ?", example = "false") @RequestParam("mandatory") Boolean mandatory,
            @Parameter(required = true, description = "Is this taxonomy recomended ?", example = "true") @RequestParam("recomended") Boolean recommended) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.createTaxonomyItemEntity(idProductNature, idStructuration, context, mandatory, recommended));
    }

    @GetMapping(value = "taxonomy-item/{id}")
    @Operation(description = "GET a TAXONOMY ITEM")
    public ResponseEntity<TaxonomyItemEntity> getTaxonomyItem(
            @Parameter(required = true, description = "Taxonomy id", example = "123") @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.getTaxonomyItemEntity(id));
    }

    @GetMapping(value = "DDFS/taxonomy-item/{id}")
    @Operation(description = "GET a TAXONOMY ITEM for DDFS")
    public ResponseEntity<List<TaxonomyItemDDFS>> getTaxonomyItemDDFS(
            @Parameter(required = true, description = "Taxonomy id", example = "123") @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.getTaxonomyItemDDFS(id));
    }

    @GetMapping(value = "DDFS/productNautre/taxonomy-item/{productNatureID}")
    @Operation(description = "GET a TAXONOMY ITEM for DDFS")
    public ResponseEntity<List<TaxonomyItemDDFS>> getTaxonomyItemDDFS(
            @Parameter(required = true, description = "Taxonomy id", example = "123") @PathVariable("productNatureID") Integer productNatureID) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.getTaxonomyItemsDDFSByProductNatureID(productNatureID));
    }
}
