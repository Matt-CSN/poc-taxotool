package com.decathlon.creation.poctaxotool.Taxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ITaxonomyItemRepository extends JpaRepository<TaxonomyItemEntity, Long>,
        QueryByExampleExecutor<TaxonomyItemEntity>, JpaSpecificationExecutor<TaxonomyItemEntity> {
    List<TaxonomyItemEntity> findAllByIdProductNature(Integer productNatureID);
}
