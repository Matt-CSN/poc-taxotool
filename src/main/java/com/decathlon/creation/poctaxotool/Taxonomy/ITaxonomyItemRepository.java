package com.decathlon.creation.poctaxotool.Taxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ITaxonomyItemRepository extends JpaRepository<TaxonomyItemEntity, Long>,
        QueryByExampleExecutor<TaxonomyItemEntity>, JpaSpecificationExecutor<TaxonomyItemEntity> {
}
