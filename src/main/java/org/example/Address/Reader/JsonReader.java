package org.example.Address.Reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.Address.Model.Address;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private final ObjectMapper objectMapper;

    public JsonReader() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Address> getAddresses(File jsonFile) throws IOException {
        return objectMapper.readValue(jsonFile, new TypeReference<List<Address>>() {
        });

    }

}
