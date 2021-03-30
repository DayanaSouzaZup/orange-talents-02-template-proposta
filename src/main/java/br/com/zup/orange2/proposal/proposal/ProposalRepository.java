package br.com.zup.orange2.proposal.proposal;

import org.springframework.data.repository.CrudRepository;

public interface ProposalRepository extends CrudRepository<Proposal, Long> {

	boolean existsByDocument(String document);

	Proposal findByDocument(String document);
}
