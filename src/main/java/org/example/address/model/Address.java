package org.example.address.model;

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


    public String getInvalidFields() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getPostalCode() == null || !getPostalCode().matches("\\d+")) {
            stringBuilder.append("Postal code is invalid. ");
        }
        if (getCountry() == null) {
            stringBuilder.append("Country is invalid. ");
        }
        if (getCountry() != null) {
            if (Optional.ofNullable(getCountry().getCode()).map(code -> code.equals("ZA")).orElse(false) &&
                    !Optional.ofNullable(getProvinceOrState())
                            .map(ProvinceOrState::isValidProvinceOrState)
                            .orElse(false)) {
                stringBuilder.append("Province or state is invalid. Province is required for South Africa. ");
            }
        }
        if (getAddressLineDetail() == null || !getAddressLineDetail().isValidAddressLineDetail()) {
            stringBuilder.append("Address detail is invalid. At least one line is required.");
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.insert(0, String.format("Address %s: ", getId()));
        }
        return stringBuilder.toString();
    }

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
