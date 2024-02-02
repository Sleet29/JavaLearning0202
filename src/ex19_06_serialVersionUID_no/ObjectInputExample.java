
package ex19_06_serialVersionUID_no;
import java.io.*;

class ObjectInputExample {
	public static void main(String args[]) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output10.dat"));
			Rectangle obj = (Rectangle) in.readObject();
			System.out.println("*** 역직렬화 합니다. ***");
			System.out.println(obj);
		} catch (FileNotFoundException fnfe) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (EOFException eofe) {
            System.out.println("끝.");
        } catch (IOException ioe) {
        	System.out.println(ioe.getMessage());
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