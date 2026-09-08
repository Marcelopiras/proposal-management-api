package dio.proposal_managemnet.proposal.application;

import dio.proposal_managemnet.proposal.application.List.AccessScope;
import dio.proposal_managemnet.proposal.application.List.Factory;
import dio.proposal_managemnet.proposal.application.output.ProposalOutput;
import dio.proposal_managemnet.proposal.domain.OwnerId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProposalUseCase {
    private final Factory factory;

    public ListProposalUseCase(Factory factory) {
        this.factory = factory;
    }

    public List<ProposalOutput> execute(AccessScope scope, OwnerId ownerId) {
        var proposals = factory.getStrategy(scope).getProposals(ownerId);

        return proposals.stream().map(ProposalOutput::from).toList();
    }
}
