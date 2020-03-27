/*
* @Author: Qi Hu
* @Date:   2016-07-28 22:44:48
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-31 12:58:49
*/

public class LockDList extends DList {

  public void lockNode(DListNode node){
	   ((LockDListNode)node).isLocked = true;
  }

  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

  public void remove(DListNode node) {
    if (((LockDListNode)node).isLocked == false) {
        super.remove(node);
        size--;
    }
    return;
  }


}