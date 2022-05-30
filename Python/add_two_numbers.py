# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # 创建头节点
        result = curr = ListNode()
        # 保留进位
        remainder = 0
        while l1 or l2:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            total = x + y + remainder
            # 得到首节点 个位数
            curr.next = ListNode(total % 10)
            # 求出进位
            remainder = total // 10
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            curr = curr.next
        # 如果有进位则传入
        if remainder:
            curr.next = ListNode(remainder)
        return result.next

