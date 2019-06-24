package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;

import java.util.List;

public interface ProductService {

    Product Create(Product product);
    Product GetProductInfo(Long id);
    List<Product> GetAllProductInfo();
    Product Update(Product product);
    boolean Delete(Product product);
}
