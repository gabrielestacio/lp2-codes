/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.Stack;

public class NodeN {

	public int value;

	public Stack<NodeN> childs = new Stack<NodeN>();;


	public NodeN(int value) {
		this.value = value;

	}

	public String toString() {
		return Integer.toString(value);
	}
	
}

