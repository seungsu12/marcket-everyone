package market.everyone.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;


}
