package com.neeraj.orion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraj.orion.model.ItemOnList;
import com.neeraj.orion.model.ListViewModel;
import com.neeraj.orion.service.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listServ;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<ItemOnList> lists = listServ.getItemsList();
		model.addAttribute("items", new ListViewModel(lists));
		return "index";
	}
	
	@RequestMapping("/add")
	public String addItem(@ModelAttribute ItemOnList requestItem) {
		listServ.addItem(requestItem);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String updateItems(@ModelAttribute ListViewModel requestLists) {
		listServ.updateItem(requestLists);
		return "redirect:/";
	}
	

}
