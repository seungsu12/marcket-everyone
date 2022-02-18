package market.everyone.repository;

import market.everyone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {



    Member save(Member member);

    @Query("select m from member m where m.email = :email")
    boolean existsByEmail(@Param("email")String email);
}
