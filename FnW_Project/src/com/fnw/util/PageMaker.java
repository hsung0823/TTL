package com.fnw.util;

public class PageMaker {
	
	private int curPage;
	private int perPage;
	private int totalCount;
	private int perBlock;
	
	public PageMaker(int curPage, int totalCount) {
		this(curPage,10,totalCount);
	}
	
	public PageMaker(int curPage, int perPage, int totalCount) {
		this(curPage , perPage, totalCount, 5);
	}
	
	public PageMaker(int curPage, int perPage, int totalCount, int perBlock) {
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.perBlock = perBlock;
	}
	
	public MakeRow getMakeRow() {
		MakeRow makeRow = new MakeRow();
		
		int startRow =(this.curPage-1)*this.perPage+1;
		int lastRow = (this.curPage)*this.perPage;
		
		makeRow.setStartRow(startRow);
		makeRow.setLastRow(lastRow);
		
		return makeRow;
		
	}
	
	
	public MakePage getMakePage() {
		//1.totalCount 
		
		//2.totalPage
		int totalPage=0;
		if(totalCount%perPage==0) {
			totalPage= totalCount/perPage;
		}else {
			totalPage= totalCount/perPage+1;
		}
		
		//3.totalBlock
		int totalBlock=0;
		if(totalPage%perBlock==0) {
			totalBlock=totalPage/perBlock;
		}else {
			totalBlock=totalPage/perBlock+1;
		}
		
		//4.curBlock
		int curBlock=0;
		if(curPage%perBlock==0) {
			curBlock = curPage/perBlock;
		}else {
			curBlock = curPage/perBlock+1;
		}
		
		//5.startNum, lastNum
		int startNum = (curBlock-1)*perBlock+1;
		int lastNum = curBlock*perBlock;
		if(curBlock==totalBlock) {
			lastNum = totalPage;
		}
		MakePage makePage = new MakePage();
		makePage.setCurBlock(curBlock);
		makePage.setTotalBlock(totalBlock);
		makePage.setLastNum(lastNum);
		makePage.setStartNum(startNum);
		
		
		return makePage;
	}
		
}
