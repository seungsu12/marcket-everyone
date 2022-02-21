package market.everyone.repository;

import market.everyone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<User,Long> {

    @Query("select m from User m where m.id = :id")
    Optional<User> findById(@Param("id") Long id);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    void deleteById(Long id);
}
