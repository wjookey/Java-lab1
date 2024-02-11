public class Complex {
    private double re;
    private double im;

    public Complex(double reVal, double imVal)
    {
        re = reVal;
        im = imVal;
    }

    public Complex()
    {
        re = 0.0;
        im = 0.0;
    }

    public double getRe()
    {
        return this.re;
    }

    public double getIm()
    {
        return this.im;
    }

    public void setRe(double reVal)
    {
        this.re = reVal;
    }

    public void setIm(double imVal)
    {
        this.im = imVal;
    }

    public Complex sum(Complex other)     // сумма комплексных чисел
    {
        Complex newOb = new Complex(this.re + other.re, this.im + other.im);
        return newOb;
    }

    public Complex diff(Complex other)     // разность комплексных чисел
    {
        Complex newOb = new Complex(this.re - other.re, this.im - other.im);
        return newOb;
    }

    public Complex mult(Complex other)     // произведение комплексных чисел
    {
        Complex newOb = new Complex(this.re * other.re + this.im * other.im * (-1),
                this.re * other.im + this.im * other.re);
        return newOb;
    }

    public Complex div(Complex other)     // частное комплексных чисел
    {
        Complex tmp = new Complex(other.re, (-1) * other.im);
        Complex tmpMult = this.mult(tmp);
        Complex tmpDiv = other.mult(tmp);
        tmpMult.re /= tmpDiv.re;
        tmpMult.im /= tmpDiv.re;
        return tmpMult;
    }

    public void print()     // вывод комплексного числа/комплексных чисел
    {
        if (this.im >= 0) {
        System.out.printf("%.1f + %.1f * i", this.re, this.im);
        } 
        else {
            System.out.printf("%.1f - %.1f * i", this.re, (-1) * this.im);
        }
    }
}
