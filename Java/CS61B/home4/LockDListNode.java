/*
* @Author: Qi Hu
* @Date:   2016-07-28 22:47:10
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-31 12:30:39
*/

public class LockDListNode extends DListNode {
	public boolean isLocked;
	LockDListNode(Object i, DListNode p, DListNode n){
		super(i,p,n);
	    this.isLocked = false;
	}
}