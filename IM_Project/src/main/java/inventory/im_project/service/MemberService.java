package inventory.im_project.service;

import inventory.im_project.controller.MemberForm;
import inventory.im_project.controller.MemberLoginForm;
import inventory.im_project.domain.Address;
import inventory.im_project.domain.Member;
import inventory.im_project.repository.AddressRepository;
import inventory.im_project.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private final AddressRepository addressRepository;

    @Transactional
    public Long join(MemberForm form) {

        validateDuplicateMember(form); //중복 회원 검증

        Address address = new Address(form);
        Member member = new Member(form);

        address.setMember(member);

        memberRepository.save(member);
        addressRepository.save(address);

        return member.getId();
    }

    private void validateDuplicateMember(MemberForm form) {
        List<Member> findMembers = memberRepository.findByName(form.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다"); //프론트
        }
    }

    /**
     * 사용자 정보 검출
     */

    public int login(MemberLoginForm loginForm, String userId) {
        Optional<Member> result = memberRepository.findByUserId(userId);

        System.out.println(result.get().getUserId());
        System.out.println(result.get().getPassword());

        /**
         * 참이 나오면 비어있다.
         * false나오면 데이터가 있다.
         */
        if (!result.isEmpty()) {
            if (result.get().getPassword().equals(loginForm.getPassword())) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

}
