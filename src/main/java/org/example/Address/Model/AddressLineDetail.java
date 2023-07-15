package org.example.Address.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressLineDetail {
    private String line1;
    private String line2;

    public String toPrettyPrint(){
        return String.format("%s %s", line1,line2);
    }
}
