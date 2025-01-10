package com.example.order.presentation.model.goods;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class RegisterGoodsRequest {


    @Size(min = 1, max = 100, message = "0文字以上100文字以内が有効です")
    @NotBlank(message = "必須項目です")
    private String goodsName;

    @NotNull(message = "必須項目です")
    @Min(value = 0, message = "0以上を指定してください")
    private Long price;

}
