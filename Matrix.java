public class Matrix {
    private Complex matrix[][];
    private int row, col;

    public Matrix(double arr[][]) // значения передаются в конструктор в таком виде: Re1 Im1 Re2 Im2 ... ReN ImN
    {
        row = arr.length;
        col = arr[0].length / 2;
        matrix = new Complex[row][col];
        for (int i = 0; i < arr.length; i++) {
            int index = 0;
            for (int j = 0; j < arr[i].length; j += 2) {
                Complex newOb = new Complex(arr[i][j], arr[i][j + 1]);
                matrix[i][index] = newOb;
                index++;
            }
        }
    }
    
    public Matrix(int rowVal, int colVal)
    {
        row = rowVal;
        col = colVal;
        matrix = new Complex[row][col];
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                Complex elem = new Complex();
                matrix[i][j] = elem;
            }
        }
    }

    public double getElemRe(int rowNum, int colNum)
    {
        return this.matrix[rowNum][colNum].getRe();
    }

    public double getElemIm(int rowNum, int colNum)
    {
        return this.matrix[rowNum][colNum].getIm();
    }

    public void setElemRe(int rowNum, int colNum, double reVal)
    {
        this.matrix[rowNum][colNum].setRe(reVal);
    }

    public void setElemIm(int rowNum, int colNum, double imVal)
    {
        this.matrix[rowNum][colNum].setIm(imVal);
    }

    public int getRow()
    {
        return this.row;
    }

    public int getCol()
    {
        return this.col;
    }

    public Matrix transposition()     // транспонирование матрицы
    {
        Matrix newMatrix = new Matrix(this.col, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        matrix = null;
        return newMatrix;
    }

    public Matrix sum(Matrix other)     // сумма матриц
    {
        if (this.row == other.row && this.col == other.col)
        {
            Matrix newMatrix = new Matrix(this.row, this.col);
            for (int i = 0; i < newMatrix.row; i++) {
                for (int j = 0; j < newMatrix.col; j++) {
                    newMatrix.matrix[i][j] = this.matrix[i][j].sum(other.matrix[i][j]);
                }
            }
            return newMatrix;
        }
        else {
            System.out.println("You can't find sum of these matrixes");
            Matrix newMatrix = new Matrix(1, 1);
            return newMatrix;
        }
    }

    public Matrix diff(Matrix other)     // разность матриц
    {
        
        if (this.row == other.row && this.col == other.col)
        {
            Matrix newMatrix = new Matrix(this.row, this.col);
            for (int i = 0; i < newMatrix.row; i++) {
                for (int j = 0; j < newMatrix.col; j++) {
                    newMatrix.matrix[i][j] = this.matrix[i][j].diff(other.matrix[i][j]);
                }
            }
            return newMatrix;
        }
        else {
            System.out.println("You can't find difference of these matrixes");
            Matrix newMatrix = new Matrix(1, 1);
            return newMatrix;
        }
        
    }
    
    public Matrix multMatrix(Matrix other)     // произведение матриц
    {
        if (this.col == other.row) {
            Matrix newMatrix = new Matrix(this.row, other.col);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < other.col; j++) {
                    for (int k = 0; k < this.col; k++) {
                        newMatrix.matrix[i][j] = newMatrix.matrix[i][j].sum(this.matrix[i][k].mult(other.matrix[k][j]));
                    }
                }
            }
            return newMatrix;
        } else {
            System.out.printf("You can't multiply these matrixes\n");
            Matrix newMatrix = new Matrix(1, 1);
            return newMatrix;
        }
    }

    public Matrix multNum(Complex num)     // произведение матрицы на число
    {
        Matrix newMatrix = new Matrix(this.row, this.col);
        for (int i = 0; i < this.row; i++)
        {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j].mult(num);
            }
        }
        return newMatrix;
    }

    public Matrix calculateMinor(Matrix src, int index)     // вычисление минора
    {
        Matrix tmp = new Matrix(src.row - 1, src.row - 1);
        int index1 = 0;
        for (int i = 1; i < src.row; i++)
        {
            int index2 = 0;
            for (int j = 0; j < src.col; j++) {
                if (j != index) {
                    tmp.matrix[index1][index2] = src.matrix[i][j];
                    index2++;
                }
            }
            index1++;
        }
        return tmp;
    }
    
    public Complex determinant()     // вычисление детерминанта матрицы
    {
        if (this.row != this.col)
        {
            System.out.println("You can't calculate determinant");
            Complex newTmp = new Complex(0, 0);
            return newTmp;
        }
        if (this.row == 1)
        {
            return this.matrix[0][0];
        }
        Complex result = new Complex();
        for (int i = 0; i < this.col; i++)
        {
            Complex cur_ans = new Complex();
            Matrix newTmp = calculateMinor(this, i);
            cur_ans = newTmp.determinant().mult(this.matrix[0][i]);
            if (i % 2 != 0) {
                Complex tmp = new Complex(-1, 0);
                result = result.sum(cur_ans.mult(tmp));
            } else {
                result = result.sum(cur_ans);
            }
        }
        return result;
    }
    
    public void print()     // вывод матрицы
    {
        for (int i = 0; i < this.row; i++)
        {
            System.out.printf("|");
            for (int j = 0; j < this.col; j++)
            {
                this.matrix[i][j].print('r');
                if (j != this.col - 1)
                {
                    System.out.printf("   ");
                }
            }
            System.out.println("|");
        }
    }
}
