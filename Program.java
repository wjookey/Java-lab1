public class Program {
    public static void main(String args[])
    {
        Complex complex1 = new Complex(5, 0);
        Complex complex2 = new Complex(6, 4);

        // работа с классом комплесных чисел
        Complex complex3 = complex1.mult(complex2); // вычисляем произведение
        System.out.printf("complex1 * complex2 = ");
        complex3.print('c');
        System.out.println();
        Complex complex4 = complex1.div(complex2); // вычисляем частное
        System.out.printf("complex1 / complex2 = ");
        complex4.print('c');
        System.out.println();
        Complex complex5 = complex1.sum(complex2); // вычисляем сумму
        System.out.printf("complex1 + complex2 = ");
        complex5.print('c');
        System.out.println();
        Complex complex6 = complex1.diff(complex2); // вычисляем разность
        System.out.printf("complex1 - complex2 = ");
        complex6.print('c');

        System.out.println();

        // работа с матрицами разного размера
        double values1[][] = { { 1, 0, 3, 4, 1, 1 }, { 6, 2, 1, 7, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
        // значения для матриц (построчно чётные индексы соответствуют действительной части комплексного числа, нечётные - мнимой)
        double values2[][] = { { 0, 3, 7, 4, 3, 1 }, { 1, -1, -4, 2, 9, 0 } };

        Matrix matrix1 = new Matrix(values1);
        Matrix matrix2 = new Matrix(values2);

        Matrix matrix3 = matrix1.sum(matrix2);     // вычисляем сумму
        System.out.println("matrix1 + matrix2 = ");
        matrix3.print();
        System.out.println();

        Matrix matrix4 = matrix1.diff(matrix2);     // вычисляем разность
        System.out.println("matrix1 - matrix2 = ");
        matrix4.print();
        System.out.println();

        matrix1.setElemRe(0, 0, 2);     // меняем значения комплексного числа в матрице
        matrix1.setElemIm(0, 0, -1);
        System.out.printf("New values of complex number in matrix: %.1f %.1f\n", matrix1.getElemRe(0, 0), matrix1.getElemIm(0, 0));
        System.out.println();

        Matrix matrix5 = matrix1.multMatrix(matrix2);     // умножаем матрицы
        System.out.println("matrix1 * matrix2 = ");
        matrix5.print();
        System.out.println();

        matrix1 = matrix1.transposition();     // транспонируем матрицу
        System.out.println("Transposed matrix1: ");
        matrix1.print();
        System.out.println();

        Complex determinant1 = matrix1.determinant();    // находим детерминант
        System.out.printf("det matrix1 = ");
        determinant1.print('c');
        System.out.println();

        Matrix matrix6 = matrix1.multNum(complex1);     // умножаем на число
        System.out.println("matrix1 * complex1 = ");
        matrix6.print();
        System.out.println();

        // работа с квадратными матрицами одинакового размера
        double values3[][] = { { 5, 1, 7, 2 }, { 8, 1, 9, 3 } };
        // значения для матриц (построчно чётные индексы соответствуют действительной части комплексного числа, нечётные - мнимой)
        double values4[][] = { { 12, 5, 3, 8 }, { 7, 0, 42, 6} };

        Matrix matrix7 = new Matrix(values3);
        Matrix matrix8 = new Matrix(values4);

        Matrix matrix9 = matrix7.sum(matrix8);    // вычисляем сумму
        System.out.println("matrix7 + matrix8 = ");
        matrix9.print();
        System.out.println();

        Matrix matrix10 = matrix7.diff(matrix8);    // вычисляем разность
        System.out.println("matrix7 - matrix8 = ");
        matrix10.print();
        System.out.println();

        Matrix matrix11 = matrix7.multMatrix(matrix8);     // умножаем матрицы
        System.out.println("matrix7 * matrix8 = ");
        matrix11.print();
        System.out.println();

        matrix7 = matrix7.transposition();    // транспонируем матрицу
        System.out.println("Transposed matrix7: ");
        matrix7.print();
        System.out.println();

        Complex determinant2 = matrix7.determinant();     // вычисляем детерминант
        System.out.printf("det matrix7 = ");
        determinant2.print('c');
        System.out.println();
    }

}
