package com.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.Repository.ProductRepository;
import com.excel.Util.excelHelper;
import com.excel.entity.Product;

@Service
public class ProductService {
	  @Autowired
	    private ProductRepository productRepository;

	    public String saveExcelData(MultipartFile file) {
	        try {
	            if (!excelHelper.checkexcelformate(file)) {
	                throw new IllegalArgumentException("Invalid file format. Please upload an Excel file.");
	            }

	            List<Product> products = excelHelper.convertExcelToListofProduct(file.getInputStream());
	            productRepository.saveAll(products);
	            return "Excel data saved successfully.";
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to store Excel data: " + e.getMessage());
	        }
	    }

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

}
