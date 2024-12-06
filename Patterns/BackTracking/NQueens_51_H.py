class Solution:
    def solveNQueens(self, n):
        finalRes = []
        matrix = []
        for i in range(n):
            matrix.append("")
            for j in range(n):
                matrix[i]+="."

        self.traverse(n,0,0,matrix,finalRes,0)
        return finalRes
    def isPresentInLeftUp(self,matrix,row,col):
        i=row-1
        j=col-1
        while i>=0 and j>=0:
            if matrix[i][j]=='Q':
                return True
            i-=1
            j-=1
        return False
    def isPresentInRightUp(self,n,matrix,row,col):
        i=row-1
        j=col+1
        while j<n and row>=0:
            if matrix[i][j]=='Q':
                return True
            i-=1
            j+=1
        return False 
    def  traverse(self,n,row,col,matrix,finalRes, curPlaced):
        if row>=n and curPlaced>=n and matrix not in finalRes:
            finalRes.append(matrix) 
        elif row>=n:
            return
        else:
            isPresentInRow = True if "Q" in matrix[row] else False
            isPresentInCol = False
            if not isPresentInRow:
                for i in range(0,row):
                    if matrix[i][col]=='Q':
                        isPresentInCol = True
                        break
            nextCol = col+1
            nextRow = row
            if nextCol>=n:
                nextCol = 0
                nextRow+=1
            if isPresentInCol or isPresentInRow or self.isPresentInLeftUp(matrix,row,col) or self.isPresentInRightUp(n,matrix,row,col):
                self.traverse(n,nextRow,nextCol,matrix,finalRes,curPlaced)
            else:
                self.traverse(n,nextRow,nextCol,matrix,finalRes,curPlaced)
                matrixCopy = list(matrix)
                matrixCopy[row] = matrixCopy[row][:col] + "Q" + matrixCopy[row][col + 1:]
                self.traverse(n,nextRow,nextCol,matrixCopy,finalRes,curPlaced+1)

            
m = Solution()
s = m.solveNQueens(4)
print(s)