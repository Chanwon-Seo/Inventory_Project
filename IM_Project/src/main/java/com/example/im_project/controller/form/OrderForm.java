package com.example.im_project.controller.form;

import com.example.im_project.domain.Inventory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {

    private Long id;

    private String name;

    private Integer count;

    private Integer price;

    private Integer minusCount;

}
