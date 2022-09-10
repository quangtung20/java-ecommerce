package com.quangtung.springdatajpa.transfrom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressTransform {
    private Long id;

    private String street;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
