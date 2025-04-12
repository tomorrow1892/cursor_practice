package com.example.cms.application.controller;

import com.example.cms.domain.form.ProductForm;
import com.example.cms.domain.model.Product;
import com.example.cms.domain.repository.ProductRepository;
import com.example.cms.domain.specification.ProductSpecification;
import com.example.cms.domain.dto.ProductSearchCriteria;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listProducts(
            @RequestParam(required = false) String contentId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime releaseDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime releaseDateTo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservationStartDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservationStartDateTo,
            @RequestParam(required = false) Boolean isActive,
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        ProductSearchCriteria criteria = new ProductSearchCriteria();
        criteria.setContentId(contentId);
        criteria.setTitle(title);
        criteria.setMinPrice(minPrice);
        criteria.setMaxPrice(maxPrice);
        criteria.setReleaseDateFrom(releaseDateFrom);
        criteria.setReleaseDateTo(releaseDateTo);
        criteria.setReservationStartDateFrom(reservationStartDateFrom);
        criteria.setReservationStartDateTo(reservationStartDateTo);
        criteria.setIsActive(isActive);

        Page<Product> products = productRepository.findAll(ProductSpecification.searchProducts(criteria), pageable);

        model.addAttribute("products", products);
        model.addAttribute("criteria", criteria);
        return "product/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product/form";
    }

    @PostMapping
    public String createProduct(@Valid @ModelAttribute("productForm") ProductForm form, 
                              BindingResult result, 
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "product/form";
        }

        Product product = new Product();
        product.setContentId(form.getContentId());
        product.setTitle(form.getTitle());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setReleaseDate(form.getReleaseDate());
        product.setReservationStartDate(form.getReservationStartDate());
        product.setReservationEndDate(form.getReservationEndDate());
        product.setActive(form.isActive());

        productRepository.save(product);

        redirectAttributes.addFlashAttribute("successMessage", "Product has been created successfully.");
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String showProductDetail(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "product/detail";
    }
} 