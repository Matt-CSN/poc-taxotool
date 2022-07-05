package com.decathlon.creation.poctaxotool.TaxonomyMapper;

import com.decathlon.creation.poctaxotool.Taxonomy.TaxonomyItemEntity;
import com.decathlon.creation.poctaxotool.Taxonomy.TaxonomyItemService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ddfs")
@Api(tags = "Taxonomy Items DDFS formatted", produces = "application/json")
public class TaxonomyItemDDFSController {
    @Setter(onMethod = @__({@Autowired}))
    private TaxonomyItemService taxonomyItemService;

    @GetMapping(value = "taxonomy-item/{id}")
    @Operation(description = "GET a TAXONOMY ITEM in DDFS format with taxotool ID")
    public ResponseEntity<List<TaxonomyItemDDFS>> getTaxonomyItemDDFS(
            @Parameter(required = true, description = "Taxonomy id", example = "123") @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.getTaxonomyItemDDFS(id));
    }

    @GetMapping(value = "taxonomy-items/{productNatureID}")
    @Operation(description = "GET all TAXONOMY ITEMS in DDFS format with DDFS product nature ID")
    public ResponseEntity<List<TaxonomyItemDDFS>> getTaxonomyItemDDFS(
            @Parameter(required = true, description = "DDFS Product Nature id", example = "11089") @PathVariable("productNatureID") Integer productNatureID) throws Exception {
        return ResponseEntity.ok(taxonomyItemService.getTaxonomyItemsDDFSByProductNatureID(productNatureID));
    }
}
