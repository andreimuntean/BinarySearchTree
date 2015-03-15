public class Test
{
    public static void main(String[] args)
    {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();

        tree.add("k");
        tree.add("i");
        tree.add("d");

        System.out.println("Tree: " + tree);
        assert tree.toString().equals("k(i(d, -), -)");
        
        tree.remove("k");
        System.out.println("Tree: " + tree);
        assert tree.toString().equals("i(d, -)");
        
        tree.remove("d");
        System.out.println("Tree: " + tree);
        assert tree.toString().equals("i");
        // WHY DOES THIS FAIL???
    }
}