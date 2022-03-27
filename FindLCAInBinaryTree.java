 /*
           p aur q dhoondhne hain
           root given hai
           recursive logic lgega
           agar root p ya q k equal hai, to root return krdo
           else left part se recursive call mar do and right se bhi
           phir dono k results dekho
           agar koi ek bhi null hai, to non null wali value return krdo
           agar dono null nahi hain, to root return krdo
           agar dono null hain, to null return krdo
           bas mil jaega lca
     */
    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
