package com.china.terry.model;

import java.util.ArrayList;

public class FindListCount {

	 // 原始数据data。假设data数组中的数据元素已经按照某种顺序排好。  
    // 但是，该数组中的数据元素重复出现。  
    // 我们的目的是查找、解析data数组中重复出现的某元素。  
    // 比如，在这个data数组中，元素'C'在数组位置2,3重复出现两次。  
    // 注意！有些元素没有重复出现，比如元素'B'。  
    private String[] data = { "A", "A", "B", "C", "C", "D", "D", "D" };  
  
    // 存储分类好的数据元素。  
    private ArrayList<Group> groups = new ArrayList<Group>();  
  
    // 核心的算法实现。  
    public void find() {  
  
        // 游标index  
        int index = 0, j = 0;  
  
        while (index < data.length) {  
            Group group = new Group();  
            group.title = data[index];  
              
            String t = group.title;  
  
            ArrayList<String> children = new ArrayList<String>();  
  
            for (j = index; j < data.length; j++) {  
  
                String child = data[j];  
                if (t.equals(child)) {  
                    // 同时记录该重复出现的元素在原数组中的下标j，便于查验、评估结果。  
                    children.add(child + "@" + j);  
                } else {  
                    break;  
                }  
            }  
  
            // 往后推进游标index  
            index = j;  
  
            group.children = children;  
            groups.add(group);  
        }  
    }  
  
    // 输出结果。  
    private void print() {  
        for (int i = 0; i < groups.size(); i++) {  
            Group g = groups.get(i);  
            System.out.println(g);  
        }  
    }  
  
    // 自己构造一个类，作为一组数据的容器。  
    // 该类用一个title表明这一group数据是归属于那个重复元素的组。  
    // 该title下重复的元素装入到ArrayList<String> children中，供遍历查询。  
    private class Group {  
        public String title;  
        public ArrayList<String> children;  
  
        // 结果。  
        @Override  
        public String toString() {  
            String str = "组" + title + ": ";  
            for (int i = 0; i < children.size(); i++) {  
                str += children.get(i) + " ";  
            }  
  
            return str;  
        }  
    }  
  
    public static void main(String args[]) {  
    	FindListCount t = new FindListCount();  
        t.find();  
        t.print();  
    }  
}