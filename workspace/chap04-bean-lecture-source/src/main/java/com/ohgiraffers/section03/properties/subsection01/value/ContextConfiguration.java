package com.ohgiraffers.section03.properties.subsection01.value;


import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("section03/properties/subsection01/value/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name2:팥붕어빵}") //${} 를 치환자라고 함
    private String carpBreadName;

    @Value("${bread.carpbread.price:0}") // :0 만약 저게 없으면 0으로 치환해라.
    private int carpBreadPrice;

//    @Value("${bread.carpbread.name:팥붕어빵}") // :0 만약 저게 없으면 0으로 치환해라.
//    private int carpBreadName2;

    @Value("${beverage.milk.name:}") //콜론 후 아무것도 안적으면 빈값으로 냅두라는뜻
    private String milkName;

    @Value("${beverage.milk.price:0}")
    private int milkPrice;

    @Value("${beverage.milk.capacity:}")
    private int milkCapacity;



    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk(){

        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price:0}")int waterPrice,
                         @Value("${beverage.water.capacity:0}")int waterCapacity) {

        return new Beverage(waterName, waterPrice, waterCapacity);
    }
}
