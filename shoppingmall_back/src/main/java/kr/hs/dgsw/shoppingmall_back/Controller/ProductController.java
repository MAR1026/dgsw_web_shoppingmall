package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import kr.hs.dgsw.shoppingmall_back.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public Product Create(@RequestBody Product product) {
        return this.productService.Create(product);
    }

    @GetMapping(value = "/find/{id}")
    public Product findProduct(@PathVariable Long id) {
        return this.productService.GetProductInfo(id);
    }

    @GetMapping(value = "/findAll")
    public List<Product> findAllProduct() {
        return this.productService.GetAllProductInfo();
    }

    @PutMapping(value = "/update")
    public Product update(@RequestBody Product product) {
        return this.productService.Update(product);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody Product product) {
        return this.productService.Delete(product);
    }
}
