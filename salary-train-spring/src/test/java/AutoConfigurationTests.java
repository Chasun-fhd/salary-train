import com.sts.springboot.BootStrap;
import com.sts.springboot.entity.Order;
import com.sts.springboot.repository.OrderRepository;
import com.sts.springboot.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/18
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = BootStrap.class)
@EnableJpaRepositories(
        basePackages = { "com.sts.springboot.entity","com.sts.springboot.repository" })
public class AutoConfigurationTests {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenSaveUser_thenOk() {
        orderService.create();
        List<Order> orders = orderRepository.findByOrderNo("o1");
        System.out.println(orders);
    }
}
