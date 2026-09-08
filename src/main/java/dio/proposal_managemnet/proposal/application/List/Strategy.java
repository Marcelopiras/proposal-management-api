package dio.proposal_managemnet.proposal.application.List;

import dio.proposal_managemnet.proposal.domain.Owner;
import dio.proposal_managemnet.proposal.domain.OwnerId;
import dio.proposal_managemnet.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposals(OwnerId ownerId);
    AccessScope getScope();
}
