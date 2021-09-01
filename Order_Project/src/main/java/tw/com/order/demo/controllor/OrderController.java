package tw.com.order.demo.controllor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tw.com.order.demo.entities.Order;
import tw.com.order.demo.service.OrderService;



@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = { "/order_orders" })
	public String mainOrder(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("肉鬆", 2);
		item.put("稀飯", 1);
		item.put("皮蛋", 0);
		model.addAttribute("item", item);

		return "order";
	}

	@GetMapping(value = { "/all_orderlist" })
	public String viewHomePage(Model model) {
		model.addAttribute("listOrder", orderService.getAllOrder());
		model.addAttribute("title", "訂單列表");
		return "dashboard/order_list";
	}

	@GetMapping(value = { "/new_orderlist" })
	public String newOrderList(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		return "new_orderlist";

	}

	// 儲存訂單
	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order, Model model) {
		orderService.saveOrder(order);
		return "redirect:/";
	}

	// 更新訂單
	@GetMapping("/updateOrder/{id}")
	public String updateOrder(@PathVariable(value = "id") String orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "update_order";
	}

	// 刪除訂單
	@GetMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable(value = "id") String orderId) {
		this.orderService.deleteOrder(orderId);
		return "redirect:/";
	}

	//查詢訂單
	@GetMapping("/order_search/{id}")
	public String getOrder(@PathVariable String orderid, Model model) {
//		Order order=orderService.getOrderById(orderid);
		model.addAttribute("orderSearch", orderService.getOrderById(orderid));
		return "order_search_result";
	}
}
