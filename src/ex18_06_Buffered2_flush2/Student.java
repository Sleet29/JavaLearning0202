package ex18_06_Buffered2_flush2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    public Student(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public int getTotal() {
        return korScore + engScore + mathScore;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    @Override
    public String toString() {
        return name + "\t" + korScore + "\t" + engScore + "\t" + mathScore + "\t" + getTotal() + "\t" + String.format("%.1f", getAverage());
    }

    public static void main(String args[]) {
        input();
    }
    
	static void input() {
		ArrayList<Student> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("jumsu.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int korScore = Integer.parseInt(parts[1]);
                int engScore = Integer.parseInt(parts[2]);
                int mathScore = Integer.parseInt(parts[3]);

                Student student = new Student(name, korScore, engScore, mathScore);
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		// - BufferedReader의 readLine()을 이용해서 한 줄씩 읽어 옵니다.
	  //   더 이상 읽을 데이터가 없으면 null을 리턴합니다.
	  
	      print(list);
	      // 1. 한줄씩 읽어온다
	      // 2. 이름, 국어, 영어, 수학 구분한다. split() -> String[] /StringTokenizer
	      // 3. 객체 생성 한다.
	      // 4. 컬렉션에 담는다.
	      
	}

	static void print(ArrayList<Student> list) {
        System.out.println("==========    학생별   /  과목별 총점구하기  ==========");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");

        for (Student s : list) {
            System.out.println(s.toString());
        }

        for (int j = 0; j < 50; j++) {
            System.out.print("=");
        }

        int korTotal = list.stream().mapToInt(Student::getKorScore).sum();
        int engTotal = list.stream().mapToInt(Student::getEngScore).sum();
        int mathTotal = list.stream().mapToInt(Student::getMathScore).sum();

        System.out.print("\n총점\t");
        System.out.print(korTotal + "\t");
        System.out.print(engTotal + "\t");
        System.out.print(mathTotal + "\t");
    }
	
	public int getKorScore() {
        return korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public int getMathScore() {
        return mathScore;
    }
}


/*
* 다음 조건을 만족하는 input()을 완성해 주세요

1. input()에서는 
    BufferedReader의 readLine()를 이용해서 아래의 파일안의 데이터를 읽어 들인 후 처리합니다.

<jumsu.txt>    
이승기 100 70 80
강호동 98 100 20
윤하하 50 60 78
유재석 80 70 80
홍길동 80 80 80
-----------------------------------------------------
public static void main(String args[]) {
	input();
}

static void input() {
   - BufferedReader의 readLine()을 이용해서 한 줄씩 읽어 옵니다.
     더 이상 읽을 데이터가 없으면 null을 리턴합니다.
  
      print(list);
      
     
  
}

static void print(ArrayList<Student> list) {
		System.out.println("==========    학생별   /  과목별 총점구하기  ==========");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");

		for (Student s : list) {
			System.out.println(s.toString());
		}

		for (int j = 0; j < 50; j++) {
			System.out.print("=");
		}

		System.out.print("\n총점\t");
		System.out.print(Student.korTotal + "\t");
		System.out.print(Student.engTotal+ "\t");
		System.out.print(Student.mathTotal + "\t");

	}
}

---------------------------------------------------------------------
2. 출력결과
==========    학생별   /  과목별 총점구하기  ==========
이름		국어		영어		수학		총점		평균
이승기	100		70		80		250		83.3
강호동	98		100		20		218		72.7
윤하하	50		60		78		188		62.7
유재석	80		70		80		230		76.7
홍길동	80		80		80		240		80.0
==================================================
총점		408		380		338
 */

/*
 * import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    public Student(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public int getTotal() {
        return korScore + engScore + mathScore;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    @Override
    public String toString() {
        return name + "\t" + korScore + "\t" + engScore + "\t" + mathScore + "\t" + getTotal() + "\t" + String.format("%.1f", getAverage());
    }

    public static void main(String args[]) {
        input();
    }

    static void input() {
        ArrayList<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("jumsu.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int korScore = Integer.parseInt(parts[1]);
                int engScore = Integer.parseInt(parts[2]);
                int mathScore = Integer.parseInt(parts[3]);

                Student student = new Student(name, korScore, engScore, mathScore);
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        print(list);
    }

    static void print(ArrayList<Student> list) {
        System.out.println("==========    학생별   /  과목별 총점구하기  ==========");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");

        for (Student s : list) {
            System.out.println(s.toString());
        }

        for (int j = 0; j < 50; j++) {
            System.out.print("=");
        }

        int korTotal = list.stream().mapToInt(Student::getKorScore).sum();
        int engTotal = list.stream().mapToInt(Student::getEngScore).sum();
        int mathTotal = list.stream().mapToInt(Student::getMathScore).sum();

        System.out.print("\n총점\t");
        System.out.print(korTotal + "\t");
        System.out.print(engTotal + "\t");
        System.out.print(mathTotal + "\t");
    }

    public int getKorScore() {
        return korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public int getMathScore() {
        return mathScore;
    }
}

 */
	
