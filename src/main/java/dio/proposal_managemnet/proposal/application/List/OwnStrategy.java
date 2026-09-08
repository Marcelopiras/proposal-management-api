package dio.proposal_managemnet.proposal.application.List;

import dio.proposal_managemnet.proposal.domain.OwnerId;
import dio.proposal_managemnet.proposal.domain.Proposal;
import dio.proposal_managemnet.proposal.domain.ProposalRepository;

import java.util.List;

public class OwnStrategy implements Strategy {
    private final ProposalRepository proposalRepository;

    public OwnStrategy(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public List<Proposal> getProposals(OwnerId ownerId) {
        return proposalRepository.findByOwnerId(ownerId);
    }

    @Override
    public AccessScope getScope() {
        return AccessScope.OWN;
    }
}
