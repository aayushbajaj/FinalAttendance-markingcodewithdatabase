package in.co.attendance.marking.ctl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.service.EnrollServiceInt;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.util.DataUtility;

@Controller
public class WelcomeCtl extends BaseCtl {

	@Autowired
	private EnrollServiceInt enrollService;

	@Autowired
	private SessionServiceInt sessionService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {

		UserDTO uDto = (UserDTO) session.getAttribute("user");
		if (uDto == null) {
			return "redirect:/user/login";
		}
		EnrollDTO enDto = enrollService.findByUserId(uDto);
		System.out.println("ENROLL DTO" + enDto);
		if (enDto != null) {
			if (enDto.getStatus().equalsIgnoreCase("Pending") || enDto.getStatus().equalsIgnoreCase("Rejected")) {
				model.addAttribute("error", "Your 4010"+enDto.getSessionId()+" Session Enroll are " + enDto.getStatus());
			} else {
				model.addAttribute("success", "Your 4010"+enDto.getSessionId()+" Session Enroll are " + enDto.getStatus() + "d");
				SessionDTO sDto = sessionService.findBypk(enDto.getSessionId());
				long days = DataUtility.getDateDiffrence(sDto.getDate());
				days = DataUtility.getLong(String.valueOf(days));
				System.out.println("Days----" + days);
				if (days <= 2 && days >= 0) {
					model.addAttribute("warning", "Your session start on within " + days + " days");
				}
			}
		} else {
			model.addAttribute("error", "You was not enroll the session please enroll first");
		}
		return "home";
	}

}
