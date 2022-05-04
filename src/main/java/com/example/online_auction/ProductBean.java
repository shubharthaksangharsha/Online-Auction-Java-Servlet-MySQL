package com.example.online_auction;

public class ProductBean {
    String userName;
    String productName;
    String val;
    public ProductBean(String userName, String productName, String val){
        this.userName = userName;
        this.productName = productName;
        this.val = val;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
