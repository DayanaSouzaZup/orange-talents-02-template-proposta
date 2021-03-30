package br.com.zup.orange2.proposal.proposal;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javassist.NotFoundException;

@RestController
@RequestMapping("/proposal")
public class NewProposalController {

	private final Logger logger = LoggerFactory.getLogger(NewProposalController.class);
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ProposalRepository proposalRepository;

	
	@Transactional
	public ResponseEntity<?> createNewProposal(@RequestBody @Valid NewProposalDto proposalDto,
			UriComponentsBuilder builder) {

		Proposal newProposal = proposalDto.toModel(manager);

		if (proposalRepository.existsByDocument(newProposal.getDocument())) {
			return ResponseEntity.unprocessableEntity().body("The costumer has already had a proposal");

		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newProposal.getId())
				.toUri();
	
		proposalRepository.save(newProposal);
		return ResponseEntity.created(location).body("Proposal has been created!");

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NewProposalDto> searchId(@PathVariable Long id) throws NotFoundException {
		Proposal proposal = Optional.ofNullable(manager.find(Proposal.class, id)).orElseThrow(() -> 
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Id does not exist"));
		
		return ResponseEntity.ok(new NewProposalDto(proposal));
	}
	

}
