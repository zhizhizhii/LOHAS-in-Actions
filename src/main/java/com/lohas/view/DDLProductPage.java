package com.lohas.view;

import com.lohas.common.PaginationReceive;
import com.lohas.model.DDLProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DDLProductPage extends PaginationReceive {
    @ApiModelProperty(value = "临期商品列表")
    private List<DDLProductItem> ddlProductItems;

    public DDLProductPage(Page<DDLProduct> ddlProductPage){
        setPageNum(ddlProductPage.getNumber() + 1);
        setTotalPage(ddlProductPage.getTotalPages());
        setDdlProductItems(ddlProductPage.stream().map(DDLProductItem::new).collect(Collectors.toList()));
    }
}
