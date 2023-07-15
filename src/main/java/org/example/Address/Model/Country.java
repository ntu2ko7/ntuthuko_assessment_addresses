package org.example.Address.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String code;
    private String name;
    public String toPrettyPrint(){
        return String.format("%s %s", code,name);
    }


}
