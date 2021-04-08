package br.com.zup.orange2.proposal.proposal;

import javax.validation.constraints.NotBlank;

public class AddressDto {

	@NotBlank
	private String address;

	@NotBlank
	private String number;

	@NotBlank
	private String neighbourhood;

	@NotBlank
	private String zipCode;

	@Deprecated
	public AddressDto() {

	}

	public AddressDto(@NotBlank String address, @NotBlank String number, @NotBlank String neighbourhood,
			@NotBlank String zipCode) {
		super();
		this.address = address;
		this.number = number;
		this.neighbourhood = neighbourhood;
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public String getNumber() {
		return number;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Address toModel() {
		return new Address(this.address, this.neighbourhood, this.number, this.zipCode);

	}

}
