package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public enum PhoneType {

    HOME(description: "Home"),
    MOBILE(description: "Mobile"),
    COMERCIAL(description: "Comercial");


    private final String description;

}
