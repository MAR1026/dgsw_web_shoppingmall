package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import kr.hs.dgsw.shoppingmall_back.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product Create(Product product) {
        System.out.println(product);
        return this.productRepository.save(product);
    }

    @Override
    public Product GetProductInfo(Long id) {
        Optional<Product> found = this.productRepository.findById(id);

        if(found != null)
            return found.get();
        else
            return null;
    }

    @Override
    public List<Product> GetAllProductInfo() {
        return this.productRepository.findAll();
    }

    @Override
    public Product Update(Product product) {
        Product found = GetProductInfo(product.getId());

        if(found != null) {
            found.setAmount(Optional.ofNullable(product.getAmount()).orElse(found.getAmount()));
            found.setCategory(Optional.ofNullable(product.getCategory()).orElse(found.getCategory()));
            found.setCompany(Optional.ofNullable(product.getCompany()).orElse(found.getCompany()));
            found.setContent(Optional.ofNullable(product.getContent()).orElse(found.getContent()));
            found.setMileage(Optional.ofNullable(product.getMileage()).orElse(found.getMileage()));
            found.setNotice(Optional.ofNullable(product.getNotice()).orElse(found.getNotice()));
            found.setOriginalPrice(Optional.ofNullable(product.getOriginalPrice()).orElse(found.getOriginalPrice()));
            found.setPrice(Optional.ofNullable(product.getPrice()).orElse(found.getPrice()));
            found.setRemainAmount(Optional.ofNullable(product.getRemainAmount()).orElse(found.getRemainAmount()));
            found.setThumbnailPath(Optional.ofNullable(product.getThumbnailPath()).orElse(found.getThumbnailPath()));
            found.setTitle(Optional.ofNullable(product.getTitle()).orElse(found.getTitle()));

            return this.productRepository.save(found);
        }

        return null;
    }

    @Override
    public boolean Delete(Product product) {
        Product found = GetProductInfo(product.getId());

        if(found != null) {
            this.productRepository.deleteById(product.getId());
            return true;
        } else {
            return false;
        }
    }
}
