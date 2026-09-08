package dio.proposal_managemnet.proposal.infastructure.presistence.repository;

import dio.proposal_managemnet.proposal.infastructure.presistence.Entity.ProposalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProposalEntityRepository extends CrudRepository<ProposalEntity, UUID> {
    List<ProposalEntity> findAllByOwnerId(UUID ownerId);

}
