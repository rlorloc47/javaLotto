package lotto.spring.project.qna;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public String qnaList(Locale locale, Model model, QnaVO qnaVO) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		
		System.out.println("나는야나는야확인용 : "+qnaVO.getGroup_seq());
		//21.09.05 qna_seq가 없을 경우, 자동으로 max 뽑기
		if(qnaVO.getGroup_seq() == 0) {
			int maxGroupSeq = this.qnaService.qnaMaxGroupSeq();
			qnaVO.setQna_seq(maxGroupSeq);
		}
		
		List<QnaVO> qnaList = this.qnaService.qnaSelectList(qnaVO);
		model.addAttribute("qnaList", qnaList);
		
		System.out.println("나는야"+qnaVO.getQna_seq());
		return ".tiles/qna/qnaList";
	}
	
	@RequestMapping(value = "/qnaInsert", method = RequestMethod.GET)
	public String qnaInsert(Locale locale, Model model, QnaVO qnaVO, RedirectAttributes redirectAttr) {
		//21.08.26 문의게시판 삽입 동작
		//21.09.05 원글(Q)일 경우, group_seq는 qna_seq와 동일 / 답글(A)일 경우, group_seq는 원글의 qna_seq와 동일
		if(qnaVO.getBoard_type().equals("Q")) {
			int max_qna_seq = this.qnaService.qnaMaxSeq();
			qnaVO.setQna_seq(max_qna_seq);
			qnaVO.setGroup_seq(qnaVO.getQna_seq());
		}else {
			int max_qna_seq = this.qnaService.qnaMaxSeq();
			qnaVO.setQna_seq(max_qna_seq);
			qnaVO.setGroup_seq(qnaVO.getGroup_seq());
		}
		
		System.out.println("나는야"+qnaVO.getGroup_seq());
		this.qnaService.qnaInsert(qnaVO);
		
		redirectAttr.addAttribute("group_seq", qnaVO.getGroup_seq());
		
		return "redirect:/qnaList";
	}
}
