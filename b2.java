public class Assignment2 {
    public static void main(String[] args) {
    Number n1 = new Number();
    Number n2 = new Number();
    n1.i = 2;
    n2.i = 5;
    n1 = n2;//Gán tham chiếu của n2 cho n1. Từ thời điểm này, cả n1 và n2 đều trỏ đến cùng một đối tượng Number. 
    n2.i = 10;//   n1.i cũng sẽ là 10 vì cả hai biến trỏ đến cùng một đối tượng
    n1.i = 20;//   n2.i cũng sẽ là 20 vì cả hai biến trỏ đến cùng một đối tượng
    }
   }