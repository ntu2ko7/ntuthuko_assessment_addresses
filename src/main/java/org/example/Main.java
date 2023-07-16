package org.example;

import org.example.address.model.Address;
import org.example.address.reader.JsonReader;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            testInvalidAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testInvalidAddress() throws Exception {
        File file = new File("src/test/resources/addresses.json");
        List<Address> addresses = new JsonReader().getAddresses(file);

        for (Address address : addresses) {
            System.out.println(address.getInvalidFields());
        }
    }
}