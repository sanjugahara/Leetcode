package com.daimens.algorithm.february;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Demon Song
 * 341.Flatten Nested List Iterator
 * Given a nested list of integers,implement an iterator to flatten it.
 * Each element is either an integer,or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1]
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false,the order of elements returned by next should be: [1,4,6]
 *
 */
public class SolutionDay22_341 implements Iterator<Integer>{
	
	private Stack<NestedInteger> stack = new Stack<>();

	public SolutionDay22_341(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			for (int i = curr.getList().size() - 1; i >= 0; i--) {
				stack.push(curr.getList().get(i));
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

}

interface NestedInteger {
	
	public boolean isInteger();
	
	public Integer getInteger();
	
	public List<NestedInteger> getList();
}
