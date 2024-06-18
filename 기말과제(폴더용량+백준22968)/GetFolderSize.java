package 기말과제;
import java.io.File;
import java.util.Scanner;

public class GetFolderSize {
   static int size=0;// 폴더의 크기를 저장할 변수
   static void getsize(Node a) {//폴더 크기를 구하는 메서드
      
      if (a == null) {
            return;
        }
      getsize(a.left);//왼쪽자손으로 이동 getsize()
      getsize(a.right);//오른쪽자손으로 이동
      size += a.file_size;//파일의 크기 더함(
      System.out.println(a.filename + " : " + a.file_size + " bytes");//디렉토리일 경우는 중복연산을 피하기위해
   }                                                                  //따로 구현하지 않았다.
   
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);// Scanner로 입력받기
      System.out.print("디렉토리 경로s를 입력하세요:");
      String root=s.nextLine();// 파일경로 입력받기
      File file=new File(root);// 파일 객체 생성(File 클래스 메소드를 사용하기 위함)//
      
      Node Top_Directory=new Node(file,root);//이진 트리 생성(디렉터리 구조가 이진이라는 조건)
      getsize(Top_Directory);//사이즈 쿠하기
      
      System.out.println("폴더의 크기는: "+size+" B(byte)");//byte 크기
      System.out.println("폴더의 크기는: "+size/1024+" KB(kilobyte)");//kilobyte 크기
      
      s.close();
   }
}
