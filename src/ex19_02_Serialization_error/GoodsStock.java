package ex19_02_Serialization_error;
// 직렬화 가능 클래스 만드는 예
class GoodsStock implements java.io.Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5699450046419990862L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String code;		// 상품 코드
	private int num;			// 재고 수령
	GoodsStock(String code,int num){
		this.code = code;
		this.num = num;
	}

	void addStock(int num) {
		this.num+=num;
	}
	
	int subtractStock(int num) throws Exception {
		if(this.num < num) 
			throw new Exception("재고가 부족합니다.");
		this.num -=num;
		return num;
	}
	
	public String toString() {
		return "상품코드:" + code + "\t상품수량:" + num;
	}
	
	
}
