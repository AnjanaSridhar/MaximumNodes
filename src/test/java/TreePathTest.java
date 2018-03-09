
import codility.Tree;
import codility.TreePath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreePathTest {
    private Tree tree1 = new Tree();

    @Before
            public void setUP() {

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
    }
    @Test
    public void testSolution(){
        Assert.assertNotEquals(2, new TreePath().solution(this.tree1));
    }
}
