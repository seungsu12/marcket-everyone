package market.everyone.repository;


import market.everyone.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post,Long> {


    @Query("select p from Post p where p.id =:id ")
    Optional<Post> findById(@Param("id")Long id);


}
