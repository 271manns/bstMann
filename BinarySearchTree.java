import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root; 

    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root == null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        return size(root);
    }
    private int size(BinaryNode<T> node)
    {
        if(node == null)
        {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        root = add(root, element);
    }
    private BinaryNode<T> add (BinaryNode<T> node, T element)
    {
        if(node == null)
        {
            return new BinaryNode<>(element);
        }
        int compare = element.compareTo(node.getInfo());
        if(compare < 0)
        {
            node.setLeft(add(node.getLeft(), element));
        }
        else if(compare > 0)
        {
            node.setRight(add(node.getRight(), element));
        }
        return node;
    }
    

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        return contains(root, element);
    }
    private boolean contains(BinaryNode<T> node, T element)
    {
        if(node == null)
        {
            return false;
        }
        int compare = node.getInfo().compareTo(element);
        if(compare == 0)
        {
            return true;
        }
        if(compare < 0)
        {
            return contains(node.getRight(), element);
        }
        else
        {
            return contains(node.getLeft(),element);
        }
    }
    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        List<T> hi = new ArrayList<>();
        preorderTraverse(root,hi);
        return hi;
    }
    public void preorderTraverse(BinaryNode<T> node, List<T> traversal)
    {
        if (node != null)
        {
            traversal.add(node.getInfo());
            preorderTraverse(node.getLeft(), traversal);
            preorderTraverse(node.getRight(), traversal);
        }
    }
    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        List<T> hi = new ArrayList<>();
        inorderTraverse(root, hi);
        return hi;
    }

    private void inorderTraverse(BinaryNode<T> node, List<T> traversal)
    {
        if (node != null)
        {
            inorderTraverse(node.getLeft(), traversal);
            traversal.add(node.getInfo());
            inorderTraverse(node.getRight(), traversal);
        }
    }
    
    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        List<T> hi = new ArrayList<>();
        postorderTraverse(root, hi);
        return hi;
    }

    private void postorderTraverse(BinaryNode<T> node, List<T> traversal)
    {
        if (node != null)
        {
            postorderTraverse(node.getLeft(), traversal);
            postorderTraverse(node.getRight(), traversal);
            traversal.add(node.getInfo());
        }
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
        root = remove(element, root);
    }
    private BinaryNode<T> remove(T target, BinaryNode<T> node)
    {
        if(node == null)
        {
            return null;
        }
        else if(target.compareTo(node.getInfo()) < 0)
        {
            node.setLeft(remove(target, node.getLeft()));

        }
        else if(target.compareTo(node.getInfo()) > 0)
        {
            node.setRight(remove(target, node.getRight()));
        }
        else
        {
            node = removeNode(node);
        }
        return node; 
    }
    private BinaryNode<T> removeNode(BinaryNode<T> node)
    {
        T data;
        if(node.getLeft() == null)
        {
            return node.getRight();
        }
        else if (node.getRight() == null)
        {
            return node.getLeft();
        }
        else
        {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(remove(data, node.getLeft()));
            return node;
        }
    }
    private T getPredecessor(BinaryNode<T> node)
    {
        BinaryNode<T> temp = node;
        while (temp.getRight() != null)
        {
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
        List<T> values = inorderTraverse();
        root = buildBalanced(values, 0, values.size() - 1);
    }

    private BinaryNode<T> buildBalanced(List<T> values, int first, int last)
    {
        if (first > last)
        {
            return null;
        }
        int mid = (first + last) / 2;
        BinaryNode<T> node = new BinaryNode<>(values.get(mid));
        node.setLeft(buildBalanced(values, first, mid - 1));
        node.setRight(buildBalanced(values, mid + 1, last));
        return node;
    }
    

}