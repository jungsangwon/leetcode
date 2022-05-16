/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder sb;
	String data;

	// to determine the value is +ve or -ve
	boolean neg;
	int idx;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		sb = new StringBuilder();
		preOrder(root);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		this.data = data;
		idx = 0;
		return decode();
	}

	public TreeNode decode() {
		idx++; 
		if (data.charAt(idx) == ')')
			return null;

		int val = 0;
		neg = false;
		if (data.charAt(idx) == '-') {
			neg = true;
			idx++;
		}

		while (data.charAt(idx) != '(')
			val = val * 10 + data.charAt(idx++) % '0';

		TreeNode node = new TreeNode(neg ? -val : val);
		node.left = decode();
		idx++;
		node.right = decode();
		idx++;

		return node;
	}

	public void preOrder(TreeNode node) {
		if (node == null) {
			sb.append("()");
			return;
		}
		sb.append("(" + node.val);
		preOrder(node.left);
		preOrder(node.right);
		sb.append(')');
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));