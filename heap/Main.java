package heap;

import java.util.Scanner;

public class Main {
	private int heap[];//배열
	private int N;//원소(노드)의 갯수
	private int result[];//삭제한 원소배열
	int num=0;//result 인덱스
	int zero=0;//출력갯수
	public Main(int size) {
		heap= new int[size+1];//0이 아니라 1부터 채우기 위함
		result=new int[heap.length];
		N=0;//원소(노드)의 갯수
	}
	public void insert(int x) {
		if(x==0) {result[++num]=delete(); zero++;}//0을 만나면 삭제
		else {
			N++;//원소(노드) 갯수 선증가
			heap[N]=x;//삽입(우선순위 큐 이므로 마지막에 삽입)
			percolate_up(N);//힙구조로 되도록 원소 재배치
		}
	}
	public void percolate_up(int i) {//아래부터 위로 힙구조로 재배치

	}
	
	public Integer delete() {//삭제후 반환

	}
	
	public void percolate_down(int i) {//위에서 아래로 힙구조로 재배치

	}
	
	public boolean isEmpty() {//비었는지 true false
		return N==0;
	}

	
	public void Print() {//출력부
		for(int i=1; i<=zero; i++)
			System.out.println(result[i]);
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int N=s.nextInt();//입력개수 받음
		int S;
		Main a= new Main(N);
		for(int i=1; i<=N; i++) {
			S=s.nextInt();
			a.insert(S);
		}
		a.Print();
		s.close();
	}

}
