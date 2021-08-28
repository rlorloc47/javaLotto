package lotto.spring.project.qna;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		List<QnaVO> qnaList = this.qnaService.qnaSelectList();
		model.addAttribute("qnaList", qnaList);
		
		return ".tiles/qna/qnaList";
	}
}
