package com.example.sugondese;

public class Product {
    private int _id;
    private String _productname;
    private int _quantity;

    public Product(){}

    public Product(String _productname, int _quantity) {
        this._productname = _productname;
        this._quantity = _quantity;

    }
    public Product(int _id, String _productname, int _quantity) {
        this._id = _id;
        this._productname = _productname;
        this._quantity = _quantity;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_productname() {
        return _productname;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

}
