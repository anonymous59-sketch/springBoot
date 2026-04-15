package com.example.demo.emp;

import lombok.Data;

@Data
public class LocationVO {
	private Integer locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
}
