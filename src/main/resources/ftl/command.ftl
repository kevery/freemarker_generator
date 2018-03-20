package com.fb.service.product.command.impl;

import com.fb.bir.pojo.Product;
import com.fb.service.ProductService;
import com.fb.service.product.command.ProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ${desc}
 * Created by kever
 * 2018/3/12
 */
@Component
public class Batch${command}Command extends ProductCommand {
    @Autowired
    private ProductService productService;

    @Override
    public void executeCommand() throws Exception {
        Product product = new Product();

        List<LinkedHashMap> rows = this.getRows();
    for (LinkedHashMap row : rows) {
    Long id = Long.valueOf(row.get("id").toString());

    }
    }
    }
