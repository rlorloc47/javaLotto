package lotto.spring.project.lottoPercentage;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PercentageController {
	@Autowired
	PercentageService percentageService;
	
	@RequestMapping(value = "/percentageList", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		List<PercentageVO> percentageList = this.percentageService.percentageSelectList();
		System.out.println("나는야"+percentageList.get(0).getBallList());
		model.addAttribute("percentageList", percentageList);
		return ".tiles/percentage/percentageList";
	}
}
