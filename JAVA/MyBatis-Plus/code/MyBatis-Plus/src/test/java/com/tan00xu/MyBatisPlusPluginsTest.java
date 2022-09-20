package com.tan00xu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tan00xu.entity.Product;
import com.tan00xu.entity.User;
import com.tan00xu.mapper.ProductMapper;
import com.tan00xu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author TAN00XU
 * @date 2022/09/20 17:20
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页=>" + page.getCurrent());
        System.out.println("每页显示的条数=>" + page.getSize());
        System.out.println("总记录数=>" + page.getTotal());
        System.out.println("总页数=>" + page.getPages());
        System.out.println("是否有上一页=>" + page.hasPrevious());
        System.out.println("是否有下一页=>" + page.hasNext());
    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page, 20);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页=>" + page.getCurrent());
        System.out.println("每页显示的条数=>" + page.getSize());
        System.out.println("总记录数=>" + page.getTotal());
        System.out.println("总页数=>" + page.getPages());
        System.out.println("是否有上一页=>" + page.hasPrevious());
        System.out.println("是否有下一页=>" + page.hasNext());
    }

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testProduct() {
        //小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询商品价格=>" + productLi.getPrice());

        //小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询商品价格=>" + productWang.getPrice());

        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            //操作失败重试
            Product product = productMapper.selectById(1);
            product.setPrice(product.getPrice() - 30);
            productMapper.updateById(product);
        }

        //老板查询商品价格
        Product product = productMapper.selectById(1L);
        System.out.println("老板查询商品价格=>" + product.getPrice());
    }
}
