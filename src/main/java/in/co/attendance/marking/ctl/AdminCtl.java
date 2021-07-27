package in.co.attendance.marking.ctl;

 

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

 

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;
import in.co.attendance.marking.form.AdminForm;
import in.co.attendance.marking.service.AdminServiceInt;

 

 

@Controller
@RequestMapping("/ctl/admin")
public class AdminCtl extends BaseCtl {

 

@Autowired
private AdminServiceInt service;

 

@ModelAttribute
public void preload(Model model) {

HashMap<String, String> map = new HashMap<String, String>();
map.put("Male", "Male");
map.put("Female", "Female");
model.addAttribute("gender", map);

HashMap<String, String> map2 = new HashMap<String, String>();
map2.put("Pending", "Pending");
map2.put("Cancel", "Cancel");
map2.put("Approve", "Approve");
model.addAttribute("stautsMap", map2);
}

 

@GetMapping("/au-admin")
public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") AdminForm form,
Model model) {
if (form.getId() > 0) {
AdminDTO bean = service.findBypk(id);
form.populate(bean);
}
return "admin";
}

 

@PostMapping("/au-admin")
public String submit(@Valid @ModelAttribute("form") AdminForm form,
BindingResult bindingResult, Model model) {

 

if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
return "redirect:/ctl/admin/au-admin";
}

 

try {
if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

 

if (bindingResult.hasErrors()) {
return "admin";
}

 

AdminDTO bean = (AdminDTO) form.getDTO();
bean.setRoleId(2L);
if (bean.getId() > 0) {
service.update(bean);
model.addAttribute("success", "Admin update Successfully!!!!");
} else {
service.add(bean);
model.addAttribute("success", "Admin Added Successfully!!!!");
}
return "admin";
}
} catch (DuplicateRecordException e) {
model.addAttribute("error", e.getMessage());
return "admin";
}
return "";
}

 

@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
public String searchList(@ModelAttribute("form") AdminForm form, @RequestParam(required = false) String operation,
Long vid, HttpSession session, Model model) {

 

if (OP_RESET.equalsIgnoreCase(operation)) {
return "redirect:/ctl/admin/search";
}

 

int pageNo = form.getPageNo();
int pageSize = form.getPageSize();

 

if (OP_NEXT.equals(operation)) {
pageNo++;
} else if (OP_PREVIOUS.equals(operation)) {
pageNo--;
} else if (OP_NEW.equals(operation)) {
return "redirect:/ctl/admin/au-admin";
}

 

pageNo = (pageNo < 1) ? 1 : pageNo;
pageSize = (pageSize < 1) ? 10 : pageSize;

 

if (OP_DELETE.equals(operation)) {
pageNo = 1;
if (form.getIds() != null) {
for (long id : form.getIds()) {
AdminDTO dto = new AdminDTO();
dto.setId(id);
service.delete(dto);
}
model.addAttribute("success", "Deleted Successfully!!!");
} else {
model.addAttribute("error", "Select at least one record");
}
}
AdminDTO dto = (AdminDTO) form.getDTO();
dto.setRoleId(2L);
List<AdminDTO> list = service.search(dto, pageNo, pageSize);
List<AdminDTO> totallist = service.search(dto);
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
return "adminList";
}
 

 

}