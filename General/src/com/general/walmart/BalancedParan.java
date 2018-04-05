package com.general.walmart;

import java.util.Stack;

public class BalancedParan 
{
	private static Stack<Character> stack=new Stack<>();
     
    private static boolean isPair(char char1, char char2)
    {
       if (char1 == '(' && char2 == ')')
         return true;
       else if (char1 == '{' && char2 == '}')
         return true;
       else if (char1 == '[' && char2 == ']')
         return true;
       else
         return false;
    }
     
    private static boolean areParenthesisBalanced(char exp[]){
       for(int i=0;i<exp.length;i++){
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
            stack.push(exp[i]);
      
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']'){
             if (stack.isEmpty())
                   return false;
             else if ( !isPair(stack.pop(), exp[i]) )
                   return false;
          }
       }
       if (stack.isEmpty())
    	   return true;
       else
    	   return false;
    } 
     
    public static void main(String[] args) 
    {
        char exp[] = {'{','(',')','}','[',']'};
          if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
          else
            System.out.println("Not Balanced ");  
    }
 
}