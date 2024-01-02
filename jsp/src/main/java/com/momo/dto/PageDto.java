package com.momo.dto;

public class PageDto {
	
	//페이지네이션을 그리기 위해 필요한 정보
	int startNo;			//페이지 블럭 시작번호
	int endNo;				//페이지 블럭 끝번호
	int realEnd;			//게시물의 끝 페이지 번호(총 게시물의 수/페이짇ㅇ 게시물수)
	boolean prev, next;		//이전,다음 버튼(true : 보여주기)
	
	//위의 정보들을 세팅하기 위해 필요한 값
	int totalCnt;			//총 게시물의 수
	Criteria cri;			//요청 페이지 번호, 페이지당 게시물수
	int blockAmount = 10;	//페이지 블럭에 보여줄 페이지수
	/**
	 * 생성자를 통해페이지 블럭을 그리기 위한 정보를 세팅함.
	 * 
	 * @param totalCnt
	 * @param cri
	 * @param blockAmount
	 */
	
	public PageDto(int totalCnt, Criteria cri, String blockAmount) {
		//생성자 호출
		this(totalCnt,cri);
		
		if(blockAmount != null && !"".equals(blockAmount)) {
			this.blockAmount = Integer.parseInt(blockAmount);
		}
	}
	public PageDto(int totalCnt, Criteria cri) {
		
		this.totalCnt = totalCnt;
		this.cri = cri;
		
		//페이지 블럭의 끝번호를 구합니다.
		//요청 페이지, 블럭당 페이지수에 따라서 블럭의 범위가 정해짐.
		//1~10,11~20
		//올림(7/10.0) = 1*blockAmount = 10
		//페이지 블럭의 시작번호, 끝번호
		endNo = (int)Math.ceil(cri.getPageNo()/(blockAmount*1.0))*blockAmount;
		startNo = endNo-(blockAmount-1);
		
		//페이지 끝번호
		realEnd = (int)Math.ceil((totalCnt*1.0)/cri.getAmount());
		
		//게시물이 67건인 경우,페이지 진짜 끝번호는 7인데 블럭의 끝번호는 10입니다.
		//끝번호가 게시물의 진짜 긑번호보다 큰 경우 : 작은 경우
		endNo = endNo > realEnd ? realEnd : endNo;
		//앞으로 가기 버튼 뒤로 가기 버튼 설정
		prev = startNo ==1 ? false : true;
		next = endNo == realEnd ? false : true;
		
		System.out.println("시작번호 : " + startNo);
		System.out.println("끝번호 : " + endNo);
		System.out.println("진짜 끝 번호 : " + realEnd);
		System.out.println("prev : " + prev);
		System.out.println("next : " + next);
		System.out.println("요청 페이지 번호 : " + cri.getPageNo());
		System.out.println("페이지당 게시물 수 : " + cri.getAmount());
		System.out.println("총 게시물 수 : " + totalCnt);
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
}
