package dio.proposal_managemnet.proposal.application;

import dio.proposal_managemnet.proposal.application.input.CreateProposalInput;
import dio.proposal_managemnet.proposal.application.output.ProposalOutput;
import dio.proposal_managemnet.proposal.domain.Owner;
import dio.proposal_managemnet.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }
    public ProposalOutput execute(CreateProposalInput input, Owner owner) {
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);

        return ProposalOutput.from(saved);

    }
}
