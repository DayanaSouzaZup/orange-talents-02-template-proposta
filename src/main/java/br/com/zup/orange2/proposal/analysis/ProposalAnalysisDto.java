package br.com.zup.orange2.proposal.analysis;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.orange2.proposal.proposal.Proposal;
import br.com.zup.orange2.proposal.validation.CpfCnpj;

public class ProposalAnalysisDto {

	@NotBlank
	@CpfCnpj
	@JsonProperty("Document")
	private String document;

	@NotBlank
	@JsonProperty("Name")
	private String name;

	@NotBlank
	@JsonProperty("idProposal")
	private String idProposal;

	public ProposalAnalysisDto(@NotBlank String document, @NotBlank String name, @NotBlank String idProposal) {

	}

	public ProposalAnalysisDto(@Valid @NotNull Proposal newProposal) {
		this.document = newProposal.getDocument();
		this.name = newProposal.getName();
		this.idProposal = newProposal.getId().toString();
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getIdProposal() {
		return idProposal;
	}

}
