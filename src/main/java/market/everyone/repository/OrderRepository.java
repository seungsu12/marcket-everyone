package market.everyone.repository;


import market.everyone.domain.Order;
import market.everyone.dto.OrderRequestDto;
import market.everyone.dto.OrderResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



}
