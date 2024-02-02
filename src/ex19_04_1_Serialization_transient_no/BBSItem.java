// 생성자, 메서드, 정적 필드는 직렬화 대상이 아님
// 인스턴스 필드는 직렬화 대상
// transient 키워드 : 직렬화에서 제외 시킬 필드를 표시하는 키워드
// 실행 순서 : ObjectOutputExample3.java -> ObjectInputExample3

package ex19_04_1_Serialization_transient_no;
class BBSItem implements java.io.Serializable {
	static private int itemNum = 0;
	private String writer;
	private transient String passwd;
	private String title;
	private String content;
	
	// 생성자는 직렬화 대상이 되지 않음
	BBSItem(String writer, String passwd,String title, String content) {
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		itemNum++;
	}
	
	void modifyContent(String content, String passwd){
		if(!passwd.equals(this.passwd))
			return;
		this.content = content;
	}
	
	public String toString() {
		return "전체게시물의 수: "+ itemNum +
				"\n글쓴이: " + writer +
				"\n패스워드: " + passwd +
				"\n제목: "+title +
				"\n내용: "+content;
			
	}
}