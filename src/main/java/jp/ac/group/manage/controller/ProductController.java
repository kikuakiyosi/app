package jp.ac.group.manage.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.group.manage.model.ProductList;
import jp.ac.group.manage.service.ProductListService;

@Controller
public class ProductController {
	@Autowired
	private ProductListService ProductListService;
 
//	@GetMapping("/")
//	public String indexx(Model model) {
//		model.addAttribute("list",this.ProductListService.getProductList());
//		// TODO: model.addAttributeに一覧取得結果を追加
//		return "top";
//	}
	@GetMapping("/secret/top")
	public String index(Model model) {
		model.addAttribute("list",this.ProductListService.getProductList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
	@GetMapping("/secret")
	public String inbex(Model model) {
		model.addAttribute("list",this.ProductListService.getProductList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "secret";
	}
 
	@GetMapping("/add/")
	public ModelAndView add(ProductList ProductList, ModelAndView model) {
		model.addObject("ProductList", ProductList);
		model.setViewName("form");
		return model;
	}
 
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull ProductList ProductList, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.ProductListService.save(ProductList);
			redirectAttributes.addFlashAttribute("exception", "");
 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/secret";
	}
	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, ProductList ProductList, ModelAndView model) {
		model.addObject("detaillist", this.ProductListService.get(id));
		model.setViewName("detail");
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, ProductList ProductList, ModelAndView model) {
		this.ProductListService.delete(id);
		model.setViewName("delete");
		return model;
	}
}