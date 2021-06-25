/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01.src.trabalho;

import java.util.Stack;

public class TreeN {

	public NodeN root;
	public int n;

	public TreeN(int n){
		this.n = n;
	}

	public void levelOrder() {
		Stack<NodeN> P = new Stack<NodeN>();
		P.add(root);
		while (!P.isEmpty()) {
			NodeN current = P.pop();
			if (current != null) {
				System.out.println(current);
				for (int i = current.childs.size() - 1 ; i >= 0 ; i-- )
				{
					P.add(current.childs.elementAt(i));
				}
			}
		}
	}
}