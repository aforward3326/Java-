package tw.com.order.demo.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({"/","","index","/logout"})
	public String getIndex(Model model) {
		
		return "index";
	}
	
	

}
