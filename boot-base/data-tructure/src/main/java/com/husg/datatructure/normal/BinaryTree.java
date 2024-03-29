package com.husg.datatructure.normal;

import java.math.BigDecimal;

/**
 * @program: ideaSpaceBoot
 * @description: 二叉树
 * @author: hushenggui
 * @create: 2020-04-01 22:08
 **/
public class BinaryTree {
    /**
     * 根节点
     */
    private static Node root;

    static class Node {
        int key;
        Node left, right, parent;

        public Node(int key) {
            this.key = key;
        }
    }

    public BinaryTree(int key) {
        root = new Node(key);
    }

    /**
     * 中序遍历
     *
     * @param node 根节点
     */
    public void inOrderTreeWalk(Node node) {
        if (node != null) {
            inOrderTreeWalk(node.left);
            System.out.print(node.key + ",");
            inOrderTreeWalk(node.right);
        }
    }

    /**
     * 查找
     *
     * @param node 根节点
     * @param key 查找值
     * @return
     */
    public Node treeSearch(Node node, int key) {
        while (node != null && key != node.key) {
            if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    /**
     * 最小值
     *
     * @param node 根节点
     * @return
     */
    public Node treeMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 最大值
     *
     * @param node 根节点
     * @return
     */
    public Node treeMaximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 前驱
     *
     * @param node 根节点
     * @return
     */
    public Node treePredecessor(Node node) {
        // 如果存在左子树，返回左子树的最大值
        if (node.left != null) {
            return treeMaximum(node.left);
        }
        Node y = node.parent;
        // 当不存在左子树时，返回最低祖先节点
        while (y != null && node == y.left) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 后继
     *
     * @param node 根节点
     * @return
     */
    public Node treeSuccessor(Node node) {
        // 如果存在右子树，返回右子树的最小值
        if (node.right != null) {
            return treeMinimum(node.right);
        }
        Node y = node.parent;
        // 当不存在右子树时，返回最低祖先节点
        while (y != null && node == y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 插入
     *
     * @param key 插入节点的关键值
     */
    public void treeInsert(int key) {
        // 创建插入节点
        Node node = new Node(key);
        // 定义插入节点的父节点变量
        Node y = null;
        // 定义临时变量存根节点
        Node x = root;
        // 在根节点的左、右子树中查找插入位置
        while (x != null) {
            y = x;
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
    }

    /**
     * 删除
     *
     * @param node 删除节点
     * @return
     */
    public Node treeDelete(Node node) {
        // 定义临时变量存删除节点或后继节点
        Node y;
        // 当删除节点至多有一个孩子时
        if (node.left == null || node.right == null) {
            y = node;
        } else {// 当删除节点有两个孩子时，y存后继节点
            y = treeSuccessor(node);
        }
        // 定义临时变量存删除节点的孩子节点
        Node x;
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (x != null) {
            x.parent = y.parent;
        }
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        // 当y为后继节点时，将y的关键值赋给删除节点
        if (y != node) {
            node.key = y.key;
        }
        return y;
    }

}
