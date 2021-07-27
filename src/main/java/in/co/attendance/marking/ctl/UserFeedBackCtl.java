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

import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.SessionForm;
import in.co.attendance.marking.form.UserFeedBackForm;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.service.UserFeedBackServiceInt;
import in.co.attendance.marking.util.DataUtility;


@Controller
@RequestMapping("/ctl/userFeedBack")
public class UserFeedBackCtl extends BaseCtl {

	@Autowired
	private UserFeedBackServiceInt service;
	
	@Autowired
	private SessionServiceInt sessionService;

	@ModelAttribute
	public void preload(Model model) {
		
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,Long sid, @ModelAttribute("form") UserFeedBackForm form,HttpSession session,
			Model model) {
		if (form.getId() > 0) {
			UserFeedbackDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		
		if(DataUtility.getLong(String.valueOf(sid))>0) {
			session.setAttribute("sid", sid);
		}
		return "userFeedBack";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") UserFeedBackForm form,
			BindingResult bindingResult,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/userFeedBack";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "userFeedBack";
				}

				UserFeedbackDTO bean = (UserFeedbackDTO) form.getDTO();
				long sid=DataUtility.getLong(String.valueOf(session.getAttribute("sid")));
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUser(uDto);
				bean.setUserId(uDto.getId());
				bean.setSession(sessionService.findBypk(sid));
				bean.setSessionId(sid);
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "UserFeedBack update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "UserFeedBack Added Successfully!!!!");
				}
				return "userFeedBack";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "skill";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserFeedBackForm form, @RequestParam(required = false) String operation,
			Long sid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/userFeedBack";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/userFeedBack";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserFeedbackDTO dto = new UserFeedbackDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserFeedbackDTO dto = (UserFeedbackDTO) form.getDTO();
		if(DataUtility.getLong(String.valueOf(sid))>0) {
			dto.setSessionId(DataUtility.getLong(String.valueOf(sid)));
		}
		
		List<UserFeedbackDTO> list = service.search(dto, pageNo, pageSize);
		List<UserFeedbackDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		/*
		 * if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
		 * model.addAttribute("error", "Record not found"); }
		 */

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
		return "userFeedBackList";
	}
	
	
	@RequestMapping(value = "/session/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") SessionForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/session";
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

		
		SessionDTO dto = (SessionDTO) form.getDTO();
		List<SessionDTO> list = sessionService.search(dto, pageNo, pageSize);
		List<SessionDTO> totallist = sessionService.search(dto);
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
		return "sessionFeedBackList";
	}
	
	

}
