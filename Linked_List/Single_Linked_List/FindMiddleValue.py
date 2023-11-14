class FindMiddleValue():
    lengthCount = 0;
    finalAnswer = None;

    def execute(self, node):
        if node is None:
            self.lengthCount = (self.lengthCount // 2) + 1
        else:
            self.lengthCount = self.lengthCount + 1
            index = self.lengthCount
            self.execute(node.next)
            if index == self.lengthCount:
                self.finalAnswer = node.value
        return

    def getMiddleValue(self, node):
        self.execute(node)
        return self.finalAnswer
