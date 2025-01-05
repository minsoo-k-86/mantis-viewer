package com.messier219.mantis_viewer.bug;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 벅스 조회 컨트롤러
 * @author messier219
 */
@Controller
@RequiredArgsConstructor
public class BugController {

    private final BugService bugService;

    /**
     * 벅스 리스트 조회
     * @param model 모델
     * @return bugs
     */
    @GetMapping("/bugs")
    public String getBugs(Model model) {
        model.addAttribute("bugs", bugService.getBugs());
        return "bugs";
    }
}
