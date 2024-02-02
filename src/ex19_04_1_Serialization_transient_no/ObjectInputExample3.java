// 객체를 직렬화하는 프로그램
/*
 * 직렬화 : 객체를 네트워크를 통해 전송하거나 파일에 저장하기 위해서 객체를 스트림으로 만드는 작업이 필요합니다.
 * 		  이런 작업을 자바에서는 객체의 직렬화(serialization)라고 합니다.
 * 		  즉, 직렬화는 객체를 바이트 형태로 변환하는 과정입니다.
 */

package ex19_04_1_Serialization_transient_no;
import java.io.*;

class ObjectInputExample3 {
	public static void main(String args[]) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output4.dat"));
			while (true) {
				BBSItem obj = (BBSItem) in.readObject();
				System.out.println(obj.toString());
			}
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (EOFException eofe) {
            System.out.println("끝.");
        } catch (IOException ioe) {
            System.out.println("파일을 읽을 수 없습니다.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스가 존재하지 않습니다.");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.out.println("파일을 닫는 중 오류 발생");
            }
        }
	}
}