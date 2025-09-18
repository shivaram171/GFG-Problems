# '''
# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None
# '''

# class Solution:
#     def is_sum_tree(self, node):
#         # code here
        
        
class Solution:
    def is_sum_tree(self, node):
        def helper(root):
            if root is None:
                return True, 0
            if root.left is None and root.right is None:
                return True, root.data

            left_ok, left_sum = helper(root.left)
            right_ok, right_sum = helper(root.right)

            total = left_sum + right_sum

            # current node valid if its value == sum of subtree
            is_ok = left_ok and right_ok and (root.data == total)

            return is_ok, root.data + total

        ok, _ = helper(node)
        return ok
