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
	private final BinarySearchTree<T> parent;

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
	 * @param A value.
	 */
	public void add(T value)
	{

	}

	/**
	 * Removes all elements from the binary search tree.
	 */
	public void clear()
	{
		value = null;
		left = null;
		right = null;
	}

	/**
	 * Gets the node associated with the specified value.
	 *
	 * @param A value.
	 *
	 * @return The node associated with the specified value.
	 */
	public BinarySearchTree<T> get(T value)
	{
		return null;
	}

	/**
	 * Removes the specified value from the binary search tree.
	 *
	 * @param A value.
	 */
	public void remove(T value)
	{

	}

	/**
	 * Gets the first element in the binary search tree.
	 *
	 * @return The first element in the binary search tree.
	 */
	public BinarySearchTree<T> getFirst()
	{
		return null;
	}

	/**
	 * Gets the last element in the binary search tree.
	 *
	 * @return The last element in the binary search tree.
	 */
	public BinarySearchTree<T> getLast()
	{
		return null;
	}

	/**
	 * Gets the number of elements in the binary search tree.
	 *
	 * @return The number of elements in the binary search tree.
	 */
	public int size()
	{
		return 0;
	}

	/**
	 * Gets the list representation of the binary search tree.
	 *
	 * @return The list representation of the binary search tree.
	 */
	public List<T> toList()
	{
		return null;
	}

	@Override
	public String toString()
	{
		return "";
	}
}