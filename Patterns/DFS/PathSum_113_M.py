#binary tree
import copy


class BinaryTree:
    def __init__(self,val,left=None,right=None) -> None:
        self.right = right
        self.left = left
        self.val = val
def pathSum2(root,targetSum):
    res= []
    traverse([],root,targetSum,res)
    return res

def traverse(res,root,targetSum,finalRes):
    if root==None:
        return  
    else:
        res.append(root.val)
        if root.left==None and root.right==None:
            if targetSum==sum(res):
                finalRes.append(res)
        else:
            traverse(copy.deepcopy(res),root.left,targetSum,finalRes)
            traverse(copy.deepcopy(res),root.right,targetSum,finalRes)

#                 5
#         4               8
#     11              13          4
# 7       2                    5       1

root = BinaryTree(5,
                  BinaryTree(4,
                             BinaryTree(11,
                                        BinaryTree(7),
                                        BinaryTree(2))),
                  BinaryTree(8,
                             BinaryTree(13),
                             BinaryTree(4,
                                        BinaryTree(5),
                                        BinaryTree(1))))
pathSum2(root,22)