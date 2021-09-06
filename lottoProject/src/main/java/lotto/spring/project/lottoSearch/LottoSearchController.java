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

import lotto.spring.project.PaggingMakerUtil;

@Controller
public class LottoSearchController {
	@Autowired
	LottoSearchService lottoSearchService;
	
	//21.09.03 페이지 처리
	private int pageSize; // 게시 글 수
	
	@RequestMapping(value = "/percentageList", method = RequestMethod.GET)
	public String percentageList(Locale locale,Model model, LottoSearchVO lottoSearchVO) {
		//21.08.26 문의게시판 리스트 페이지로 이동
		System.out.println("나는야나는야화와ㅣㅁ뇌ㅏㅘㅣ");
		if(lottoSearchVO.getSearchNumber()!=null) {
			String[] SearchNumberList = lottoSearchVO.getSearchNumber().split(",");
			lottoSearchVO.setSearchNumberCount(SearchNumberList.length);
		}else {
			lottoSearchVO.setSearchNumberCount(45);
		}
		List<LottoSearchVO> percentageList = null;
		percentageList = this.lottoSearchService.percentageSelectList(lottoSearchVO);
		
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArrayCell = new JSONArray();
		for(int b=0;b<percentageList.size();b++) {
			if((b+1)%5==1) {
				JSONArray jsonFirst = new JSONArray();
				jsonArrayCell = new JSONArray();
				jsonFirst.add("로또숫자");
				jsonFirst.add("횟수");
				jsonArrayCell.add(jsonFirst);
			}
			
			JSONArray jsonCell = new JSONArray();
			jsonCell.add(Integer.toString(percentageList.get(b).getBall_number()));
			jsonCell.add(percentageList.get(b).getBallCount());
			jsonArrayCell.add(jsonCell);
			
			if((b+1)%5==0 || (b+1)==percentageList.size()) {
				System.out.println("나는야 확인용 : "+jsonArrayCell.toString()+"//"+b);
				jsonArray.add(jsonArrayCell);
			}
		}
		System.out.println("나는야나는야"+jsonArray.toString());
		
		model.addAttribute("percentageVO",lottoSearchVO);
		model.addAttribute("percentageList", percentageList);
		model.addAttribute("jsonArray", jsonArray);

		return ".tiles/lottoSearch/percentageList";
	}
	
	@RequestMapping(value = "/lottoSearchList", method = RequestMethod.GET)
	public String searchLottoList(Locale locale,Model model, LottoSearchVO lottoSearchVO) {
		//21.09.03 복권 조회 페이지로 이동
		int totalCount = this.lottoSearchService.lottoSearchCount(lottoSearchVO);
		
		int countPerPage = 10;
		int numPerPagging = 10;
		String[] imgs = { null, null, null, null, null };

		if (lottoSearchVO.getPageNo() < 1) {
			lottoSearchVO.setPageNo(1);
		}
		//21.09.04 페이지번호는 동일하고 검색어가 바뀌었을 떄, totalCount보다 넘은 페이지일 경우 방지
		//예시) 바뀐 검색어 때문에 totalCount는 5개인데 페이지번호는 2일경우 리스트에 표시되는 내용이 없음.
		if (totalCount <= (lottoSearchVO.getPageNo()-1) * 10) {
			lottoSearchVO.setPageNo(1);
		}
		lottoSearchVO.setLimitStartPage((lottoSearchVO.getPageNo() - 1) * countPerPage);
		lottoSearchVO.setLimitEndPage(countPerPage);
		model.addAttribute("pagingStr",(PaggingMakerUtil.indexList(imgs, lottoSearchVO.getPageNo(), countPerPage, numPerPagging, totalCount)));
        
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
