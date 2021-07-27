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

import in.co.attendance.marking.dto.SkillSetDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.SkillSetForm;
import in.co.attendance.marking.service.SkillSetServiceInt;


@Controller
@RequestMapping("/ctl/skill")
public class SkillSetCtl extends BaseCtl {

	@Autowired
	private SkillSetServiceInt service;

	@ModelAttribute
	public void preload(Model model) {
		
		
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") SkillSetForm form,
			Model model) {
		if (form.getId() > 0) {
			SkillSetDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "skill";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") SkillSetForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/skill";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "skill";
				}

				SkillSetDTO bean = (SkillSetDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "SkillSet update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "SkillSet Added Successfully!!!!");
				}
				return "skill";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "skill";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") SkillSetForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/skill";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/skill";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					SkillSetDTO dto = new SkillSetDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		SkillSetDTO dto = (SkillSetDTO) form.getDTO();
		List<SkillSetDTO> list = service.search(dto, pageNo, pageSize);
		List<SkillSetDTO> totallist = service.search(dto);
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
		return "skillList";
	}
	
	

}
