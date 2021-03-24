package br.com.zup.orange2.proposal.proposal;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewProposalController {

	private final Logger logger = LoggerFactory.getLogger(NewProposalController.class);
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ProposalRepository proposalRepository;

	@PostMapping("/proposals")
	@Transactional
	public ResponseEntity<?> createNewProposal(@RequestBody @Valid NewProposalDto proposalDto,
			UriComponentsBuilder builder) {

		Proposal newProposal = proposalDto.toModel(manager);
		URI consultAddress = builder.path("/proposals/{id}").build(newProposal.getId());

		if (!proposalRepository.existsByDocument(newProposal.getDocument())) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);

		}

		manager.persist(newProposal);
		logger.info("Proposal has been succefully created");
		return ResponseEntity.created(consultAddress).build();

	}

}
