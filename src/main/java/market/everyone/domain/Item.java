package market.everyone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {


    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemType type;
}
