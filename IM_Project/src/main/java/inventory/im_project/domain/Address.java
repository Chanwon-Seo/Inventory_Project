package inventory.im_project.domain;

import inventory.im_project.controller.MemberForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    protected Address() {
    }

    public Address(MemberForm form) {
        this.city = form.getCity();
        this.street = form.getStreet();
        this.zipcode = form.getZipcode();
    }

    //==연관관계 편의 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getAddresses().add(this);
    }
}
