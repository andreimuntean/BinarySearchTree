import java.util.ArrayList;
import java.util.List;

/**
 * A node-based binary search tree.
 *
 * @author Andrei Muntean
 */
public class BinarySearchTree<T extends Comparable<T>>
{
    // Represents the parent of this node.
    private BinarySearchTree<T> parent;

    // Represents the value stored by this node.
    private T value;

    // Represents the left child of this node.
    private BinarySearchTree<T> left;

    // Represents the right child of this node.
    private BinarySearchTree<T> right;

    /**
     * Constructs a binary search tree.
     */
    public BinarySearchTree()
    {
        parent = null;
        value = null;
    }

    /**
     * Constructs a node.
     *
     * @param parent The parent of the node.
     * @param value A value.
     */
    private BinarySearchTree(BinarySearchTree<T> parent, T value)
    {
        this.parent = parent;
        this.value = value;
    }

    /**
     * Gets the value stored by this node.
     *
     * @return The value stored by this node.
     */
    public T getValue()
    {
        return value;
    }

    /**
     * Gets the parent of this node.
     *
     * @return The parent of this node.
     */
    public BinarySearchTree<T> getParent()
    {
        return parent;
    }

    /**
     * Gets the left child of this node.
     *
     * @return The left child of this node.
     */
    public BinarySearchTree<T> getLeft()
    {
        return left;
    }

    /**
     * Gets the right child of this node.
     *
     * @return The right child of this node.
     */
    public BinarySearchTree<T> getRight()
    {
        return right;
    }

    /**
     * Determines whether this binary search tree is empty.
     *
     * @return True if this binary search tree is empty.
     */
    public boolean isEmpty()
    {
        return value == null;
    }

    /**
     * Determines whether this node has a parent.
     *
     * @return True if this node has a parent.
     */
    public boolean hasParent()
    {
        return parent != null;
    }

    /**
     * Determines whether this node has a left child.
     *
     * @return True if this node has a left child.
     */
    public boolean hasLeft()
    {
        return left != null;
    }

    /**
     * Determines whether this node has a right child.
     *
     * @return True if this node has a right child.
     */
    public boolean hasRight()
    {
        return right != null;
    }

    /**
     * Adds the specified value to the binary search tree.
     *
     * @param value A value.
     *
     * @throws NullPointerException if the argument is null.
     */
    public void add(T value) throws NullPointerException
    {
        BinarySearchTree<T> currentNode = this;

        if (value == null)
        {
            throw new NullPointerException();
        }
        else if (isEmpty())
        {
            currentNode.value = value;
        }
        else
        {
            while (true)
            { 
                if (value.compareTo(currentNode.value) <= 0)
                {
                    if (currentNode.hasLeft())
                    {
                        // Advances to the left child.
                        currentNode = currentNode.left;
                    }
                    else
                    {
                        // Stores this value as the left child.
                        currentNode.left = new BinarySearchTree<T>(currentNode, value);

                        return;
                    }
                }
                else
                {
                    if (currentNode.hasRight())
                    {
                        // Advances to the right child.
                        currentNode = currentNode.right;
                    }
                    else
                    {
                        // Stores this value as the right child.
                        currentNode.right = new BinarySearchTree<T>(currentNode, value);

                        return;
                    }
                }
            }
        }
    }

    /**
     * Removes all nodes from the binary search tree.
     */
    public void clear()
    {
        if (hasParent())
        {
            if (this == parent.left)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }

        parent = null;
        value = null;
        left = null;
        right = null;
    }

    /**
     * Determines whether the specified value is in the binary search tree.
     *
     * @param value A value.
     *
     * @return True if the specified value is in the binary search tree.
     */
    public boolean contains(T value)
    {
        return find(value) != null;
    }

    /**
     * Finds the node associated with the specified value.
     *
     * @param value A value.
     *
     * @return The node associated with the specified value.
     */
    public BinarySearchTree<T> find(T value)
    {
        BinarySearchTree<T> currentNode = this;

        if (isEmpty())
        {
            // There are no values in this binary search tree.
            return null;
        }
        else if (value == null)
        {
            return null;
        }
        else
        {
            while (true)
            {
                if (value.compareTo(currentNode.value) < 0)
                {
                    if (currentNode.hasLeft())
                    {
                        // Advances to the left child.
                        currentNode = currentNode.left;
                    }
                    else
                    {
                        // The binary search tree does not contain the specified value.
                        return null;
                    }
                }
                else if (value.compareTo(currentNode.value) == 0)
                {
                    // The node which stores this value has been found.
                    return currentNode;
                }
                else
                {
                    if (currentNode.hasRight())
                    {
                        // Advances to the right child.
                        currentNode = currentNode.right;
                    }
                    else
                    {
                        // The binary search tree does not contain the specified value.
                        return null;
                    }
                }
            }
        }
    }

    /**
     * Removes the specified value from the binary search tree.
     *
     * @param value A value.
     */
    public void remove(T value)
    {
        BinarySearchTree<T> removedNode = find(value);

        if (removedNode != null)
        {
            if (removedNode.hasLeft() && removedNode.hasRight())
            {
                // Updates the left child.
                BinarySearchTree<T> bottomLeft = removedNode.right.getFirst();

                removedNode.left.parent = bottomLeft;
                bottomLeft.left = removedNode.left;

                // Updates the right child.
                if (removedNode.right.hasLeft())
                {
                    removedNode.right.left.parent = removedNode;
                }

                if (removedNode.right.hasRight())
                {
                    removedNode.right.right.parent = removedNode;
                }

                // Copies the right child over this one.
                removedNode.value = removedNode.right.value;
                removedNode.left = removedNode.right.left;
                removedNode.right = removedNode.right.right;
            }
            else if (removedNode.hasLeft())
            {
                // Updates the left child.
                if (removedNode.left.hasLeft())
                {
                    removedNode.left.left.parent = removedNode;
                }

                if (removedNode.left.hasRight())
                {
                    removedNode.left.right.parent = removedNode;
                }

                // Copies the left child over this one.
                removedNode.value = removedNode.left.value;
                removedNode.right = removedNode.left.right;
                removedNode.left = removedNode.left.left;
            }
            else if (removedNode.hasRight())
            {
                // Updates the right child.
                if (removedNode.right.hasLeft())
                {
                    removedNode.right.left.parent = removedNode;
                }

                if (removedNode.right.hasRight())
                {
                    removedNode.right.right.parent = removedNode;
                }

                // Copies the right child over this one.
                removedNode.value = removedNode.right.value;
                removedNode.left = removedNode.right.left;
                removedNode.right = removedNode.right.right;
            }
            else
            {
                removedNode.clear();
            }
        }
    }

    /**
     * Gets the node which contains the smallest element in the binary search tree.
     *
     * @return The node which contains the smallest element in the binary search tree.
     */
    public BinarySearchTree<T> getFirst()
    {
        BinarySearchTree<T> firstNode = this;

        while (firstNode.hasLeft())
        {
            firstNode = firstNode.left;
        }

        return firstNode;
    }

    /**
     * Gets the node which contains the greatest element in the binary search tree.
     *
     * @return The node which contains the greatest element in the binary search tree.
     */
    public BinarySearchTree<T> getLast()
    {
        BinarySearchTree<T> lastNode = this;

        while (lastNode.hasRight())
        {
            lastNode = lastNode.right;
        }

        return lastNode;
    }

    /**
     * Gets the root of the binary search tree.
     *
     * @return The root of the binary search tree.
     */
    public BinarySearchTree<T> getRoot()
    {
        BinarySearchTree<T> root = this;

        while (root.hasParent())
        {
            root = root.parent;
        }

        return root;
    }

    /**
     * Gets the depth of the binary search tree.
     *
     * @return The depth of the binary search tree.
     */
    public int getDepth()
    {
        if (isEmpty() || !hasLeft() && !hasRight())
        {
            return 0;
        }
        else
        {
            int depthLeft = 0;
            int depthRight = 0;

            if (hasLeft())
            {
                depthLeft += 1 + left.getDepth();
            }

            if (hasRight())
            {
                depthRight += 1 + right.getDepth();
            }

            return Math.max(depthLeft, depthRight);
        }
    }

    /**
     * Gets the number of elements in the binary search tree.
     *
     * @return The number of elements in the binary search tree.
     */
    public int getSize()
    {
        if (isEmpty())
        {
            return 0;
        }
        else
        {
            int size = 1;

            if (hasLeft())
            {
                size += left.getSize();
            }

            if (hasRight())
            {
                size += right.getSize();
            }

            return size;
        }
    }

    /**
     * Gets the list representation of the binary search tree.
     *
     * @return The list representation of the binary search tree.
     */
    public List<T> toList()
    {
        List<T> list = new ArrayList<T>();

        if (!isEmpty())
        {
            list.add(value);
        }

        if (hasLeft())
        {
            list.addAll(left.toList());
        }

        if (hasRight())
        {
            list.addAll(right.toList());
        }

        return list;
    }

    @Override
    public String toString()
    {
        if (!isEmpty())
        {
            if (hasLeft() && hasRight())
            {
                return String.format("%s(%s, %s)", value, left, right);
            }
            else if (hasLeft())
            {
                return String.format("%s(%s, -)", value, left);
            }
            else if (hasRight())
            {
                return String.format("%s(-, %s)", value, right);
            }
            else
            {
                return String.format("%s", value);
            }
        }
        else
        {
            return "";
        }
    }
}