package tw.com.order.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.order.demo.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Optional<Order> findByOrderId(String orderId) ;

	void deleteByOrderId(String orderId);

	@Override
	default Optional<Order> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default List<Order> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Order getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
