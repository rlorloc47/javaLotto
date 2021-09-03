package lotto.spring.project.lottoSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LottoSearchController {
	@Autowired
	LottoSearchService lottoSearchService;
	
	//21.09.03 페이지 처리
	private int pageSize; // 게시 글 수
	
	@RequestMapping(value = "/percentageList", method = RequestMethod.GET)
	public String percentageList(Locale locale,Model model, LottoSearchVO lottoSearchVO) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		List<LottoSearchVO> percentageList = null;
		percentageList = this.lottoSearchService.percentageSelectList(lottoSearchVO);
		
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonFirst = new JSONArray();
		jsonFirst.add("로또숫자");
		jsonFirst.add("횟수");
		jsonArray.add(jsonFirst);
		
		for(int a=0;a<percentageList.size();a++) {
			JSONArray jsonCell = new JSONArray();
			jsonCell.add(Integer.toString(percentageList.get(a).getBall_number()));
			jsonCell.add(percentageList.get(a).getBallCount());
			jsonArray.add(jsonCell);
		}
		
		model.addAttribute("percentageVO",lottoSearchVO);
		model.addAttribute("percentageList", percentageList);
		model.addAttribute("jsonArray", jsonArray);

		return ".tiles/lottoSearch/percentageList";
	}
	
	@RequestMapping(value = "/lottoSearchList", method = RequestMethod.GET)
	public String searchLottoList(Locale locale,Model model, LottoSearchVO lottoSearchVO) {
		//21.09.03 복권 조회 페이지로 이동
		int totalCount = this.lottoSearchService.lottoSearchCount(lottoSearchVO);
		
		if (lottoSearchVO.getPageNo() == 0) lottoSearchVO.setPageNo(1); // 기본 값 설정
		if (this.pageSize == 0) this.setPageSize(10); // 기본 값 설정
		int finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지
		int startPage = ((lottoSearchVO.getPageNo() - 1) / 10) * 10 + 1; // 시작 페이지 (페이징 네비 기준)
        int endPage = startPage + 10 - 1; // 끝 페이지 (페이징 네비 기준)
        
        model.addAttribute("finalPage", finalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        
        lottoSearchVO.setLimitStartPage((lottoSearchVO.getPageNo()-1)*10);
        lottoSearchVO.setLimitEndPage(this.pageSize);
		
		
		List<LottoSearchVO> lottoSearchList = null;
		lottoSearchList = this.lottoSearchService.lottoSearchList(lottoSearchVO);
		
		model.addAttribute("lottoSearchList", lottoSearchList);
		
		return ".tiles/lottoSearch/lottoSearchList";
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
