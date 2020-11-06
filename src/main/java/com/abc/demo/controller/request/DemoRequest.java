package com.abc.demo.controller.request;

import com.abc.demo.validation.group.Group1;
import com.abc.demo.validation.group.Group2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoRequest {

    @Positive(message = "id必須大於0")
    private long id;

    @Email(message = "信箱格式錯誤",
            groups = Group1.class)
    private String email;

    @Min(value = 18, message = "年記不可小於18歲",
            groups = Group2.class)
    private int age;

}
