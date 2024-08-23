public class Assignment2 {
    public static void main(String[] args) {
    Number n1 = new Number();
    Number n2 = new Number();
    n1.i = 2;
    n2.i = 5;
    n1 = n2;// Cả n1 và n2 đều tham chiếu đến đối tượng 'i=5'
    n2.i = 10;// n1 và n2 tham chiếu cùng đối tượng ==> n1.i=10
    n1.i = 20;// Tương tự, n2.i cũng bằng 20
    }
    }