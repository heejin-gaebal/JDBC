package com.kh.app.board;

public class BoardVo {
	private String no;
	private String title;
	private String content;
	private String createdDate;
	private String delYn;
	
	public BoardVo(String no, String title, String content, String createdDate, String delYn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.delYn = delYn;
	}	
	
	public BoardVo(){
		
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "Boardvo [no=" + no + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate
				+ ", delYn=" + delYn + "]";
	}
}
