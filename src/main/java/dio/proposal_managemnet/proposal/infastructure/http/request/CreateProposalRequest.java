package dio.proposal_managemnet.proposal.infastructure.http.request;

import dio.proposal_managemnet.proposal.application.input.CreateProposalInput;

import java.util.Optional;

public record CreateProposalRequest(String title, Optional<String> description) {
    public CreateProposalInput toInput(){
        return new CreateProposalInput(title, description);
    }
}
