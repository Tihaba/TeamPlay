import java.util.Scanner;

public class Main {

	public static int Find_H(int node) {
		if(node==1)//정점(노드)이 1개일때
			return 1; //최대 높이가 1 이다.
		else if(node==2)//정점(노드)가 2개일때
			return 2;	//최대 높이가 2이다.
		else {
			int h;//높이
			for( h=3; f(h)<=node; h++) {}//h구하기
			return --h;//결과높이 반환
		}
	}
	public static int f(int h){// 높이 h를 만들기위해 필요한 최소 정점(노드)의 갯수를 반환하는 메소드
		int Min_required_node[]=new int[50];//높이 h에 대해 최소 필요한 노드갯수(V범위가 정해져있어 크기는 50으로 충분)
		Min_required_node[1]=1;//인덱스는 높이에 대응하고 배열값은 최소필요 노드갯수에 대응한다.
		Min_required_node[2]=2;
		for(int i=3; i<=h; i++)
			Min_required_node[i]=Min_required_node[i-1]+Min_required_node[i-2]+1;
		return Min_required_node[h];//높이 h에대한 최소 필요노드갯수 반환
	}

	public static void main(String[] args) {	
		Scanner T= new Scanner(System.in);// 케이스 갯수 입력 (1<= T <= 1,000)
										  // 정점(노드)의 갯수 입력 (1<= V <=1,000,000,000)
		int result[] = new int[T.nextInt()+1];//결과값 저장
		
		for(int i=1; i<result.length; i++)  //입력
			result[i]=Find_H(T.nextInt());//정점(노드) 갯수 입력

		for(int i=1; i<result.length; i++)//출력부
			System.out.println(result[i]);
		T.close();

	}s
}
