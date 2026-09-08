package dio.proposal_managemnet.auth.infrastructure.persistence.entity.repository;

import org.springframework.data.repository.CrudRepository;
import dio.proposal_managemnet.auth.infrastructure.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
