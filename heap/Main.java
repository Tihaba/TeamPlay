package heap;

import java.util.Scanner;

public class Main {
	private int heap[];//배열
	private int N;//원소(노드)의 갯수
	private int result[];//삭제한 원소배열
	int zero=0;//출력갯수
	public Main(int size) {
		heap= new int[size+1];//0이 아니라 1부터 채우기 위함
		result=new int[heap.length];
		N=0;//원소(노드)의 갯수
	}
	public void insert(int x) {
		if(x==0) result[++zero]=delete();//0을 만나면 삭제
		else {
			N++;//원소(노드) 갯수 선증가
			heap[N]=x;//삽입(우선순위 큐 이므로 마지막에 삽입)
			percolate_up(N);//힙구조로 되도록 원소 재배치
		}
	}
	public void percolate_up(int i) //마지막 리프노드 추가 시
	{
		int parent=i/2;//부모 노드 인덱스
		if(parent>=1 && heap[i]<heap[parent]){//비교
			int temp=heap[parent]; //swap과정           
			heap[parent]=heap[i];
			heap[i]=temp;
			percolate_up(parent);//재귀호출로 완전히 배치될때까지
		}
	}

	public Integer delete() {//삭제후 반환
		if(isEmpty()) return 0;
		else {
			int min=heap[1];//최소값 저장
			heap[1]=heap[N--];//마지막 노드값 젤 위로 올려 삭제와 동시에 개수 감소
			percolate_down(1);//힙구조로 되도록 원소 재배치
			return min;
		}
	}
	
	public void percolate_down(int i) {//위에서 아래로 힙구조로 재배치
		int leftchild=i*2;// 왼쪽 자손 인덱스(default)
		int rightchild=i*2+1; //오른쪽 자손 인덱스
		if(leftchild<=N) {
			if(rightchild<=N && heap[leftchild]>heap[rightchild]) //오른쪽 자손이 왼쪽 자손보다 작은가?
				leftchild=rightchild;//leftchild를 디폴트로 잡았으니 왼쪽자손에 오른쪽자손 인덱스값 넣기
			if(heap[leftchild]<heap[i]) {//자식노드가 부모노드보다 작은경우
				int tmp=heap[i];//부모 자식 자리바꾸기
				heap[i]=heap[leftchild];
				heap[leftchild]=tmp;
				percolate_down(leftchild);//재귀호출로 완전히 배치될때까지
			}
		}
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
		int S;//입력값
		Main a= new Main(N);//힙생성
		for(int i=1; i<=N; i++) {//입력
			S=s.nextInt();
			a.insert(S);
		}
		a.Print();
		s.close();
	}
}
