package org.example.address.reader;

import org.example.address.model.Address;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonReaderTest {
    private final JsonReader jsonReader = new JsonReader();

    @Test
    public void testGetAddresses() throws Exception {
        File file = new File("src/test/resources/addresses.json");
        List<Address> addresses = jsonReader.getAddresses(file);
        assertEquals(3, addresses.size());

    }
}
