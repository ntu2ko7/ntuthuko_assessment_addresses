package org.example.address.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    public void testGetInvalidFieldsWhenPostalCodeIsNull() {
        Address address = new Address();
        address.setCountry(new Country());
        address.setAddressLineDetail(new AddressLineDetail());

        String expected = "Postal code is invalid.";
        String actual = address.getInvalidFields();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void testGetInvalidFieldsWhenPostalCodeIsNotNumeric() {
        Address address = new Address();
        address.setPostalCode("abc");
        address.setCountry(new Country());
        address.setAddressLineDetail(new AddressLineDetail());

        String expected = "Postal code is invalid. ";
        String actual = address.getInvalidFields();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void testGetInvalidFieldsWhenCountryIsNull() {
        Address address = new Address();
        address.setPostalCode("12345");
        address.setAddressLineDetail(new AddressLineDetail());

        String expected = "Country is invalid. ";
        String actual = address.getInvalidFields();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void testGetInvalidFieldsWhenCountryIsSouthAfricaAndProvinceOrStateIsNull() {
        Address address = new Address();
        address.setId("1");
        Country country = new Country();
        country.setCode("ZA");
        address.setPostalCode("12345");
        address.setCountry(country);
        AddressLineDetail detail = new AddressLineDetail();
        detail.setLine1("366 Kent Ave");
        address.setAddressLineDetail(detail);

        String expected = "Address 1: Province or state is invalid. Province is required for South Africa. ";
        String actual = address.getInvalidFields();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetInvalidFieldsWhenAddressLineDetailIsNull() {
        Address address = new Address();
        address.setId("1");
        Country country = new Country();
        country.setCode("ZA");
        ProvinceOrState provinceOrState = new ProvinceOrState();
        provinceOrState.setName("valid");
        provinceOrState.setCode("valid");
        address.setPostalCode("12345");
        address.setCountry(country);
        address.setProvinceOrState(provinceOrState);

        String expected = "Address 1: Address detail is invalid. At least one line is required.";
        String actual = address.getInvalidFields();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetInvalidFieldsWhenAddressLineDetailIsNotValid() {
        AddressLineDetail detail = new AddressLineDetail();
        detail.setLine1(null);
        detail.setLine2(null);

        Address address = new Address();
        address.setId("1");
        address.setPostalCode("12345");
        address.setCountry(new Country());
        address.setAddressLineDetail(detail);

        String expected = "Address 1: Address detail is invalid. At least one line is required.";
        String actual = address.getInvalidFields();

        assertEquals(expected, actual);
    }

}