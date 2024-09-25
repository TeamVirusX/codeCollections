class Node:
    # Create a new node with the value passed to the function
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def append(self, value):
        # If the head property is null set the head and tail to be the newly created node
        newNode = Node(value)
        if self.length == 0:
            self.head = newNode
            self.tail = newNode
        # If not...
        else:
            # Set the next property on the tail to be that node
            self.tail.next = newNode
            # Set the previous property on the newly created node to be the tail
            newNode.prev = self.tail
            # Set the tail to be the newly created node
            self.tail = newNode
        # Increment the length
        self.length += 1
        # Return the Doubly Linked List
        return self
    
    def __str__(self):
        if self.head is None:
            return "[]"  # Return an empty list string if the list is empty
        current = self.head
        result = []
        while current:
            result.append(str(current.value))
            current = current.next
        return " <-> ".join(result)

# Example Usage
dll = DoublyLinkedList()
dll.append(1)
dll.append(2)
dll.append(3)

print(dll)  # Output: 1 <-> 2 <-> 3