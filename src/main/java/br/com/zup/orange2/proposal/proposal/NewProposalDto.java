package br.com.zup.orange2.proposal.proposal;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NewProposalDto {

	@NotNull
	@Valid
	private String document;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String name;

	@NotNull
	private String address;

	@NotNull
	@Positive
	private BigDecimal salary;

	@Deprecated
	public NewProposalDto() {

	}

//	public NewProposalDto(@NotBlank @Valid String document, @NotBlank @Email String email, @NotBlank String name,
//			@NotBlank String address, @NotBlank @Positive BigDecimal salary) {
//		super();
//		this.document = document;
//		this.email = email;
//		this.name = name;
//		this.address = address;
//		this.salary = salary;
//	}

	public NewProposalDto(Proposal proposal) {
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Proposal toModel(EntityManager manager) {

		return new Proposal(document, email, name, address, salary);
	}

	@Override
	public String toString() {
		return "NewProposalDto [document=" + document + ", email=" + email + ", name=" + name + ", address=" + address
				+ ", salary=" + salary + "]";
	}

	public String getDocument() {
		return document;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

}
