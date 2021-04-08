package br.com.zup.orange2.proposal.biometrics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zup.orange2.proposal.card.Card;

@Entity
public class Biometrics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Card card;

	@NotBlank
	private String fingerprint;

	@Deprecated
	public Biometrics() {

	}

	public Biometrics(Card card, @NotBlank String fingerprint) {
		super();
		this.card = card;
		this.fingerprint = fingerprint;
	}

	public Long getId() {
		return id;
	}

}
