package ex19_02_Serialization_error;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

class ObjectInputExample2 {
    public static void main(String args[]) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("output2.dat"));
            while (true) {
                // 객체 역직렬화
                GoodsStock gs = (GoodsStock) in.readObject();
                System.out.println(gs);
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


