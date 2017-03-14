package cn.edu.scut.bst;
/**
 * 二叉查找树
 * @author Administrator
 *
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
	//二叉树节点BinaryNode
	private static class BinaryNode<AnyType>{
		//构造方法，传入值
		BinaryNode(AnyType theElement) {
			// TODO Auto-generated constructor stub
			this(theElement, null, null);
		}
		
		BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
			this.element = theElement;
			this.left = lt;
			this.right = rt;
		}
		
		AnyType element;
		BinaryNode<AnyType> left; //左子树
		BinaryNode<AnyType> right;//右子树
		
		
		
	}
	
	//接下来就是一堆方法，总结来说，如果能够是实现这些方法，那就也就相当于对二叉查找树构造好了
	
	private BinaryNode<AnyType> root; //根节点
	
	//构造方法
	public BinarySearchTree(){
		root = null;
	}
	
	
	//将树清空
	public void makeEmpty(){
		root = null;
	}
	
	//是否为空
	public boolean isEmpty(){
		return root != null;
	}
	
	//是否包含某个值
	public boolean contains(AnyType x){
		return false;
	}
	
	//查找最小值
	public AnyType findMin() throws Exception{
		if(!isEmpty()){
			return findMin(root).element;
		}
		throw new Exception();
	}
	
	//查找最大值
	public AnyType findMax() throws Exception{
		if(!isEmpty()){
			return findMax(root).element;
		}
		throw new Exception();
	}
	
	//插入
	public void insert(AnyType x){
		root = insert(x, root);
	}
	
	//删除
	public void remove(AnyType x){
		root = remove(x, root);
	}
	
	//打印树
	public void printTree(){
		if(root == null)
			System.out.println("empty tree");
		else
			printTree(root);
	}
	
	//是否包含该值
	private boolean contains(AnyType x, BinaryNode<AnyType> t){
		if(t == null)
			return false;
		
		//
		if(t.element.compareTo(x) == 0){
			return true;
		}else if(t.element.compareTo(x) > 0){ //往左子树找
			return contains(x, t.left);
		}else{
			return contains(x, t.right);
		}
	}
	
	
	//查找最小值
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t == null){
			return null;
		}
		
		if(t.left != null){
			return findMin(t.left);
		}
		
		return t;
	}
	
	//查找最大值
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t == null){
			return null;
		}
		
		if(t.right != null){
			return findMax(t.right);
		}
		
		return t;
		
	}
	
	//插入值
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if(t == null){
			t = new BinaryNode<AnyType>(x);
			return t;
		}
		
		int comparableResult = x.compareTo(t.element);
		
		if(comparableResult > 0){
			t.right = insert(x, t.right);
		}else if(comparableResult < 0){
			t.left = insert(x, t.left);
		}
		return t;
	}
	
	
	//删除值
	/**
	 * 1.如果删除的节点左右孩子都存在，则查找右子树的最小值，将值替换到该节点，再删除该节点的
	 * 2.返回根节点
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
		if(t == null){
			return null;
		}
		
		//比较
		int compareResult = x.compareTo(t.element);
		
		if(compareResult > 0){
			t.right =  remove(x, t.right);
		}else if(compareResult < 0){
			t.left = remove(x, t.left);
		}
		
		//值相等时删除
		if(t.left != null && t.right != null){
			BinaryNode<AnyType> min = findMin(t.right);
			t.element = min.element;
			t.right = remove(t.element, t.right);
		}else{
			t = t.left != null ? t.left: t.right; 
		}
		return t;
	}	
	
	//打印树
	private void printTree(BinaryNode<AnyType> t){
		if(t != null){
			
			printTree(t.left);
			
			printTree(t.right);
			System.out.println(t.element + "  ");
		}
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(4);
		bst.insert(2);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(1);
		
		bst.printTree();
	}
	
	
}
