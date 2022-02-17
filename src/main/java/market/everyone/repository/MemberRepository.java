package market.everyone.repository;

import market.everyone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Long save(Member member);


}
