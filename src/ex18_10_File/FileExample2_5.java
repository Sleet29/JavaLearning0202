package ex18_10_File;
// File 클래스를 디렉토리 생성
// 디렉토리 생성에 실패했습니다.
import java.io.File;
import java.io.IOException;

class FileExample2_5 {
	public static void main (String args[]) {
		String dir = "D:\\newDirectory\\test";
		
		File f2 = new File(dir);
		if(!f2.exists()) {
			//if(f2.mkdir()) { // 디렉토리 생성 - 생성되면 true, 실패하면 false
			if(f2.mkdirs()) { // mkdirs >> 중간 디렉토리도 생성
				System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath());
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else {
			System.out.println("이미 있는 디렉토리 이름 : "+f2.getPath());
		}
	}
}
