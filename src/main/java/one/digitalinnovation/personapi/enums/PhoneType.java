package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE( "Mobile"),
    COMERCIAL( "Comercial");


    private final String description;

}
