public class Shop {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String category;
    private String description;

    // геттеры, сеттеры и конструкторы
}

@Controller
public class ShopController {
    private List<Shop> shopList = new ArrayList<>();

    @GetMapping("/shops")
    public String showShops(Model model) {
        model.addAttribute("shops", shopList);
        return "shop-list";
    }

    @GetMapping("/shop/{id}")
    public String showShopDetails(@PathVariable int id, Model model) {
        Shop shop = shopList.get(id);
        model.addAttribute("shop", shop);
        return "shop-details";
    }
}

//HTML-шаблон
`shop-list.html`:
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <ul>
        <li th:each="shop : ${shops}">
            <a th:href="@{/shop/{id}(id=${shop.id})}" th:text="${shop.name}"></a>
            <span th:text="${shop.category}"></span>
        </li>
    </ul>
</body>
```

`shop-details.html`:
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <h1 th:text="${shop.name}"></h1>
    <p th:text="${shop.address}"></p>
    <p th:text="${shop.phone}"></p>
    <p th:text="${shop.email}"></p>
    <p th:text="${shop.website}"></p>
    <p th:text="${shop.description}"></p>
</body>