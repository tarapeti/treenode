package hu.codecool.json_hw;

import java.util.ArrayList;
import java.util.List;

class TreeNode {


    private String category;
    private String parentCategory;
    private List<TreeNode> children;

    public TreeNode(String category, String parentCategory, List<TreeNode> children) {
        this.category = category;
        this.parentCategory = parentCategory;
        this.children = new ArrayList<>();
    }

    public void addChildren(TreeNode treeNode) {
        this.children.add(treeNode);
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "children=" + children +
                ", parentCategory='" + parentCategory + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}