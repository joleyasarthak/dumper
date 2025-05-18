package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.model.enums.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VendorProfileRepository vendorProfileRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
    @Autowired
    private VendorProductRepository vendorProductRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Seed data here
        if (userRepository.count() == 0) {
            seedUsers();
            seedProductCategories();
            seedCatalogProducts();
            seedVendorProfiles();
            seedVendorProducts();
            seedAddresses();
            seedShoppingCarts();
            seedCartItems();
            seedOrders();
            seedOrderItems();
            seedPayments();
            seedReviews();
        }
    }

    private void seedUsers() {
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setEmail("admin@example.com");
        admin.setPasswordHash(passwordEncoder.encode("password"));
        admin.setRole(Role.ADMIN);
        admin.setPhoneNumber("1234567890");
        admin.setCreatedAt(LocalDateTime.now());
        admin.setUpdatedAt(LocalDateTime.now());
        userRepository.save(admin);

        User vendor = new User();
        vendor.setFirstName("Vendor");
        vendor.setLastName("User");
        vendor.setEmail("vendor@example.com");
        vendor.setPasswordHash(passwordEncoder.encode("password"));
        vendor.setRole(Role.VENDOR);
        vendor.setPhoneNumber("0987654321");
        vendor.setCreatedAt(LocalDateTime.now());
        vendor.setUpdatedAt(LocalDateTime.now());
        userRepository.save(vendor);

        User customer = new User();
        customer.setFirstName("Customer");
        customer.setLastName("User");
        customer.setEmail("customer@example.com");
        customer.setPasswordHash(passwordEncoder.encode("password"));
        customer.setRole(Role.CUSTOMER);
        customer.setPhoneNumber("1122334455");
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        userRepository.save(customer);
    }

    private void seedVendorProfiles() {
        User vendorUser = userRepository.findByEmail("vendor@example.com").orElseThrow();
        VendorProfile vendorProfile = new VendorProfile();
        vendorProfile.setUser(vendorUser);
        vendorProfile.setStoreName("Vendor Store");
        vendorProfile.setStoreDescription("A great vendor store.");
        vendorProfile.setBusinessAddress("123 Vendor St");
        vendorProfile.setContactNumber("0987654321");
        vendorProfile.setApprovalStatus(ApprovalStatus.APPROVED);
        vendorProfile.setCreatedAt(LocalDateTime.now());
        vendorProfile.setUpdatedAt(LocalDateTime.now());
        vendorProfileRepository.save(vendorProfile);
    }

    private void seedProductCategories() {
        ProductCategory electronics = new ProductCategory();
        electronics.setName("Electronics");
        electronics.setDescription("Electronic devices and gadgets");
        electronics.setCreatedAt(LocalDateTime.now());
        electronics.setUpdatedAt(LocalDateTime.now());
        productCategoryRepository.save(electronics);

        ProductCategory books = new ProductCategory();
        books.setName("Books");
        books.setDescription("Various genres of books");
        books.setCreatedAt(LocalDateTime.now());
        books.setUpdatedAt(LocalDateTime.now());
        productCategoryRepository.save(books);
    }

    private void seedCatalogProducts() {
        ProductCategory electronics = productCategoryRepository.findByName("Electronics").orElseThrow();
        ProductCategory books = productCategoryRepository.findByName("Books").orElseThrow();

        ProductCatalog laptop = new ProductCatalog();
        laptop.setName("Laptop");
        laptop.setBrand("BrandX");
        laptop.setDescription("High performance laptop");
        laptop.setGlobalSKU("BX-LAP-001");
        laptop.setCategory(electronics);
        laptop.setCreatedAt(LocalDateTime.now());
        laptop.setUpdatedAt(LocalDateTime.now());
        productCatalogRepository.save(laptop);

        ProductCatalog novel = new ProductCatalog();
        novel.setName("Science Fiction Novel");
        novel.setBrand("AuthorY");
        novel.setDescription("An exciting sci-fi adventure");
        novel.setGlobalSKU("AY-SFN-001");
        novel.setCategory(books);
        novel.setCreatedAt(LocalDateTime.now());
        novel.setUpdatedAt(LocalDateTime.now());
        productCatalogRepository.save(novel);
    }

    private void seedVendorProducts() {
        VendorProfile vendorProfile = vendorProfileRepository.findByStoreName("Vendor Store").orElseThrow();
        ProductCatalog laptopCatalog = productCatalogRepository.findByName("Laptop").orElseThrow();
        ProductCatalog novelCatalog = productCatalogRepository.findByName("Science Fiction Novel").orElseThrow();

        VendorProduct vendorLaptop = new VendorProduct();
        vendorLaptop.setProductCatalog(laptopCatalog);
        vendorLaptop.setVendor(vendorProfile);
        vendorLaptop.setSKU("V-LAP-001");
        vendorLaptop.setPrice(new BigDecimal("1200.00"));
        vendorLaptop.setStockQuantity(10);
        // Assuming a default shipping address for the vendor or creating one
        Address vendorAddress = new Address();
        vendorAddress.setUser(vendorProfile.getUser()); // Associate with vendor user
        vendorAddress.setStreet("456 Vendor Shipping Rd");
        vendorAddress.setCity("Vendoria");
        vendorAddress.setState("VS");
        vendorAddress.setZipCode("98765");
        vendorAddress.setCountry("Country");
        vendorAddress.setAddressType(AddressType.SHIPPING);
        addressRepository.save(vendorAddress);
        vendorLaptop.setShippingAddress(vendorAddress);
        vendorLaptop.setApprovalStatus(ApprovalStatus.APPROVED);
        vendorLaptop.setIsActive(true);
        vendorLaptop.setAverageRating(BigDecimal.ZERO);
        vendorLaptop.setCreatedAt(LocalDateTime.now());
        vendorLaptop.setUpdatedAt(LocalDateTime.now());
        vendorProductRepository.save(vendorLaptop);

        VendorProduct vendorNovel = new VendorProduct();
        vendorNovel.setProductCatalog(novelCatalog);
        vendorNovel.setVendor(vendorProfile);
        vendorNovel.setSKU("V-NOV-001");
        vendorNovel.setPrice(new BigDecimal("15.00"));
        vendorNovel.setStockQuantity(50);
        vendorNovel.setShippingAddress(vendorAddress); // Same shipping address as laptop
        vendorNovel.setApprovalStatus(ApprovalStatus.APPROVED);
        vendorNovel.setIsActive(true);
        vendorNovel.setAverageRating(BigDecimal.ZERO);
        vendorNovel.setCreatedAt(LocalDateTime.now());
        vendorNovel.setUpdatedAt(LocalDateTime.now());
        vendorProductRepository.save(vendorNovel);
    }

    private void seedAddresses() {
        User customerUser = userRepository.findByEmail("customer@example.com").orElseThrow();

        Address shippingAddress = new Address();
        shippingAddress.setUser(customerUser);
        shippingAddress.setStreet("789 Customer Ln");
        shippingAddress.setCity("Custom City");
        shippingAddress.setState("CS");
        shippingAddress.setZipCode("12345");
        shippingAddress.setCountry("Country");
        shippingAddress.setAddressType(AddressType.SHIPPING);
        addressRepository.save(shippingAddress);

        Address billingAddress = new Address();
        billingAddress.setUser(customerUser);
        billingAddress.setStreet("101 Customer Ave");
        billingAddress.setCity("Custom City");
        billingAddress.setState("CS");
        billingAddress.setZipCode("12345");
        billingAddress.setCountry("Country");
        billingAddress.setAddressType(AddressType.BILLING);
        addressRepository.save(billingAddress);
    }

    private void seedShoppingCarts() {
        User customerUser = userRepository.findByEmail("customer@example.com").orElseThrow();
        ShoppingCart cart = new ShoppingCart();
        cart.setCustomer(customerUser);
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());
        shoppingCartRepository.save(cart);
    }

    private void seedCartItems() {
        ShoppingCart customerCart = shoppingCartRepository.findByCustomerEmail("customer@example.com").orElseThrow();
        VendorProduct vendorLaptop = vendorProductRepository.findBySKU("V-LAP-001").orElseThrow();
        VendorProduct vendorNovel = vendorProductRepository.findBySKU("V-NOV-001").orElseThrow();

        CartItem laptopItem = new CartItem();
        laptopItem.setCart(customerCart);
        laptopItem.setVendorProduct(vendorLaptop);
        laptopItem.setQuantity(1);
        laptopItem.setAddedAt(LocalDateTime.now());
        cartItemRepository.save(laptopItem);

        CartItem novelItem = new CartItem();
        novelItem.setCart(customerCart);
        novelItem.setVendorProduct(vendorNovel);
        novelItem.setQuantity(2);
        novelItem.setAddedAt(LocalDateTime.now());
        cartItemRepository.save(novelItem);
    }

    private void seedOrders() {
        User customerUser = userRepository.findByEmail("customer@example.com").orElseThrow();
        Address shippingAddress = addressRepository
                .findByUserEmailAndAddressType("customer@example.com", AddressType.SHIPPING).orElseThrow();
        Address billingAddress = addressRepository
                .findByUserEmailAndAddressType("customer@example.com", AddressType.BILLING).orElseThrow();

        Order order = new Order();
        order.setCustomer(customerUser);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(new BigDecimal("1230.00")); // Sum of laptop (1200) + 2*novel (15*2=30)
        order.setOverallOrderStatus(OverallOrderStatus.PROCESSING);
        order.setShippingAddress(shippingAddress);
        order.setBillingAddress(billingAddress);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }

    private void seedOrderItems() {
        Order customerOrder = orderRepository.findTopByCustomerEmailOrderByOrderDateDesc("customer@example.com")
                .orElseThrow();
        VendorProduct vendorLaptop = vendorProductRepository.findBySKU("V-LAP-001").orElseThrow();
        VendorProduct vendorNovel = vendorProductRepository.findBySKU("V-NOV-001").orElseThrow();

        OrderItem laptopOrderItem = new OrderItem();
        laptopOrderItem.setOrder(customerOrder);
        laptopOrderItem.setVendorProduct(vendorLaptop);
        laptopOrderItem.setQuantity(1);
        laptopOrderItem.setPriceAtPurchase(vendorLaptop.getPrice());
        laptopOrderItem.setSubtotal(vendorLaptop.getPrice().multiply(new BigDecimal(laptopOrderItem.getQuantity())));
        laptopOrderItem.setItemStatus(ItemStatus.ACKNOWLEDGED);
        orderItemRepository.save(laptopOrderItem);

        OrderItem novelOrderItem = new OrderItem();
        novelOrderItem.setOrder(customerOrder);
        novelOrderItem.setVendorProduct(vendorNovel);
        novelOrderItem.setQuantity(2);
        novelOrderItem.setPriceAtPurchase(vendorNovel.getPrice());
        novelOrderItem.setSubtotal(vendorNovel.getPrice().multiply(new BigDecimal(novelOrderItem.getQuantity())));
        novelOrderItem.setItemStatus(ItemStatus.ACKNOWLEDGED);
        orderItemRepository.save(novelOrderItem);
    }

    private void seedPayments() {
        Order customerOrder = orderRepository.findTopByCustomerEmailOrderByOrderDateDesc("customer@example.com")
                .orElseThrow();

        Payment payment = new Payment();
        payment.setOrder(customerOrder);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(customerOrder.getTotalAmount());
        payment.setPaymentMethod("Card");
        payment.setTransactionId("TXN123456789");
        payment.setStatus(PaymentStatus.SUCCEEDED);
        paymentRepository.save(payment);
    }

    private void seedReviews() {
        User customerUser = userRepository.findByEmail("customer@example.com").orElseThrow();
        VendorProduct vendorLaptop = vendorProductRepository.findBySKU("V-LAP-001").orElseThrow();
        Order customerOrder = orderRepository.findTopByCustomerEmailOrderByOrderDateDesc("customer@example.com")
                .orElseThrow();

        Review laptopReview = new Review();
        laptopReview.setVendorProduct(vendorLaptop);
        laptopReview.setCustomer(customerUser);
        laptopReview.setOrder(customerOrder);
        laptopReview.setRating(5);
        laptopReview.setComment("Great laptop!");
        laptopReview.setReviewDate(LocalDateTime.now());
        laptopReview.setApprovalStatus(ApprovalStatus.APPROVED);
        reviewRepository.save(laptopReview);
    }
}