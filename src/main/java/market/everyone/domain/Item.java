package market.everyone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {


    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @OneToOne(mappedBy = "item")
    private Post post;

    @OneToOne(mappedBy = "item")
    private Order order;

    @Enumerated(EnumType.STRING)
    private ItemType type;


    @Embedded
    private UploadFile attachFile;
}
