package in.co.attendance.marking.ctl;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.ChangePasswordForm;
import in.co.attendance.marking.form.ForgetPasswordForm;
import in.co.attendance.marking.form.LoginForm;
import in.co.attendance.marking.form.MyProfileForm;
import in.co.attendance.marking.form.AdminForgetPasswordForm;
import in.co.attendance.marking.form.AdminLoginForm;
import in.co.attendance.marking.form.AdminRegistrationForm;
import in.co.attendance.marking.service.AdminServiceInt;

@Controller
@RequestMapping("/admin")
public class AdminLoginCtl extends BaseCtl {

	private Logger log = Logger.getLogger(AdminLoginCtl.class.getName());

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";

	@Autowired
	private AdminServiceInt service;

	@GetMapping("/login")
	public String display(@ModelAttribute("form") AdminLoginForm form, HttpSession session, Model model) {
		log.info("LoginCtl login display method start");
		if (session.getAttribute("admin") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logout Successfully!!!");
		}
		log.info("LoginCtl login display method End");
		return "ad-login";
	}

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Male", "Male");
		map.put("Female", "Female");
		model.addAttribute("gender", map);

	}

	@PostMapping("/login")
	public String submit(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") AdminLoginForm form, BindingResult result, Model model) {
		log.info("LoginCtl login submit method start");
		System.out.println("In dopost  LoginCtl");

		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/admin/ad-signUp";
		}

		if (result.hasErrors()) {
			System.out.println(result);
			return "ad-login";
		}

		AdminDTO bean = service.authentication((AdminDTO) form.getDTO());

		if (bean != null) {
			if(bean.getStatus().equalsIgnoreCase("Cancel") || bean.getStatus().equalsIgnoreCase("pending")) {
			
				model.addAttribute("error", "Your profile is not approved wait for admin responce");
				return "ad-login";
			}else {
				System.out.println(bean.toString());
				session.setAttribute("admin", bean);
				return "redirect:/welcome";	
			}
			
		}
		model.addAttribute("error", "Login Id Password Invalid");
		log.info("LoginCtl login submit method End");
		return "ad-login";
	}

	@GetMapping("/ad-signUp")
	public String display(@ModelAttribute("form") AdminRegistrationForm form, Model model) {
		log.info("LoginCtl signUp display method start");
		log.info("LoginCtl signUp display method End");
		return "ad-signUp";
	}

	@PostMapping("/ad-signUp")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") AdminRegistrationForm form,
			BindingResult bindingResult, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:ad-signUp";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "ad-signUp";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				AdminDTO entity = (AdminDTO) form.getDTO();
				System.out.println(entity.toString());
				entity.setRoleId(2L);
				entity.setStatus("Pending");
				service.register(entity);
				model.addAttribute("success", "Admin Registerd Successfully!!!!");
				return "ad-signUp";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "ad-signUp";
		}

		log.info("LoginCtl signUp submit method end");
		return "ad-signUp";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		AdminDTO entity = (AdminDTO) session.getAttribute("Admin");
		form.populate(entity);
		System.out.println("/Myprofile");
		return "myprofile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String submitProfile(HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,
			BindingResult bindingResult, @RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/profile";
		}

		if (bindingResult.hasErrors()) {
			return "myprofile";
		}
		AdminDTO entity = (AdminDTO) session.getAttribute("Admin");
		entity = service.findBypk(entity.getId());
		entity.setFirstName(form.getFirstName());
		entity.setLastName(form.getLastName());
		try {
			service.update(entity);
		} catch (DuplicateRecordException e) {

		}
		model.addAttribute("success", "Profile Update successfully");

		return "myprofile";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		return "adminChangePassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "adminChangePassword";
		}
		if (form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {

			AdminDTO dto = (AdminDTO) session.getAttribute("admin");
			dto = service.findBypk(dto.getId());

			if (service.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword())) {
				model.addAttribute("success", "Password changed Successfully");
			} else {
				model.addAttribute("error", "Old Passowors Does not Matched");
			}
		} else {
			model.addAttribute("error", "New Password and confirm password does not matched");
		}
		return "adminChangePassword";
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, HttpSession session, Model model) {

		System.out.println("In doget LoginCtl forgetpassword");

		return "forgetPassword";

	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public String display(@ModelAttribute("form") @Valid AdminForgetPasswordForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "forgetPassword";
		}

		AdminDTO dto = service.findByEmail(form.getEmail());

		if (dto == null) {
			model.addAttribute("error", "Email Id does not exist");
		}

		if (dto != null) {
			service.forgetPassword(form.getEmail());
			model.addAttribute("success", "Password has been sent to your registered Email ID!!");
		}
		return "adminforgetPassword";
	}

}
