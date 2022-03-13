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


    @GeneratedValue
    @Column(name = "item_id")
    @Id
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemType type;


    @Embedded
    private UploadFile attachFile;
}
