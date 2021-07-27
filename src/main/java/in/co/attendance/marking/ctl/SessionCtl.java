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

import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.SessionForm;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.service.SkillSetServiceInt;


@Controller
@RequestMapping("/ctl/session")
public class SessionCtl extends BaseCtl {

	@Autowired
	private SessionServiceInt service;
	
	@Autowired
	private SkillSetServiceInt skillService;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("skillList",skillService.search(null));
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Class Room Session", "Class Room Session");
		map2.put("Virtual Session", "Virtual Vession");
		model.addAttribute("sType", map2);
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") SessionForm form,
			Model model) {
		if (form.getId() > 0) {
			SessionDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "session";
	}
	
	@GetMapping("/user/Detail")
	public String displayDetail(@RequestParam(required = false) Long id, @ModelAttribute("form") SessionForm form,
			Model model) {
		if (form.getId() > 0) {
			SessionDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "sessionDetail";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") SessionForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/session";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "session";
				}

				SessionDTO bean = (SessionDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Session update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Session Added Successfully!!!!");
				}
				return "session";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "session";
		}
		return "";
	}

	@RequestMapping(value = "/user/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListUser(@ModelAttribute("form") SessionForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/session/user/search";
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
		List<SessionDTO> list = service.search(dto, pageNo, pageSize);
		List<SessionDTO> totallist = service.search(dto);
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
		return "sessionUserList";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
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
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/session";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					SessionDTO dto = new SessionDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		SessionDTO dto = (SessionDTO) form.getDTO();
		List<SessionDTO> list = service.search(dto, pageNo, pageSize);
		List<SessionDTO> totallist = service.search(dto);
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
		return "sessionList";
	}
	
	
	@RequestMapping(value = "/report", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchListReport(@ModelAttribute("form") SessionForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/session/report";
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
		List<SessionDTO> list = service.search(dto, pageNo, pageSize);
		List<SessionDTO> totallist = service.search(dto);
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
		return "sessionReportList";
	}
	
	
	
	
	

}
