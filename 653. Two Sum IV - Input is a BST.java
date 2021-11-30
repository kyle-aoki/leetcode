class Solution {
    List<Integer> nums;
    public boolean findTarget(TreeNode root, int k) {
        nums = new ArrayList<>();
        traverse(root);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                if (nums.get(i) + nums.get(j) == k) return true;
            }
        }
        return false;
    }
    void traverse(TreeNode node) {
        nums.add(node.val);
        if (node.left != null) traverse(node.left);
        if (node.right != null) traverse(node.right);
    }
}
