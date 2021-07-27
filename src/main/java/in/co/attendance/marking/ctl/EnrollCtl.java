package in.co.attendance.marking.ctl;

import java.util.HashMap;
import java.util.List;

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

import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.EnrollForm;
import in.co.attendance.marking.service.EnrollServiceInt;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.service.UserServiceInt;
import in.co.attendance.marking.util.DataUtility;

@Controller
@RequestMapping("/ctl/enroll")
public class EnrollCtl extends BaseCtl {

	@Autowired
	private EnrollServiceInt service;


	@Autowired
	private SessionServiceInt sessionService;
	
	@Autowired
	private UserServiceInt userService;

	@ModelAttribute
	public void preload(Model model) {
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Pending", "Pending");
		map2.put("Rejected", "Rejected");
		map2.put("Approve", "Approve");
		model.addAttribute("stautsMap", map2);
		
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") EnrollForm form,
			Model model) {
		if (form.getId() > 0) {
			EnrollDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "enroll";
	}

	@PostMapping
	public String submit(@RequestParam(required = false) String operation, Long sId,
			@Valid @ModelAttribute("form") EnrollForm form, HttpSession session, BindingResult bindingResult,
			Model model) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/enroll";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				
				EnrollDTO bean = (EnrollDTO) form.getDTO();
				if (bean.getId() > 0) {
					bean.setUser(userService.findBypk(bean.getUserId()));
					bean.setSession(sessionService.findBypk(bean.getSessionId()));
					service.update(bean);
					model.addAttribute("success", "Enroll update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Enroll Added Successfully!!!!");
				}
				return "enroll";
			} 
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "enroll";
		}
		return "";
	}

	@GetMapping("/add")
	public String submitAdd(@RequestParam(required = false) String operation, Long sId,
			@Valid @ModelAttribute("form") EnrollForm form, HttpSession session, BindingResult bindingResult,
			Model model) {

		try {
			if ("Enroll".equalsIgnoreCase(operation)) {
				UserDTO uDto = (UserDTO) session.getAttribute("user");
				EnrollDTO end=service.findByUserId(uDto);
				if(end==null) {
				EnrollDTO dto = (EnrollDTO) form.getDTO();
				dto.setUser(uDto);
				dto.setUserId(uDto.getId());
				dto.setSession(sessionService.findBypk(DataUtility.getLong(String.valueOf(sId))));
				dto.setSessionId(DataUtility.getLong(String.valueOf(sId)));
				dto.setStatus("Pending");
				service.add(dto);
				}
				return "redirect:/home";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "enroll";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") EnrollForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/enroll";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/enroll";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					EnrollDTO dto = new EnrollDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		EnrollDTO dto = (EnrollDTO) form.getDTO();
		List<EnrollDTO> list = service.search(dto, pageNo, pageSize);
		List<EnrollDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "enrollList";
	}

}
