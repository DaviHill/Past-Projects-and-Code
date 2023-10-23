#David Hill
#12/14/2022
#CSC 231-002
#Purpose: Pratice with creating Binary Search Trees and learning how to traverse through them
#Resources: Professor Toni Pence, TA Andrew Davison, Brian Faure "Python Data Structures #5: Binary Search Tree (BST)"
#Resoruces: Brian "Binary Search Tree (BST): Deletion Function", Yarit (classmate)
#Algorithm:
#          1. You can insert an item into the search tree by typing "Binary_Tree(). insert"
#          2. You are allowed to add as many items as you want in the tree. It will sort them out to their respective
#                 positions
#          3. The example I have down here inserts 7 values [20, 15, 25, 14, 16, 22, 30]
#          4. Once I inserted them I called the display function to show what the tree looks like
#          5. You can use the inorder, preorder, and postorder traversals to display the order than values are presented
#             A.This will NOT change the order the tree is set up, only how it's displayed
#          6. You can then try out the delete method. This will delete any node within the tree and adjust everything to
#                 where it needs to go.
#            A. This function in total uses about 5 helper functions to help delete each node depending on it's condition
#          7. You can also utilize the len function which has an 0(1) property
#          8. Lastly, the in operator has been altered as well to see if a value is in the tree or not.
class Node:
    def __init__(self, data):
        '''
        This initializes the data given by the user and sets the left and right child = to none
        This also sets the parent equal to none used for the delete function
        :param data:
        '''
        self.data = data
        self.right = None
        self.left = None
        self.parent = None
    def __str__(self):
        return "[%s, %s, %s]" % (self.left, str(self.data), self.right)

    def display(self):
        '''
        This calls the display_aux function to display the binary search tree in an orderly fashion
        :return:
        '''
        lines, *_ = self._display_aux()
        for line in lines:
            print(line)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.data
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.data
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.data
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.data
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2
class Binary_Tree:
    def __init__(self):
        '''
        This initializes the root to be used throughout the program. The root will always stay the same.
        This also initializes the size to determine the size of the tree
        '''
        self.root = None
        self.size = 0


    def __len__(self):
        '''
        This calculates the length of the tree by adding to the size +1 or minus 1 depending if the user
        uses the insert or delete function
        :return:
        '''
        return self.size

    def is_empty(self):
        '''
        This function determines if the tree is empty by checking if root = None
        :return:
        '''
        if self.root == None:
            return True
        else:
            return False

    def insert(self, item):
        '''
        This function checks if the tree is empty and calls it's helper function to keep hold of the
        root
        :param item:
        :return:
        '''
        if self.is_empty() == True:
            newNode = Node(item)
            self.root = newNode
        else:
            self._insert(item, self.root)

    def _insert(self, item, current):
        '''
        This function adds an item to the tree depending if it is less than or greater than the value
        before it. If the value already exist it will get ignored and display a message
        :param item:
        :param current:
        :return:
        '''
        if item < current.data:
            if current.left == None:
                current.left = Node(item)
                current.left.parent = current
                self.size = self.size + 1
            else:
                self._insert(item, current.left)
        elif item > current.data:
            if current.right == None:
                current.right = Node(item)
                current.right.parent = current
                self.size = self.size + 1
            else:
                self._insert(item, current.right)

        else:
            print('Value is already inserted')

    def __contains__(self, item):
        '''
        This overwrites the in operator to check if a item is in the tree or not. This also uses a helper
        function to keep track of the root
        :param item:
        :return:
        '''
        if self.root != None:
            found = self._found(item, self.root)
            if found == True:
                return True
            else:
                return False
        else:
            return None
    def _found(self, item, current):
        '''
        This traverses over the tree and checks if the item the user is looking for is in the tree.
        If the value is found it will return True. If not, it will return False
        :param item:
        :param current:
        :return:
        '''
        if item > current.data and current.right != None:
            return self._found(item, current.right)
        if item < current.data and current.left != None:
            return self._found(item, current.left)
        if item == current.data:
            return True

    def find(self, item):
        '''
        This does the exact same thing as the contains function to keep hold of the root
        :param item:
        :return:
        '''
        if self.root != None:
            return self._find(item, self.root)
        else:
            return None
    def _find(self, item, current):
        '''
        This does the same thing as the _found function except this returns it's value rather than a
        Boolean
        :param item:
        :param current:
        :return:
        '''
        if item == current.data:
            return current
        elif item < current.data and current.left != None:
            return self._find(item, current.left)
        elif item > current.data and current.right != None:
            return self._find(item, current.right)

    def delete(self, item):
        '''
        This function calls the helper function delete_n to return it's value
        :param item:
        :return:
        '''
        return self.delete_n(self.find(item))
    def delete_n(self, node):
        '''
        This function utilizes 2 functions. One to find the minimum value of the tree and to find the
        number of children a parent that's being deleted has. Once it finds those things it uses the
        parent node to keep hold on what value is the parent and which is the child. This way we can
        move the left and right child to the parent if we delete a parent. This function covers all
        cases of 0 to 1 to 2 children.
        :param node:
        :return:
        '''
        def min_value(n):
            '''
            Finds the min value which sets the left child
            :param n:
            :return:
            '''
            current = n
            while current.left != None:
                current = current.left
            return current
        def num_child(n):
            '''
            This function counts how many children a parent has
            :param n:
            :return:
            '''
            num_children = 0
            if n.left != None:
                num_children += 1
            if n.right != None:
                num_children += 1
            return num_children
        node_parent = node.parent
        node_children = num_child(node)
        if node_children == 0:
            if node_parent.left == node:
                node_parent.left = None
            else:
                node_parent.right = None
            self.size = self.size - 1
        if node_children == 1:
            if node.left != None:
                child = node.left
            else:
                child = node.right
            if node_parent.left == node:
                node_parent.left = child
            else:
                node_parent.right = child
            child.parent = node_parent
            self.size = self.size - 1

        if node_children == 2:
            successor = min_value(node.right)
            node.data = successor.data
            self.delete_n(successor)
            self.size = self.size - 1


    def traverse_preorder(self, node = None):
        '''
        This function goes through the tree from the top to left and over, goes back up and reads down
        the right side
        :param node:
        :return:
        '''
        if node == None:
            return
        if node:
            print(node.data)
            self.traverse_preorder(node.left)
            self.traverse_preorder(node.right)


    def traverse_inorder(self, node = None):
        '''
        This function goes through the tree from least to greatest and displays it to the user
        :param node:
        :return:
        '''
        if node == None:
           return
        if node:
            self.traverse_inorder(node.left)
            print(node.data)
            self.traverse_inorder(node.right)

    def traverse_postorder(self, node = None):
        '''
        This function goes through the tree from greatest to least and displays it to the user
        :param node:
        :return:
        '''
        if node == None:
            return
        if node:
            self.traverse_postorder(node.left)
            self.traverse_postorder(node.right)
            print(node.data)



































def main():
    '''
    This function test all cases and properties of the BST
    :return:
    '''

    print('This is test code to test all properties of the Binary Search Tree (BST)')
    print('\n')
    tree = Binary_Tree()
    print('I insert the  values 20, 15, 16, 25, 30, 22, 14')
    tree.insert(20)
    tree.insert(15)
    tree.insert(16)
    tree.insert(25)
    tree.insert(30)
    tree.insert(22)
    tree.insert(14)
    tree.root.display()
    print('\n')
    print('This is how many items are in the tree so far')
    print(len(tree))
    print('\n')
    print('This test if the number 16 is in the tree, Should return True')
    if 16 in tree:
        print(True)
    else:
        print(False)
    print('\n')
    print('This test if the number 21 is in the tree, Should return False')
    if 21 in tree:
        print(True)
    else:
        print(False)

    print('This uses the inorder traversal function to show the items least to greatest')
    print('\n')
    tree.traverse_inorder(tree.root)
    print('\n')
    print(format('This uses the preorder traversal function to show the items top to bottom left and up, to bottom right and up '), '-^100')
    tree.traverse_preorder(tree.root)
    print('\n')
    print(format('This uses the postorder traversal function to show the items greatest to least'), '-^100')
    tree.traverse_postorder(tree.root)
    print('\n')


    print('This test the delete function, deleting 14...')
    tree.delete(14)
    tree.root.display()
    print('\n')
    print(format('Deleting 25...'), '-^80')
    tree.delete(25)
    tree.root.display()
    print('\n')
    print(format('Deleting 20...'), '-^80')
    tree.delete(20)
    tree.root.display()
    print('\n')

    print("That's it for testing, thanks for coming")
main()


