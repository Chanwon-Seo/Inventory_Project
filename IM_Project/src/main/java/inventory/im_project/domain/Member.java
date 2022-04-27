package inventory.im_project.domain;

import inventory.im_project.controller.form.MemberForm;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String userId;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Address> addresses = new ArrayList<>();

    public Member(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public Member(MemberForm form) {
        this.name = form.getName();
        this.userId = form.getUser_id();
        this.password = form.getPassword();
    }
}
