import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node head = new Node('A', null, null);
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static void insertNode(Node tmp, char root, char left, char right) {
		if(tmp.data == root) {
			tmp.left = (left == '.' ? null : new Node(left, null, null));
			tmp.right = (right == '.' ? null : new Node(right, null, null));
		}
		else {
			if(tmp.left != null) insertNode(tmp.left, root, left, right);
			if(tmp.right != null) insertNode(tmp.right, root, left, right);
		}
	}
	
	//전위 순회
	static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//중위 순회
	static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	//후위 순회
	static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, data, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
		
	}

}