package dataStructures;
import java.util.ArrayList;
import java.util.Iterator;

public class Trees {
	/**
     * Private Node class.
     */
	private static class Node<E extends Comparable<E>> {
		private E value;
		private Node<E> left;
		private Node<E> right;

		/**
		 * Constructor.
		 */
		private Node(E value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	/**
	 * Binary Search Tree Implementation.
	 */
	public class BST <E extends Comparable<E>>{
		private Trees.Node<E> root;
		private int count;
		
		/**
		 * Constructor.
		 */
		public BST() {
			root = null;
			count = 0;
		}
		/**
		 * Searches for key in BST.
		 * @param key Given search key.
		 * @return Boolean value indicating whether or not the key was found.
		 */
		public boolean contains(E key) {
			return contains(key, root);
		}
		/**
		 * Searches for key in BST.
		 * @param key Given search key.
		 * @param curr Root instance.
		 * @return Boolean value indicating whether or not the key was found.
		 */
		private boolean contains(E key, Node<E> curr) {
			if (curr == null)
				return false;
			else if (key.compareTo(curr.value) < 0)
				return contains(key, curr.left);  // Search the left branch
			else if (key.compareTo(curr.value) > 0)
				return contains(key, curr.right); // Search the right branch
			else // if (x == bstree.value)
				return true;
		}
		/**
		 * Add an element to the BST.
		 * @param e Element to add.
		 */
		public void add(E e) {
			root = add(e, root);
		}
		/**
		 * Add an element to the BST.
		 * @param e Element to add.
		 * @param Root instance.
		 */
		private Node<E> add(E insertValue, Node<E> curr) {
			//If the node doesn't exist, add it.
			if (curr == null) {
				count++;
				return new Node<E>(insertValue);
			}
			//If given element is less than current node's element.
			if (insertValue.compareTo(curr.value) < 0)
				curr.left = add(insertValue, curr.left);
			//If given element is more than current node's element.
			else if (insertValue.compareTo(curr.value) > 0)
				curr.right = add(insertValue, curr.right);
			//If given element equal to current node's element.
			return curr;
		}
		/**
		 * Returns an ArrayList of InOrder-traversed elements.
		 * @return Array list of InOrder traversal elements.
		 */
		public ArrayList<E> getInOrderTraversal(){
			ArrayList<E> arr = new ArrayList<E>();
			arr = inorder();
			return arr;
		}
		/**
		 * Traverses BST and creates an ArrayList of InOrder-traversed elements.
		 * @return Array list of InOrder traversal elements.
		 */
		public ArrayList<E> inorder() {
			ArrayList<E> arr = new ArrayList<E>();
			arr = inorder(arr, root);
			return arr;
		}
		/**
		 * Traverses BST and creates an ArrayList of InOrder-traversed elements.
		 * @param arr Array list to be filled.
		 * @param curr BT instance.
		 * @return Array list of InOrder traversal elements.
		 */
		private ArrayList<E> inorder(ArrayList<E> arr, Node<E> curr) {
			
			if (curr != null) {
				inorder(arr,curr.left);
				arr.add((E) curr.value);
				inorder(arr, curr.right);
			}
			return arr;
		}
		/**
		 * Returns an ArrayList of PreOrder-traversed elements.
		 * @return Array list of PreOrder traversal elements.
		 */
		public ArrayList<E> getPreOrderTraversal(){
			ArrayList<E> arr = new ArrayList<E>();
			arr = preorder();
			return arr;
		}
		/**
		 * Traverses BST and creates an ArrayList of PreOrder-traversed elements.
		 * @return Array list of PreOrder traversal elements.
		 */
		public ArrayList<E> preorder() {
			ArrayList<E> arr = new ArrayList<E>();
			arr = preorder(arr, root);
			return arr;	
		}
		/**
		 * Traverses BST and creates an ArrayList of PreOrder-traversed elements.
		 * @param arr Array list to be filled.
		 * @param curr BT instance.
		 * @return Array list of PreOrder traversal elements.
		 */
		private ArrayList<E> preorder(ArrayList<E> arr, Node<E> curr) {
			if (curr != null) {
				arr.add(curr.value);
				preorder(arr, curr.left);
				preorder(arr, curr.right);
			}
			return arr;
		}
		/**
		 * Returns an ArrayList of PostOrder-traversed elements.
		 * @return Array list of PostOrder traversal elements.
		 */
		public ArrayList<E> getPostOrderTraversal(){
			ArrayList<E> arr = new ArrayList<E>();
			arr = postorder();
			return arr;
		}
		/**
		 * Traverses BST and creates an ArrayList of PostOrder-traversed elements.
		 * @return Array list of PostOrder traversal elements.
		 */
		public ArrayList<E> postorder() {
			ArrayList<E> arr = new ArrayList<E>();
			arr = postorder(arr, root);
			return arr;	
		}
		/**
		 * Traverses BST and creates an ArrayList of PostOrder-traversed elements.
		 * @param arr Array list to be filled.
		 * @param curr BT instance.
		 * @return Array list of PostOrder traversal elements.
		 */
		private ArrayList<E> postorder(ArrayList<E> arr, Node<E> curr) {
			if (curr != null) {
				postorder(arr, curr.left);
				postorder(arr, curr.right);
				arr.add(curr.value);
			}
			return arr;
		}
		/**
		 * Removes a determined element from a BST.
		 * @param removeValue Given search key.
		 */
		public void remove(E removeValue) {
			root = remove(removeValue, root);
		}
		/**
		 * Removes a determined element from a BST.
		 * @param key Given search key.
		 * @param curr Root instance.
		 * @return New BST including the new element.
		 */
		private Node<E> remove(E value, Node<E> curr) {
			if (curr == null)
				return null;
			//If given key is less than current node's key.
			if (value.compareTo(curr.value) < 0) {
				curr.left = remove(value, curr.left);
			}
			//If given key is greater than current node's key.
			else if (value.compareTo(curr.value) > 0) {
				curr.right = remove(value, curr.right);
			}
			//If given key equals current node's key.
			else {
				if (curr.left == null) {
					count--;
					return curr.right;
				}
				else if (curr.right == null) {
					count--;
					return curr.left;
				}
				//Replaces removed node.
				else {
					Node<E> temp = getMax(curr.left); //Hold for replacing node.
					curr.value = temp.value;
					curr.value = temp.value;
					curr.left = remove(curr.value, curr.left);
				}
			}
			return curr;
		}
		/**
		 * Determines node with max value.
		 * @param curr Root instance.
		 * @return Node with max value.
		 */
		private Node<E> getMax(Node<E> curr) {
			while (curr.right != null)
				curr = curr.right;
			return curr;
		}
		/**
		 * Determines that the number of elements in the BST is 0.
		 * @return Boolean value indicating empty or not.
		 */
		public boolean Empty() {
			return count == 0;
		}
		/**
		 * Determines the number of elements in the BST.
		 * @return Number of elements in BST.
		 */
		public int size() {
			return count;
		}
		/**
		 * Determines the number of leafNodes in BST.
		 * @return Number of leafNodes in BST.
		 */
		public int getLeafNodeCount() 
	    {
	        return getLeafNodeCount(root);
	    }
		/**
		 * Determines the number of leafNodes in BST.
		 * @param curr Root instance.
		 * @return Number of leafNodes in BST.
		 */
	    private int getLeafNodeCount(Node<E> curr) 
	    {
	        if (curr == null)
	            return 0;
	        if (curr.left == null && curr.right == null)
	            return 1;
	        else
	            return getLeafNodeCount(curr.left) + getLeafNodeCount(curr.right);
	    }
	    /**
	     * Determines the number of levels in the BST.
	     * @return Number of levels in the BST.
	     */
	    public int getTreeHeight() {
	    	return getTreeHeight(root);
	    }
	    /**
	     * Determines the number of levels in the BST.
	     * @param curr Root instance.
	     * @return Number of levels in the BST.
	     */
	    private int getTreeHeight(Node<E> curr) {
	        if (curr == null) {
	            return 0;
	        }

	        int leftBranch = getTreeHeight(curr.left);		//# of left levels.
	        int rightBranch = getTreeHeight(curr.right);	//# of right levels.

	        if (leftBranch > rightBranch) {
	            return leftBranch + 1;
	        } else {
	            return rightBranch + 1;
	        }
	    }
	    /**
	     * Determines the level of a given element. 
	     * @param element Element being searched for.
	     * @return Level of a given element if found, else -1.
	     */
	    public int getElementLevel(E element) 
	    {
	        return getElementLevel(root, element, 1);
	    }

	    /**
	     * Determines the level of a given element. 
	     * @param element Element being searched for.
	     * @param curr Root instance.
	     * @param 1 Starting level.
	     * @return Level of a given element if found, else -1. 
	     */
	    private int getElementLevel(Node<E> curr, E target, int level) 
	    {
	        if (curr == null)
	            return -1;
	  
	        if (curr.value == target)
	            return level;
	        
	        //Level number of left tree.
	        int left = getElementLevel(curr.left, target, level + 1);	
	        if (left != -1)
	            return left;
	        
	      //Level number.
	        int right = getElementLevel(curr.right, target, level + 1);
	        
	        return right;
	    }
	    /**
	     * Returns an ArrayList of the ancestor(s) of the node with the given value.
	     * @param element Element being searched for.
	     * @return ArrayList of the ancestor(s)
	     */
	    public ArrayList<E> getAncestorsOf(E element){
	    	//Create new arrayList instance.
	    	ArrayList<E> ancList = new ArrayList<E>();
	    	
			if(getAncestorsOf(ancList, root, element) == true);
				return ancList;
	    }
	    /**
	     * Returns an ArrayList of the ancestor(s) of the node with the given value.
	     * @param ancList List to be filled.
	     * @param curr Root instance.
	     * @param element Element being searched for.
	     * @return ArrayList of the ancestor(s)
	     */
	    private boolean getAncestorsOf(ArrayList<E> ancList, 
	    		Node<E> curr, E element) {

	            if (curr == null)
	                return false;
	      
	            if (curr.value == element)
	                return true;
	      
	            //If found in left.
	            if (getAncestorsOf(ancList, curr.left, element)) {
	            	ancList.add(curr.value);
	                return true;
	            }
	            //If found in right.
	            if(getAncestorsOf(ancList, curr.right, element)){
	            	ancList.add(curr.value);
	                return true;
	            }
	      
	            return false;
		}
	    /**
	     * Returns a string representation of the BST object.
	     * @return a string representation of the BST object
	     */
	    @Override
	    public String toString() {
	        return new TreePrinter().getStringReprOf(this.root);
	    }

	    private class TreePrinter {

	        /**
	         * Generates the string representation of the given tree rooted at the
	         * node
	         * @param node tree to represent
	         * @return String representation of the given tree rooted at the node
	         */
	        private String getStringReprOf(Node<E> node) {
	            if (node == null) {
	                return "(empty)";
	            }

	            Block blk = getBlock(node);
	            StringBuilder sb = new StringBuilder();
	            for (StringBuilder line : blk.lines) {
	                sb.append(line).append('\n');
	            }
	            return sb.toString();
	        }

	        private Block getBlock(Node<E> node) {
	            // min spacing between left and right blocks
	            final int SP = 2;

	            // base case
	            if (node == null) {
	                return null;
	            }

	            Block lft = getBlock(node.left);
	            Block rgt = getBlock(node.right);
	            boolean hasLft = lft != null;
	            boolean hasRgt = rgt != null;

	            // root value and root length
	            String val = node.value.toString();
	            int len = node.value.toString().length();

	            // how much the right block needs to be shifted and the width of all
	            int rgtShift = hasLft ? (lft.width + SP) : 0;
	            int width = rgtShift + (hasRgt ? rgt.width : 0);

	            // where should the root attach if there is left blk?
	            int rootIdx = hasLft ? lft.toIdx + 1 : 0;

	            // where should the root be positioned if also have right blk?
	            if (hasRgt) {
	                int rgtRootAttachIdx = rgt.fmIdx + rgtShift - 1 - len;
	                if (rgtRootAttachIdx < rootIdx) {
	                    // the right block needs to move right more
	                    int moreShift = rootIdx - rgtRootAttachIdx;
	                    rgtShift += moreShift;
	                    width += moreShift;
	                } else {
	                    // the root needs to be positioned in-between
	                    rootIdx = rootIdx + (rgtRootAttachIdx - rootIdx) / 2;
	                }
	            } else {
	                width = Math.max(width, rootIdx + len);
	            }

	            // build the line with the root
	            StringBuilder line = new StringBuilder();
	            padUntil(line, ' ', rootIdx);
	            line.append(val);
	            padUntil(line, ' ', width);

	            // start building a new block
	            Block result = new Block();
	            result.lines.add(line);

	            // build the line with the leads if have children
	            if (hasLft || hasRgt) {
	                line = new StringBuilder();
	                if (hasLft) {
	                    padUntil(line, ' ', lft.toIdx);
	                    padUntil(line, '_', rootIdx - 1);
	                    line.append('/');
	                }
	                if (hasRgt) {
	                    padUntil(line, ' ', rootIdx + len);
	                    line.append('\\');
	                    padUntil(line, '_', rgt.fmIdx + rgtShift);
	                }
	                padUntil(line, ' ', width);
	                result.lines.add(line);
	            }

	            // add combined children lines
	            result.lines.addAll(combinedLines(lft, rgt, rgtShift));
	            result.width = width;
	            result.fmIdx = rootIdx;
	            result.toIdx = rootIdx + len;
	            return result;
	        }

	        /**
	         * Combines the children blocks with the given shift
	         * @param lft Left Block to combine
	         * @param rgt Right Block to combine
	         * @param shift amount to shift the right block
	         * @return combined lines
	         */
	        private ArrayList<StringBuilder> combinedLines(Block lft, Block rgt,
	                                                       int shift) {
	            ArrayList<StringBuilder> lines = new ArrayList<StringBuilder>();
	            if (lft == null) {
	                if (rgt != null) {
	                    for (StringBuilder sb : rgt.lines) {
	                        StringBuilder line = new StringBuilder();
	                        padSpUntil(line, shift);
	                        line.append(sb);
	                        lines.add(line);
	                    }
	                }
	                return lines;
	            } else if (rgt == null) {
	                return lft.lines;
	            }

	            final Iterator<StringBuilder> lftIt = lft.lines.iterator();
	            final Iterator<StringBuilder> rgtIt = rgt.lines.iterator();

	            while (lftIt.hasNext() || rgtIt.hasNext()) {
	                StringBuilder sb =
	                    lftIt.hasNext() ? lftIt.next() : new StringBuilder();
	                padSpUntil(sb, shift);
	                if (rgtIt.hasNext()) {
	                    sb.append(rgtIt.next());
	                }
	                lines.add(sb);
	            }
	            return lines;
	        }

	        /**
	         * Helper to add multiple characters to the StringBuilder
	         * @param sb  StringBuilder to append to
	         * @param c   character to add
	         * @param len add until sb is this length
	         */
	        private void padUntil(StringBuilder sb, char c, int len) {
	            while (sb.length() < len) {
	                sb.append(c);
	            }
	        }

	        /**
	         * Helper to add multiple characters to the StringBuilder
	         * @param sb  StringBuilder to pad
	         * @param len add until sb is this length
	         */
	        private void padSpUntil(StringBuilder sb, int len) {
	            while (sb.length() < len) {
	                sb.append(' ');
	            }
	        }

	        /**
	         * Print Block
	         */
	        private class Block {
	            // String lines
	            ArrayList<StringBuilder> lines = new ArrayList<StringBuilder>();
	            int fmIdx = 0;  // index of the root value start on 1st line
	            int toIdx = 0;  // index of the root value end on 1st line
	            int width = 0;  // how wide the lines are
	        }       
		}
	}
}


