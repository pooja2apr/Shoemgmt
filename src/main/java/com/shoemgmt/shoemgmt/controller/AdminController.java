package com.shoemgmt.shoemgmt.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoemgmt.shoemgmt.AdminService.AdminService;
import com.shoemgmt.shoemgmt.AdminService.OrderService;
import com.shoemgmt.shoemgmt.AdminService.ShoeService;
import com.shoemgmt.shoemgmt.AdminService.UserService;
import com.shoemgmt.shoemgmt.model.Order;
import com.shoemgmt.shoemgmt.model.Shoe;
import com.shoemgmt.shoemgmt.model.ShoeAdmin;
import com.shoemgmt.shoemgmt.model.Users;

@Controller
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	@Autowired
	ShoeService shoeservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		ShoeAdmin admin=new ShoeAdmin();
		model.addAttribute("admin",admin);
		return"home";
		
	}
	 @PostMapping("/checkAdmin")
	  public String checkUser(@ModelAttribute("admin") ShoeAdmin admin,Model model) {
        List<ShoeAdmin> dbAdmin = adminservice.getShoeAdminByEmail(admin.getEmail());
        if(dbAdmin.size()> 0) 
        {
       	 ShoeAdmin adb = dbAdmin.get(0);
       	 if(adb.getPassword().equals(admin.getPassword())) {
       		 model.addAttribute("message","You have successfully logged in");
       	 }
       	 else {
       		 model.addAttribute("message","Invalid Id or password");
       	 }
        }else {
       	 model.addAttribute("message","Invalid Id or password");
        }
		return "success";
	 }
	 
	 @GetMapping("/showRegisterForm")
	    public String showRegisterForm(Model model) {
	        // create model attribute to bind form data
	     ShoeAdmin admin = new ShoeAdmin();
	        model.addAttribute("admin", admin);
	        return "register_form";
	    }
	 
	 @PostMapping("/saveAdmin")
	    public String saveAdmin(@ModelAttribute("admin") ShoeAdmin admin) {
	        adminservice.saveShoeAdmin(admin);
	        return "redirect:/";
	    }
	 
	 @GetMapping("/showSuccess")
	 public String viewSuccessPage() {
		 return"success";
	 }
	 
	 @GetMapping("/showFormForUpdate")
		public String viewUpdatePage(Model model) {
			ShoeAdmin admin=new ShoeAdmin();
			model.addAttribute("admin",admin);
			return"update_form";
			
		}
	 @PostMapping("/checkEmail")
	  public String checkEmail(@ModelAttribute("admin") ShoeAdmin admin,Model model) {
		 List<ShoeAdmin> dbAdmin = adminservice.getShoeAdminByEmail(admin.getEmail());
       if(dbAdmin.size()> 0) 
       {
    	   ShoeAdmin admin1=dbAdmin.get(0);
    	   model.addAttribute("admin", admin1);
       }
       
       else {
    	   model.addAttribute("message","Invalid Id");
         	
       }
       
		return "update_password";
	 }


	 @GetMapping("/showFormForShoes")
	 public String viewShoePage(Model model)
	 {
		 List<Shoe> list=shoeservice.getAllShoe();
		 model.addAttribute("listshoe",list);
		 return "shoepage";
	 }
	 
	 @GetMapping("/showFormForUsers")
	 public String viewUserPage(Model model)
	 {
		 List<com.shoemgmt.shoemgmt.model.Users> list=userservice.getAllUsers();
		 model.addAttribute("listuser",list);
		 return "userpage";
	 }
	 @GetMapping("/showNewUserForm")
	    public String showNewUserForm(Model model) {
	       
	     Users user=new Users();
	        model.addAttribute("user", user);
	        return "new_user";
	    }
	 
	
	 
	 @PostMapping("/saveUser")
	    public String saveUsers(@ModelAttribute("user") Users user) {
	        userservice.saveUsers(user);
	        return "redirect:/";
	    }
	 
	 
	 
	 @GetMapping("/showFormForUserUpdate/{uid}")
	    public String showFormForUserUpdate(@PathVariable(value = "uid") long id, Model model) {

	       
	    Users user = userservice.getUsersByUid(id);

	       
	        model.addAttribute("user", user);
	        return "update_user";
	    }
	 
	 @GetMapping("/deleteUser/{uid}")
	    public String deleteUser(@PathVariable(value = "uid") long id) {

	        
	        this.userservice.deleteUsersByUid(id);
	        return "redirect:/";
	 }
	
	 @GetMapping("/showNewShoeForm")
	    public String showNewShoeForm(Model model) {
	       
	     Shoe shoe = new Shoe();
	        model.addAttribute("shoe", shoe);
	        return "new_shoe";
	    }
	 @PostMapping("/saveShoe")
	    public String saveShoe(@ModelAttribute("shoe") Shoe shoe) {
	        shoeservice.saveShoe(shoe);
	        return "redirect:/";
	    }
	 
	 @GetMapping("/showFormForUpdate/{sid}")
	    public String showFormForUpdate(@PathVariable(value = "sid") long id, Model model) {

	       
	    Shoe shoe = shoeservice.getShoeBySid(id);

	       
	        model.addAttribute("shoe", shoe);
	        return "update_shoe";
	    }
	 
	 @GetMapping("/deleteShoe/{sid}")
	    public String deleteShoe(@PathVariable(value = "sid") long id) {

	        
	        this.shoeservice.deleteShoeBySid(id);
	        return "home";
	 }
	 
	 
	 @GetMapping("/showReportBasedOnCategory")
	 public String catPage(Model model) {
	 return "category";
	 }
	 
	 @GetMapping("/showRunningShoe")
	 public String runningShoe(Model model) {
		 List<Order> orders1 = orderservice.findByCategory("Running Shoes");
		 model.addAttribute("orders",orders1);
		 return "running";
	 }
	 @GetMapping("/showCourtShoe")
	 public String courtShoe(Model model) {
		 List<Order> orders2 = orderservice.findByCategory("Court Shoes");
		 model.addAttribute("orders",orders2);
		 
		 return "court";
	 }
	 
	 @GetMapping("/showReportBasedOnDate")
	 public String Order(Model model) {
	
		 
		List<Order> list=orderservice.getAllOrders();
		 model.addAttribute("listorder",list);
		 return "orderpage";
	 }
	 }
	 
	 


