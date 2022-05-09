package com.example.im_project.domain;

import com.example.im_project.controller.form.MemberForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String userId;
    private String password;
    private String role; //ROLE_USER, ROLE_ADMIN

    @OneToMany(mappedBy = "member")
    private List<Address> addresses = new ArrayList<>();

    public Member(MemberForm form) {
        this.username = form.getUsername();
        this.userId = form.getUserId();
        this.password = form.getPassword();
    }
}
