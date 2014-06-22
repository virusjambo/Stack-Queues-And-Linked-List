package fromgiventranverseconstucttree;
import createtreeusingagivearray.Node;
public class Tree<E> {
    static  int preCount = 0;
    public Node<E> constuct(E []inOrder,E[] preOrder,int low,int high,int n){

        int posNode;
        if(low>high || preCount>n){
            return null;
        }
        Node<E> root=new Node<E>(preOrder[preCount]);
        posNode=findNode(inOrder,preOrder[preCount],low,high);
        preCount++;
        if(low==high){
            return root;
        }

        root.setLeftRef(constuct(inOrder,preOrder,low,posNode-1,n))	 ;
        root.setRightRef(constuct(inOrder,preOrder,posNode+1,high,n))	 ;
        return root;

    }

    int findNode(E []inOrder,E root,int low,int high){
        for(int i=low;i<=high;i++){
            if(root.equals(inOrder[i])){
                System.out.println("middle:"+i);
                return i;

            }

        }
        return -1;
    }
    void printElements(Node<E> root){
        System.out.println("Resultsssssssssssss");
        for(int i=1;i<=finaMaxDepthOfTree(root);i++){
            printAtLevel(root,i);
            System.out.println();
        }

    }
    void printAtLevel(Node<E> root,int level){
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.getValue());
        else if (level>1){
            printAtLevel(root.getLeftRef(),level-1);
            printAtLevel(root.getRightRef(),level-1);
        }


    }
    int finaMaxDepthOfTree(Node<E> head){
        if(head==null){
            return 0;

        }
        int l= finaMaxDepthOfTree(head.getLeftRef());
        int r= finaMaxDepthOfTree(head.getRightRef());
        if(l>r)
            return l=l+1;
        else
            return r=r+1;

    }
    public static void main(String[] args) {
        Integer in[]= {1,2,3,4,5,7,8};
        Integer pre[]={4,2,1,3,7,5,8};
        Tree<Integer>  tree=new Tree<Integer>();
        Node<Integer> root=new Node<Integer>();
        root= tree.constuct(in, pre,   0, in.length-1,in.length-1);
        tree.printElements(root);

    }

}
