class LLNode {
	int data;
	LLNode next;

	public LLNode(int data) {
		this.data = data;
	}
}

public class PrintMiddleOfList {

	public static void main(String[] args) {
		LLNode ten = new LLNode(10);
		LLNode twenty = new LLNode(20);
		ten.next = twenty;
		LLNode thirty = new LLNode(30);
		twenty.next = thirty;
		LLNode forty = new LLNode(40);
		thirty.next = forty;
		LLNode fifty = new LLNode(50);
		forty.next = fifty;
		LLNode sixty = new LLNode(60);
		fifty.next = sixty;
		LLNode seventy = new LLNode(70);
		sixty.next = seventy;
		LLNode startPtr = ten;
		LLNode fastPtr = ten;
		while (fastPtr != null) {
			if (null != fastPtr.next && null != fastPtr.next.next) {
				fastPtr = fastPtr.next.next;
			} else {
				fastPtr = null;
			}
			if (null != fastPtr)
				startPtr = startPtr.next;

		}
		System.out.println(startPtr.data);
	}

}
