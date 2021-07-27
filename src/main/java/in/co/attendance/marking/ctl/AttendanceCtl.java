package in.co.attendance.marking.ctl;

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

import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.AttendanceForm;
import in.co.attendance.marking.form.EnrollForm;
import in.co.attendance.marking.service.AttendanceServiceInt;
import in.co.attendance.marking.service.EnrollServiceInt;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.service.UserServiceInt;
import in.co.attendance.marking.util.DataUtility;

@Controller
@RequestMapping("/ctl/attendance")
public class AttendanceCtl extends BaseCtl {

	@Autowired
	private AttendanceServiceInt service;
	
	@Autowired
	private SessionServiceInt sessionService;
	
	@Autowired
	private EnrollServiceInt enrollService;
	
	@Autowired
	private UserServiceInt userService;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("sessionList",sessionService.list());
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") AttendanceForm form,
			Model model) {
		if (form.getId() > 0) {
			AttendanceDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "attendance";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") AttendanceForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/attendance";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "attendance";
				}

				AttendanceDTO bean = (AttendanceDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Attendance update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Attendance Added Successfully!!!!");
				}
				return "attendance";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "attendance";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AttendanceForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/attendance";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/attendance";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AttendanceDTO dto = new AttendanceDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		AttendanceDTO dto = (AttendanceDTO) form.getDTO();
		List<AttendanceDTO> list = service.search(dto, pageNo, pageSize);
		List<AttendanceDTO> totallist = service.search(dto);
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
		return "attendanceList";
	}
	
	
	@RequestMapping(value = "/user/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListUser(@ModelAttribute("form") AttendanceForm form, @RequestParam(required = false) String operation,
			Long sid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/enroll";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} 
		
		try {
		
		if (OP_SAVE.equals(form.getOperation())) {
			pageNo = 1;
			if (form.getIds() != null) {
				long ssid=DataUtility.getLong(String.valueOf(session.getAttribute("sid")));
				for (long id : form.getIds()) {
					AttendanceDTO dto = new AttendanceDTO();
						dto.setSessionId(ssid);
						dto.setUserId(id);
						dto.setUser(userService.findBypk(id));
						dto.setSession(sessionService.findBypk(ssid));
						dto.setStatus("Present");
						service.add(dto);
				}
				
			} else {
				model.addAttribute("error", "Select at least one record");
			}
			return "redirect:/ctl/attendance";
		}
		
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

		EnrollDTO dto =new EnrollDTO();
		if(sid>0) {
		dto.setSessionId(sid);
		session.setAttribute("sid",sid);
		}
		
		List<EnrollDTO> list = enrollService.search(dto);
		List<EnrollDTO> totallist = enrollService.search(dto);
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
		return "attendanceUserList";
	}

	@RequestMapping(value = "/session/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListSession(@ModelAttribute("form") AttendanceForm form,
			@RequestParam(required = false) String operation, Long sid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/attendance";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} 
		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		AttendanceDTO dto = (AttendanceDTO) form.getDTO();
		if(DataUtility.getLong(String.valueOf(sid))>0) {
			dto.setSessionId(sid);
		}
		List<AttendanceDTO> list = service.search(dto);
		List<AttendanceDTO> totallist = service.search(dto);
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
		return "attendanceSessionList";
	}
	
	@RequestMapping(value = "/user/attend/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListUserAttend(@ModelAttribute("form") AttendanceForm form,
			@RequestParam(required = false) String operation, Long sid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/attendance/user/attend/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} 
		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		AttendanceDTO dto = (AttendanceDTO) form.getDTO();
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		if(uDto !=null) {
			dto.setUserId(uDto.getId());
		}
		List<AttendanceDTO> list = service.search(dto);
		List<AttendanceDTO> totallist = service.search(dto);
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
		return "userAttendSessionList";
	}
	
}
