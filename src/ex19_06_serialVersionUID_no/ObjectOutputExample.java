package ex19_06_serialVersionUID_no;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
class ObjectOutputExample {
	public static void main(String args[]) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output10.dat"));
			Rectangle obj = new Rectangle(100,200);
			System.out.println(obj);
			out.writeObject(obj);
			
		} catch (IOException ioe) {
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