package org.example.address;

import org.example.address.model.Address;
import org.example.address.reader.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressPrinterTest {

    @Test
    public void testPrettyPrintAddress() throws IOException {
        File file = new File("src/test/resources/addresses.json");
        List<Address> addresses = new JsonReader().getAddresses(file);
        Address address = addresses.get(0);
        AddressPrinter addressPrinter = new AddressPrinter();
        String result = addressPrinter.prettyPrintAddress(address);
        String expected = "Type: Physical Address - Address 1 Line 2 - City 1 - Eastern Cape - 1234 - South Africa";
        assertEquals(expected, result);
    }

    @Test
    public void testPrettyPrintAddresses() throws IOException {
        File file = new File("src/test/resources/addresses.json");
        List<Address> addresses = new JsonReader().getAddresses(file);
        AddressPrinter addressPrinter = new AddressPrinter();
        String result = addressPrinter.prettyPrintAddresses(addresses);
        String expected = "Type: Physical Address - Address 1 Line 2 - City 1 - Eastern Cape - 1234 - South Africa\n" +
                "Type: Postal Address - City 2 - 2345 - Lebanon\n" +
                "Type: Business Address - Address 3  - City 3 - 3456 - South Africa\n";
        Assertions.assertEquals(expected, result);
    }
}