package reverseStack;

import java.util.Stack;
import java.util.Stack;

public class ReverseStackByRecursion<T> {

	
	
	
	 
	    public static void stackReversal(Stack<Integer> s)
	    {
	      if(s.isEmpty())
	    	  return;
	      int a=getLast(s);
	      stackReversal(s);
	      s.push(a);
	    }
	 
	    public static int getLast(Stack<Integer> s)
	    {
	      int a=s.pop();
	      if(s.isEmpty())
	    	  return a;
	      else{
	    	 int k= getLast(s);
	    	  s.push(k);
	    	  return k;
	      }
	    }
	 
	    public static void main(String[] args)
	    {
	        Stack <Integer> stack = new Stack <Integer> ();
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        stackReversal(stack);
	        while(stack.size() > 0)
	        {
	            System.out.println(stack.pop());
	        }
	    }
	}

