package org.example.Address;

import org.example.Address.Model.Address;

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
