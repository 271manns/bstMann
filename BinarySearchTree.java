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
    private int size;

    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null; 
        size = 0;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        return size; 
    }

    // Adds element to this BST. The tree retains its BST property.
    public void add (T element)
    {
        
        if(size == 0)
        {
            root = new BinaryNode(element);
        }
        else
        {
            BinaryNode<T> temp = root;
            while(temp != null)
            {
                int comparison = element.compareTo(temp.getInfo());
                if(comparison < 0)
                {
                    if(temp.getLeft() == null)
                    {
                        temp.setLeft(new BinaryNode<>(element));
                        return;
                    }
                    temp = temp.getLeft();
                }
                else
                {
                    if(temp.getRight() == null)
                    {
                        temp.setRight(new BinaryNode<>(element));
                        return;
                    }
                    temp = temp.getRight();
                }
            }
        }
        size++;

    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        List<T> temp = preorderTraverse();
        for(int i = 0; i<temp.size(); i++)
        {
            if(temp.get(i).compareTo(element)== 0)
            {
                return true;
            }
        }
        return false;
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
    }

    // Restructures this BST to be optimally balanced
    public void balance()
    {
    }
    public int compare(T el1, T el2)
    {
        return el1.compareTo(el2);
    }
}