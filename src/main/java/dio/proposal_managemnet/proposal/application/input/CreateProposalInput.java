package dio.proposal_managemnet.proposal.application.input;

import dio.proposal_managemnet.proposal.domain.Owner;
import dio.proposal_managemnet.proposal.domain.Proposal;

import java.util.Optional;

public record CreateProposalInput(String title, Optional<String> description) {
    public Proposal toDomain(Owner owner) {
        return new Proposal(title, description, owner);
    }
}
