package dio.proposal_managemnet.proposal.infastructure.presistence.repository;

import dio.proposal_managemnet.proposal.domain.OwnerId;
import dio.proposal_managemnet.proposal.domain.Proposal;
import dio.proposal_managemnet.proposal.domain.ProposalRepository;
import dio.proposal_managemnet.proposal.infastructure.presistence.Entity.ProposalEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class JpaProposalRepository implements ProposalRepository {
    private final ProposalEntityRepository proposalEntityRepository;

    public JpaProposalRepository(ProposalEntityRepository proposalEntityRepository) {
        this.proposalEntityRepository = proposalEntityRepository;
    }

    @Override
    public List<Proposal> findAll() {
        var interable = proposalEntityRepository.findAll();

         return StreamSupport.stream(interable.spliterator(), false)
                .map(ProposalEntity::toDomain)
                .toList();
    }

    @Override
    public List<Proposal> findByOwnerId(OwnerId ownerId) {

        return proposalEntityRepository.findAllByOwnerId(ownerId.id())
                .stream()
                .map(ProposalEntity::toDomain)
                .toList();
    }

    @Override
    public Proposal save(Proposal proposal) {
        var entity = ProposalEntity.from(proposal);
        var saved = proposalEntityRepository.save(entity);

        return saved.toDomain();
    }
}
