public class Number {
    public int i;
   }
   public class Assignment1 {
    public static void main(String[] args) {
    Number n1 = new Number();
    Number n2 = new Number();
    n1.i = 2;
    n2.i = 5;
    n1.i = n2.i;//Gán giá trị của n2.i (là 5) cho n1.i. Lúc này, n1.i có giá trị 5
    n2.i = 10;// Gán giá trị 10 cho n2.i. Tuy nhiên, điều này không ảnh hưởng đến giá trị của n1.i.==> Giá trị của n1.i sau khi chạy chương trình sẽ là 5
    }
   }