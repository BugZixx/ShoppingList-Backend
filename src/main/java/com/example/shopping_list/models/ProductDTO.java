package com.example.shopping_list.models;

public class ProductDTO {
    private Long product_id;
    private String product_name;
    private boolean checked;
    private Integer row_num;
    private Long shop_id;


    public Long getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public Integer getRow_num() {
        return row_num;
    }
    public void setRow_num(Integer row_num) {
        this.row_num = row_num;
    }
    public Long getShop_id() {
        return shop_id;
    }
    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    
}
