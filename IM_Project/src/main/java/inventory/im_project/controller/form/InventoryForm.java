package inventory.im_project.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class InventoryForm {

    //회원이름
    @NotEmpty(message = "정보를 입력해주세요")
    private String name;

    @NotNull(message = "입력하세요")
    private Integer count;

    @NotNull(message = "입력하세요")
    private Integer price;
}
