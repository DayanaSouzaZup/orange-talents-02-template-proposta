package br.com.zup.orange2.proposal.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zup.orange2.proposal.proposal.Proposal;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cardNumber;

	private LocalDateTime issuedIn;

	private BigDecimal limit;

	@OneToOne
	private Proposal proposal;

	@Deprecated
	public Card() {

	}

	public Card(String cardNumber, LocalDateTime issuedIn, BigDecimal limit, Proposal proposal) {
		super();
		this.cardNumber = cardNumber;
		this.issuedIn = issuedIn;
		this.limit = limit;
		this.proposal = proposal;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", issuedIn=" + issuedIn + ", limit=" + limit + ", proposal="
				+ proposal + "]";
	}

}
