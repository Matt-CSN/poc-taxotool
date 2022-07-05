package com.decathlon.creation.poctaxotool.TaxonomyMapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum TaxonomyMarketOfferEnum {
    DKT(1, "decathlon", "dkt"),
    AMI(2, "other international brand", "ami"),
    MKT(3, "marketplace", "mkt"),
    UNK(0, "unknow", "unk");

    private Integer id;
    private String name;
    private String trigram;

    private TaxonomyMarketOfferEnum(Integer id, String name, String trigram) {
        this.id = id;
        this.name = name;
        this.trigram = trigram;
    }

    public static TaxonomyMarketOfferEnum getByTrigram(String trigram) {
        for (TaxonomyMarketOfferEnum taxonomyMarketOfferEnum : values()) {
            if (taxonomyMarketOfferEnum.trigram.equals(trigram)) {
                return taxonomyMarketOfferEnum;
            }
        }
        return TaxonomyMarketOfferEnum.UNK;
    }
}
