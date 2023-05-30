package co.edu.sena.demo_javaweb.model.beans;

public class Product {
    private Integer productId;
    private String productName;
    private Integer productValue;
    private Integer categoryId;

    // Constructor
    public Product(Integer productId, String productName, Integer productValue, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productValue = productValue;
        this.categoryId = categoryId;
    }

    public Product() {

    }

    // Getters and Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductValue() {
        return productValue;
    }

    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
