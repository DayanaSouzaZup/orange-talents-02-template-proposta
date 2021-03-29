package br.com.zup.orange2.proposal.proposal;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.orange2.proposal.validation.CpfCnpj;

@Entity
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Valid
	@CpfCnpj
	@Column(unique = true)
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
	public Proposal() {

	}

	public Proposal(@NotBlank @Valid String document, @NotBlank @Email String email, @NotBlank String name,
			@NotBlank String address, @NotBlank @Positive BigDecimal salary) {
		super();
		this.document = document;
		this.email = email;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Proposal [documento=" + document + ", email=" + email + ", name=" + name + ", address=" + address
				+ ", salary=" + salary + "]";
	}

	public Long getId() {
		return id;
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
