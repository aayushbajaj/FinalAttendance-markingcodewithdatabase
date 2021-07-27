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

import in.co.attendance.marking.dto.TrainerDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.TrainerForm;
import in.co.attendance.marking.service.TrainerServiceInt;
import in.co.attendance.marking.service.SessionServiceInt;
import in.co.attendance.marking.service.SkillSetServiceInt;


@Controller
@RequestMapping("/ctl/trainer")
public class TrainerCtl extends BaseCtl {

	@Autowired
	private TrainerServiceInt service;
	
	@Autowired
	private SkillSetServiceInt skillService;

	@Autowired
	private SessionServiceInt sessionService;
	
	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("skillList",skillService.search(null));
		model.addAttribute("sessionList",sessionService.search(null));
	}

	@GetMapping
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") TrainerForm form,
			Model model) {
		if (form.getId() > 0) {
			TrainerDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "trainer";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") TrainerForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/trainer";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "trainer";
				}

				TrainerDTO bean = (TrainerDTO) form.getDTO();
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Trainer update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Trainer Added Successfully!!!!");
				}
				return "trainer";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "trainer";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TrainerForm form, @RequestParam(required = false) String operation,
			Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/trainer";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/trainer";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					TrainerDTO dto = new TrainerDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		TrainerDTO dto = (TrainerDTO) form.getDTO();
		List<TrainerDTO> list = service.search(dto, pageNo, pageSize);
		List<TrainerDTO> totallist = service.search(dto);
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
		return "trainerList";
	}
	
	

}
