package com.messier219.mantis_viewer.bug;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 버그 조회 컨트롤러
 * @author messier219
 */
@Controller
@RequiredArgsConstructor
public class BugController {

    private final BugService bugService;

    /**
     * 버그 리스트 조회
     * @param model 모델
     * @return bugs 버그 리스트
     */
    @GetMapping("/")
    public String getBugs(Model model) {
        model.addAttribute("bugs", bugService.getBugs());
        return "bugs";
    }

    /**
     * 환경설정 (쿠키기반)
     * @param model 모델
     * @return 환경설정 페이지
     */
    @GetMapping("/config")
    public String config(Model model) {
        model.addAttribute("config");
        return "config";
    }
}
