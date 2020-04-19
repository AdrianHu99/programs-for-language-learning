package main.rpc07;

import common.IProductService;
import common.Product;

public class ProductServiceImpl implements IProductService {
    @Override
    public Product findProductById(Integer id) {
        return new Product(id);
    }
}