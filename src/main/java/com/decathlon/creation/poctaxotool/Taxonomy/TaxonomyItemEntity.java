package com.decathlon.creation.poctaxotool.Taxonomy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "taxonomy")
public class TaxonomyItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProductNature;
    private Long idStructuration;
    private String contextTrigram;
    private Boolean mandatory;
    private Boolean recommended;

    public TaxonomyItemEntity(Long idProductNature, Long idStructuration, String context, Boolean mandatory, Boolean recommended) {
        this.idProductNature = idProductNature;
        this.idStructuration = idStructuration;
        this.contextTrigram = context;
        this.mandatory = mandatory;
        this.recommended = recommended;

    }
}
