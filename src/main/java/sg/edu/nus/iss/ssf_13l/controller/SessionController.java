package sg.edu.nus.iss.ssf_13l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;




@Controller
@RequestMapping("/session")
public class SessionController {
    
    @GetMapping("/firstpage")
    public String firstPage() {
        return "pageA";
    }

    @PostMapping("/firstpage")
    public String postFirstPage(@RequestBody MultiValueMap<String, String> entity, HttpSession session, Model model) {
        String name = entity.getFirst("name");
        session.setAttribute("sessionName", name);
        model.addAttribute("modelName", name); //Inject into the form
        return "pageB";
    }
    
    @GetMapping("/thirdpage")
    public String thirdPage(HttpSession session, Model model) {
        if (session.getAttribute("sessionName") == null)
            return "redirect:/session/firstpage";
        model.addAttribute("modelName", session.getAttribute("sessionName"));
        return "pageC";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session, Model model) {
        session.invalidate();
        return "redirect:/session/firstpage";
    }
    
}
