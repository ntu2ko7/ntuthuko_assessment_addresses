package org.example.address.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressLineDetailTest {
    @Test
    public void testIsValidAddressLineDetailWhenLine1IsNull() {
        AddressLineDetail addressLineDetail = new AddressLineDetail();
        addressLineDetail.setLine2("line2");

        assertTrue(addressLineDetail.isValidAddressLineDetail());
    }

    @Test
    public void testIsValidAddressLineDetailWhenLine2IsNull() {
        AddressLineDetail addressLineDetail = new AddressLineDetail();
        addressLineDetail.setLine1("line1");

        assertTrue(addressLineDetail.isValidAddressLineDetail());
    }

    @Test
    public void testIsValidAddressLineDetailWhenBothLinesAreNull() {
        AddressLineDetail addressLineDetail = new AddressLineDetail();

        assertFalse(addressLineDetail.isValidAddressLineDetail());
    }

    @Test
    public void testIsValidAddressLineDetailWhenBothLinesAreNotNull() {
        AddressLineDetail addressLineDetail = new AddressLineDetail();
        addressLineDetail.setLine1("line1");
        addressLineDetail.setLine2("line2");

        assertTrue(addressLineDetail.isValidAddressLineDetail());
    }
}
