package market.everyone.repository;


import market.everyone.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post,Long> {




    @Query("select p from Post p join fetch p.member")
    List<Post> getPosts();

    @Query("select p from Post p join fetch p.member")
    Optional<Post> findByIdAndName(Long id);

    boolean existsById(Long id);



}
