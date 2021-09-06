package lotto.spring.project;

public class PaggingMakerUtil {


	 /**
	  * 입력 받은 값으로 연산 후 페이징 문자열을 리턴한다.
	  *
	  * @param imgs [String Array]	: 이미지 배열 5개 [처음 이미지, ...... , 마지막 이미지]
	  * @param currentPage [String]	: 현재 페이지
	  * @param countPerPage [String]: 페이지당 보여줄 목록 수
	  * @param max [int]			: 최대값 (전체페이지 산출에 이용)
	  * @param link_url [String]	: 링크 문자열
	  **/
	
	//indexList( String[] imgs, 1,10, int numPerPagging, int max)
	public static String indexList( String[] imgs, int currentPage,
										int countPerPage, int numPerPagging, int max)
	{
		int current    = currentPage;
		int page       = numPerPagging;
		int totalPage  = ((max%countPerPage)>0)?(max/countPerPage)+1 : max/countPerPage; //전체 페이지
		
		int startpage  = 0;	//시작 페이지
		int endpage    = 0;	//끝 페이지
		int curpage    = 0;	//이동할 페이지
		
		String startImg  = (imgs[0] != null) ? "<img src='"+imgs[0]+"' border='0' />":" << ";
		String backImg   = (imgs[1] != null) ? "<img src='"+imgs[1]+"' border='0' />":" < ";
		String centerImg = (imgs[2] != null) ? "<img src='"+imgs[2]+"' border='0' />":"";
		String frontImg  = (imgs[3] != null) ? "<img src='"+imgs[3]+"' border='0' />":" > ";
		String endImg    = (imgs[4] != null) ? "<img src='"+imgs[4]+"' border='0' />":" >> ";

		StringBuffer pagingStr = new StringBuffer(); //리턴 문자열
		
		//시작페이지 번호 구하기
		startpage = ((current-1) / page) * page +1;
		
		//마지막 페이지 번호 구하기
		endpage= (((startpage-1)+page)/page) * page;
		
		// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우
		// 총 페이지 수가 마지막페이지 번호가 됨
		if (totalPage <= endpage) endpage = totalPage;
		
		if(current > 1){
			curpage = 1;
			pagingStr.append("<li class='space'><a href='#' onclick='movePage(");
			pagingStr.append(curpage);
			pagingStr.append(")'>");
			pagingStr.append(startImg);
			pagingStr.append("</a></li>");
		}else{
			pagingStr.append("<li class='space'>");
			pagingStr.append(startImg);
			pagingStr.append("</a></li>");
		}
		
		// 첫번째 페이지 인덱스 화면이 아닌경우
		if ( current > page ){
			curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
			pagingStr.append("<li class='space'><a href='#' onclick='movePage(");
			pagingStr.append(curpage);
			pagingStr.append(")'>");
			pagingStr.append(backImg);
			pagingStr.append("</a></li>");
		}else{
			pagingStr.append("<li class='space'>");
			pagingStr.append(backImg);
			pagingStr.append("</a></li>");			
		}
		
		pagingStr.append(" &nbsp;&nbsp;&nbsp;&nbsp; ");
		
		
		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;
		
		while (curpage <= endpage)
		{
			if (curpage == current) {
				pagingStr.append("<li><b>");
				pagingStr.append(current);
				pagingStr.append("</b></li>");
				pagingStr.append(centerImg);
			} else {
				pagingStr.append("<li><a href='#' onclick='movePage(");
				pagingStr.append(curpage);
				pagingStr.append(")'>");
				pagingStr.append(curpage);
				pagingStr.append("</a></li>");
				pagingStr.append(centerImg);
			}
			curpage++;
		}
		
		pagingStr.append(" &nbsp;&nbsp;&nbsp;&nbsp; ");
		
		
		// 뒤에 페이지가 더 있는경우
		if ( totalPage > endpage) {
			curpage = endpage + 1;
			pagingStr.append("<li class='space'><a href='#' onclick='movePage(");
			pagingStr.append(curpage);
			pagingStr.append(")'>");
			pagingStr.append(frontImg);
			pagingStr.append("</a></li>");
		}else{
			pagingStr.append("<li class='space'>");
			pagingStr.append(frontImg);
			pagingStr.append("</a></li>");			
		}
		
		// 마지막 페이지로의 이동
		if(current<totalPage){
			curpage=totalPage;
			pagingStr.append("<li class='space'><a href='#' onclick='movePage(");
			pagingStr.append(curpage);
			pagingStr.append(")'>");
			pagingStr.append(endImg);
			pagingStr.append("</a></li>");
		}else{
			pagingStr.append("<li class='space'>");
			pagingStr.append(endImg);
			pagingStr.append("</a></li>");					
		}

		return pagingStr.toString();
	}

}
