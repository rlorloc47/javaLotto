package lotto.spring.project.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lotto.spring.project.PaggingMakerUtil;

@Controller
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public String qnaList(Locale locale, Model model, QnaVO qnaVO) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		int totalCount = this.qnaService.qnaTotalCount(qnaVO);
		
		int countPerPage = 1;
		int numPerPagging = 10;
		String[] imgs = { null, null, null, null, null };

		if (qnaVO.getPageNo() < 1) {
			qnaVO.setPageNo(1);
		}
		//21.09.04 페이지번호는 동일하고 검색어가 바뀌었을 떄, totalCount보다 넘은 페이지일 경우 방지
		//예시) 바뀐 검색어 때문에 totalCount는 5개인데 페이지번호는 2일경우 리스트에 표시되는 내용이 없음.
		if (totalCount <= (qnaVO.getPageNo()-1) * countPerPage) {
			qnaVO.setPageNo(1);
		}
		qnaVO.setLimitStartPage((qnaVO.getPageNo() - 1) * countPerPage);
		qnaVO.setLimitEndPage(countPerPage);
		model.addAttribute("pagingStr",(PaggingMakerUtil.indexList(imgs, qnaVO.getPageNo(), countPerPage, numPerPagging, totalCount)));
		
		int group_seq = this.qnaService.qnaSelectGroupSeq(qnaVO);
		qnaVO.setGroup_seq(group_seq);
		
		List<QnaVO> qnaList = this.qnaService.qnaSelectList(qnaVO);
		
		model.addAttribute("qnaList", qnaList);
		
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
		
		this.qnaService.qnaInsert(qnaVO);
		
		redirectAttr.addAttribute("group_seq", qnaVO.getGroup_seq());
		
		return "redirect:/qnaList";
	}
	
	@RequestMapping(value = "/qnaModify", method = RequestMethod.GET)
	public String qnaModify(Locale locale, Model model, QnaVO qnaVO, RedirectAttributes redirectAttr) {
		//21.09.08 문의게시판 수정 동작
		this.qnaService.qnaModify(qnaVO);
		
		redirectAttr.addAttribute("group_seq", qnaVO.getGroup_seq());
		
		return "redirect:/qnaList";
	}
	
	@RequestMapping(value = "/qnaDel", method = RequestMethod.GET)
	public String qnaDel(Locale locale, Model model, QnaVO qnaVO, RedirectAttributes redirectAttr) {
		//21.09.08 문의게시판 삭제 동작
		this.qnaService.qnaDel(qnaVO);
		
		redirectAttr.addAttribute("group_seq", qnaVO.getGroup_seq());
		
		return "redirect:/qnaList";
	}
	
	@RequestMapping(value = "/qnaCheckPasswdAjax", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> qnaCheckPasswdAjax(Model model, QnaVO qnaVO){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		QnaVO qnaVO_one = this.qnaService.qnaSelect(qnaVO);
		
		//21.09.09 패스워드 값이 동일할 경우, "Y" 반납
		if(qnaVO.getPasswd().equals(qnaVO_one.getPasswd())) {
			resultMap.put("checkYN", "Y");
		}else {
			resultMap.put("checkYN", "N");
		}
		return resultMap;
	}
}
