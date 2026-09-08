package dio.proposal_managemnet.proposal.application.List;


import dio.proposal_managemnet.proposal.domain.OwnerId;
import dio.proposal_managemnet.proposal.domain.Proposal;
import dio.proposal_managemnet.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllStrategy implements Strategy {
    private final ProposalRepository proposalRepository;

    public AllStrategy(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }
    @Override
    public List<Proposal> getProposals(OwnerId ownerId) {
        return proposalRepository.findAll();
    }

    @Override
    public AccessScope getScope() {
        return null;
    }
}
