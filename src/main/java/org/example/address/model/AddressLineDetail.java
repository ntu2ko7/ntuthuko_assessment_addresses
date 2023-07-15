package org.example.address.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressLineDetail {
    private String line1;
    private String line2;


    public String toPrettyPrint() {
        return String.format("%s %s", line1, line2);
    }

    public boolean isValidAddressLineDetail() {
        return line1 != null || line2 != null;
    }
}
