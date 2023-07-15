package org.example.Address.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
public class Address {
    private String id;
    private Type type;
    private AddressLineDetail addressLineDetail;
    private ProvinceOrState provinceOrState;
    private String cityOrTown;
    private Country country;
    private String postalCode;
    private LocalDateTime lastUpdated;
    private String suburbOrDistrict;

    public String toPrettyPrint() {
        return String.format("Type: %s%s%s%s%s%s",
                getType().getName(),
                Optional.ofNullable(getAddressLineDetail())
                        .map(addressLineDetail -> " - " + addressLineDetail.toPrettyPrint())
                        .orElse(""),
                Optional.ofNullable(getCityOrTown())
                        .map(cityOrTown -> " - " + cityOrTown)
                        .orElse(""),
                Optional.ofNullable(getProvinceOrState())
                        .map(provinceOrState -> " - " + provinceOrState.getName())
                        .orElse(""),
                Optional.ofNullable(getPostalCode())
                        .map(postalCode -> " - " + postalCode)
                        .orElse(""),
                Optional.ofNullable(getCountry())
                        .map(country -> " - " + country.getName())
                        .orElse(""));
    }
}
