package 기말과제;

import java.io.File;

public class Node {
   String filename;//파일이름
   String file_root;//파일경로
   long file_size=0;//파일크기
   Node left=null; //왼쪽자식
   Node right=null;//오른쪽자식
   
   public Node(File file, String root) {//인자로 파일, 파일의 절대경로(이름포함)를 받음
      filename=file.getName();// 파일 이름 저장-getName메소드로 경로에서 이름 추출
      file_root=root; //파일의 절대경로를 저장
      
      if(file.isFile())//파일일 경우
         file_size=file.length();//파일의 크기를 저장(length()메소드 참고)
      else{// 디렉토리 일경우
         String filelist[]=file.list();//현 디렉토리에있는 파일을 list에저장(list()메소드 참고)
         //System.out.print(filename+"의 서브 파일은");
         //for(String s: filelist)
        //	 System.out.print(" "+s);
         //System.out.println();
         if(filelist!= null) {//디렉토리가 비어있지 않을 경우
            if(filelist.length==2) {//디렉토리안 파일이 2개 있을 경우
               left=new Node(new File(file_root+"\\"+filelist[0]), file_root+"\\"+filelist[0]);//생성
               right=new Node(new File(file_root+"\\"+filelist[1]), file_root+"\\"+filelist[1]);//생성
            }
            else if(filelist.length==1) //파일이 1개있을 경우
               left=new Node(new File(file_root+"\\"+filelist[0]), file_root+"\\"+filelist[0]);//생성
         }
      }
   }
}
