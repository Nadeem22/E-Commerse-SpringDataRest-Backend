package com.ingroinfo.ecommerce.config;


import com.ingroinfo.ecommerce.entity.Product;
import com.ingroinfo.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
    HttpMethod[] theUnsupportedAction={HttpMethod.PUT, HttpMethod.POST,HttpMethod.DELETE};
    //disable http methods for put post and delete
    config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)))
            .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)));

    config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)))
            .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)));


}
}
