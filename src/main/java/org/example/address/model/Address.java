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


    public String getInvalidFields(Address address) {
        StringBuilder stringBuilder = new StringBuilder();
        if (address.getPostalCode() == null || !address.getPostalCode().matches("\\d+")) {
            stringBuilder.append("Postal code is invalid. ");
        }
        if (address.getCountry() == null) {
            stringBuilder.append("Country is invalid. ");
        }
        if (address.getCountry() != null) {
            if (Optional.ofNullable(address.getCountry().getCode()).map(code -> code.equals("ZA")).orElse(false) &&
                    !Optional.ofNullable(address.getProvinceOrState())
                            .map(ProvinceOrState::isValidProvinceOrState)
                            .orElse(false)) {
                stringBuilder.append("Province or state is invalid. Province is required for South Africa. ");
            }
        }
        if (address.getAddressLineDetail() == null || !address.getAddressLineDetail().isValidAddressLineDetail()) {
            stringBuilder.append("Address detail is invalid. At least one line is required.");
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
