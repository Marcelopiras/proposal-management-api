package dio.proposal_managemnet.proposal.domain;

import java.util.List;

public interface ProposalRepository {
    List<Proposal> findAll();
    List<Proposal> findByOwnerId(OwnerId ownerId);
    Proposal save(Proposal proposal);
}
