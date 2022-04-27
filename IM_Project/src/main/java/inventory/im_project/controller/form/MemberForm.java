package inventory.im_project.controller.form;

import inventory.im_project.domain.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    //회원이름
    @NotEmpty(message = "정보를 입력해주세요")
    private String name;

    //회원정보
    @NotEmpty(message = "정보를 입력해주세요")
    private String user_id;

    @NotEmpty(message = "정보를 입력해주세요")
    private String password;
    
    //주소 정보
    @NotEmpty(message = "정보를 입력해주세요")
    private String city;
    @NotEmpty(message = "정보를 입력해주세요")
    private String zipcode;
    @NotEmpty(message = "정보를 입력해주세요")
    private String street;

}
