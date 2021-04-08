package br.com.zup.orange2.proposal.proposal;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {

	@NotBlank
	private String address;

	@NotBlank
	private String number;

	@NotBlank
	private String neighbourhood;

	@NotBlank
	private String zipCode;

	@Deprecated
	public Address() {

	}

	public Address(@NotBlank String address, @NotBlank String number, @NotBlank String neighbourhood,
			@NotBlank String zipCode) {
		super();
		this.address = address;
		this.number = number;
		this.neighbourhood = neighbourhood;
		this.zipCode = zipCode;
	}

}
