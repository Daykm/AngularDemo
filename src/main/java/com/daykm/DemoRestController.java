package com.daykm;


import com.daykm.dao.ButtonRepo;
import com.daykm.domain.Button;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class DemoRestController {

	@Autowired
	private ButtonRepo buttonRepo;

    @RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping("/demo")
	public Map<String,Object> demo() {
		Map<String,Object> model = new HashMap<>();
		model.put("content", "Demo");
		return model;
	}

	@RequestMapping("/buttonPresses")
	public Map<String, Object> getPresses() {
		List<Button> bs = buttonRepo.findAll();
		Map<String,Object> model = new HashMap<>();
		model.put("clicks",
				bs.size() != 0
						? bs.get(0).getClicks()
						: 0);
		return model;
	}

	@RequestMapping("/pressButton")
	public Map<String, Object> press() {
		List<Button> bs = buttonRepo.findAll();
		Button b;
		if(bs.size() == 0) {
			b = new Button();
			buttonRepo.save(b);
		} else {
			b = bs.get(0);
		}
		b.setClicks(b.getClicks() + 1);
		b = buttonRepo.save(b);
		Map<String,Object> model = new HashMap<>();
		model.put("clicks", b.getClicks());
		return model;
	}
}
