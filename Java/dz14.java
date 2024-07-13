public class Manufacturer {
    private String name;
    private String headquarters;
    private String logoUrl;
    private int employeesCount;
    private String description;

    // геттеры, сеттеры и конструкторы
}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {

    @GetMapping("/manufacturer")
    public Manufacturer getManufacturerInfo() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Название производителя");
        manufacturer.setHeadquarters("Название страны");
        manufacturer.setLogoUrl("url_логотипа");
        manufacturer.setEmployeesCount(1000);
        manufacturer.setDescription("Краткая информация о производителе");

        return manufacturer;
    }
}


//Зависимости для pom.xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>


//Точка входа в приложение
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}