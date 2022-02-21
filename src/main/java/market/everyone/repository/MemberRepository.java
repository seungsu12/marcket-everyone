package market.everyone.repository;

import market.everyone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("select u from Member u where u.id = :id")
    Optional<Member> findById(@Param("id") Long id);

    Boolean existsByEmail(String email);

    Optional<Member> findByEmail(String email);

    void deleteById(Long id);
}