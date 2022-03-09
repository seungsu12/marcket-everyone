package market.everyone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    public Item(String itemName, ItemType type) {
        this.itemName = itemName;
        this.type = type;
    }

    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemType type;
}
