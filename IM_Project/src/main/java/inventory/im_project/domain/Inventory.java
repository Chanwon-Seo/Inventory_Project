package inventory.im_project.domain;

import inventory.im_project.controller.form.InventoryForm;
import inventory.im_project.controller.form.MemberForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inventory {

    @Id
    @GeneratedValue
    @Column(name = "inventory_id")
    private Long id;

    private String name;

    @Column(updatable = false)
    private LocalDateTime createDate;

    private LocalDateTime updateDate;
    private int count;
    private int price;

    public Inventory(InventoryForm form) {
        this.name = form.getName();
        this.count = form.getCount();
        this.price = form.getPrice();
    }

    public Inventory(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        updateDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }
}
