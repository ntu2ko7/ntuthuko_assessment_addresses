package org.example.address;

import org.example.address.model.Address;

import java.util.List;

public class AddressPrinter {

    public String prettyPrintAddress(Address address) {
        return address.toPrettyPrint();
    }

    public String prettyPrintAddresses(List<Address> addresses) {
        StringBuilder stringBuilder = new StringBuilder();
        addresses.forEach(address -> stringBuilder.append(prettyPrintAddress(address)).append("\n"));
        return stringBuilder.toString();
    }

}
