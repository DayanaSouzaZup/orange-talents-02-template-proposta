package br.com.zup.orange2.proposal.analysis;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "analysis", url = "${analysis.targetUrl}")
public interface CustomerAnalysis {
	
	@PostMapping("/proposal/request")
	@Transactional
	ProposalAnalysisResponse underAnalysis (@RequestBody @Valid ProposalAnalysisDto analysisDto);

}
