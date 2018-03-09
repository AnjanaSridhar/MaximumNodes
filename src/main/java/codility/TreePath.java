package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
* This programs checks teh weight of each node in a path of a tree
* and returns the least number of repeated weights
* */
public class TreePath {
    public int solution(Tree T) {
        HashSet nodes = new HashSet();
        List<Integer> paths = new ArrayList<>();
        if(T!=null){
            nodes.add(T.x);
            return findDistinctValues(T, nodes, paths);
        }
        return 0;
    }

    public int findDistinctValues(Tree t, HashSet<Integer> nodes, List<Integer> paths){
        if(t==null) return 0;

        if(t.l==null && t.r==null){
            nodes.add(t.x);
            paths.add((int) nodes.stream().count());
            nodes.clear();
            nodes.add(t.x);
        }
        else {
            nodes.add(t.x);
            if(t.l!=null)
                findDistinctValues(t.l, nodes, paths);
            if(t.r!=null)
                findDistinctValues(t.r, nodes, paths);
        }

        Collections.sort(paths);
        return paths.get(paths.size()-1);
    }

    public static void main(String args[]){
        Tree tree1 = new Tree();
        tree1.x = 5;

        Tree tree2 = new Tree();
        tree2.l = tree1;
        tree2.x = 4;

        Tree tree3 = new Tree();
        tree3.l = tree2;
        tree3.x = 5;

        Tree tree4 = new Tree();
        tree4.x = 6;
        Tree tree7 = new Tree();
        tree7.x = 7;
        Tree tree5 = new Tree();
        tree5.x = 1;
        tree5.l = tree7;

        Tree tree6 = new Tree();
        tree6.r = tree4;
        tree6.l = tree5;
        tree6.x = 6;

        Tree treeRoot = new Tree();
        treeRoot.l = tree3;
        treeRoot.r = tree6;
        treeRoot.x = 4;
        /*Tree tree1 = new Tree();
        tree1.x=5;



        Tree tree3 = new Tree();
        tree3.x = 6;

        Tree treeRoot = new Tree();
        treeRoot.l = tree1;
        treeRoot.r = tree3;
        treeRoot.x = 4;*/


       int ret =  new TreePath().findDistinctValues(treeRoot, new HashSet<>(), new ArrayList<>());
       System.out.println(ret);
    }

}
