package com.akila.orangeapp;

import android.util.Log;

import java.util.ArrayList;

public class ProductController {
    private static final String TAG = "PRODUCT_CONTROLLER";
    private static ArrayList<Product> productList = new ArrayList<>();

    ProductController() {
        productList = new ArrayList<>();
    }

    public void addOrUpdate(Product p) {
        if (search(p.getId()) != null) {
            updateProduct(p.getId(), p);
            return;
        }
        productList.add(p);
        Log.i(TAG, "addOrUpdate: product_added [" + p.getId() + "]");
    }

    private Product search(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                Log.d(TAG, "search: item_found[" + id + "]");
                return product;
            }
        }
        return null;
    }

    public void removeProduct(int id) {
        Product search = search(id);
        if (search != null) {
            productList.remove(productList.indexOf(search));
        }
        Log.i(TAG, "removeProduct: removed item_count[" + productList.size() + "]");
    }

    static double calcTotal() {
        double total = 0;
        for (Product p : productList) {
            total += p.qty * p.price;
        }
        return total;
    }

    static void updateProduct(long id, Product product) {
        Log.d(TAG, "updateProduct() called with: id = [" + id + "], product = [" + product + "]");
        for (Product p : productList) {
            if (p.id == id) {
                p.qty = product.qty;
                productList.set(productList.indexOf(p), p);
                return;
            }
        }
    }

}
