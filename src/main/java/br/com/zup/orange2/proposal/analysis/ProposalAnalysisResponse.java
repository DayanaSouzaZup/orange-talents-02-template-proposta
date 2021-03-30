package br.com.zup.orange2.proposal.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.orange2.proposal.enums.ProposalStatus;

public class ProposalAnalysisResponse {

	@JsonProperty("Dcoument")
	private String document;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("idProposal")
	private String idProposal;

	@JsonProperty("analysisResult")
	private String analysisResult;

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getIdProposal() {
		return idProposal;
	}

	public String getAnalysisResult() {
		return analysisResult;
	}

	public ProposalStatus verifyStatus() {
		if ("COM_RESTRICAO".equals(analysisResult)) {
			return ProposalStatus.NOT_ELIGIBLE;
		}

		return ProposalStatus.ELIGIBLE;
	}
}
