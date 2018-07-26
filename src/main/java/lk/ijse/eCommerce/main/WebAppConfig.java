package lk.ijse.eCommerce.main;


import lk.ijse.eCommerce.repository.CustomerRepository;
import lk.ijse.eCommerce.repository.ItemRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("lk.ijse.eCommerce")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class,ItemRepository.class})
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
