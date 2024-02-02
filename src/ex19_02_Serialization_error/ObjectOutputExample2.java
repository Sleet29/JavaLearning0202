// 객체를 직렬화하는 프로그램
/*
 * 직렬화 : 객체를 네트워크를 통해 전송하거나 파일에 저장하기 위해서 객체를 스트림으로 만드는 작업이 필요합니다.
 * 		  이런 작업을 자바에서는 객체의 직렬화(serialization)라고 합니다.
 * 		  즉, 직렬화는 객체를 바이트 형태로 변환하는 과정입니다.
 */

package ex19_02_Serialization_error;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
class ObjectOutputExample2 {
	public static void main(String args[]) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output2.dat"));
			out.writeObject(new GoodsStock("70101",100));
			out.writeObject(new GoodsStock("70102",50));
			out.writeObject(new GoodsStock("70103",200));
		} catch (IOException ioe) {
			ioe.printStackTrace(); // java.io.NotSerializableException
			System.out.println("파일을 출력할 수 없습니다.");
		}
		finally {
			try {
				if(out != null)
					out.close();
			}
			catch (IOException e) {
				System.out.println("파일을 닫는 중 오류 발생");
			}
		}
	}
}