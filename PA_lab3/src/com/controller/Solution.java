package com.controller;


import com.Pair;

import java.util.Stack;

public class Solution {
    Stack solution;
    Stack steps;
    public Solution(){
        solution=new Stack();
    }
    public void buildSteps(){
        steps=new Stack();
        Stack tempSolution=new Stack();
        tempSolution=solution;
        while (!solution.isEmpty()){
            steps.push(tempSolution.pop());
        }
    }
    public void push(Pair p){
        solution.push(p);
    }
    public Pair pop(){
        return (Pair) solution.pop();
    }
    public Pair peek(){
        return (Pair) solution.peek();
    }
    public Stack getSteps(){
        return steps;
    }
}
