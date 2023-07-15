package org.example.address.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceOrState {
    private String code;
    private String name;

    public boolean isValidProvinceOrState() {
        return code != null && name != null;
    }
}
