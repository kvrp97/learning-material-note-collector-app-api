package lk.acpt.notecollectorapp.repo;

import lk.acpt.notecollectorapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User getUserByEmailAddress(String emailAddress);

    boolean existsByEmailAddress(String emailAddress);
}
