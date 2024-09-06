
public class Radar {
    private DiscreteSignal signal;

    public Radar(DiscreteSignal signal) {
        this.signal = signal;
    }

    public double getSignalValueAt(int n) {
        return signal.getValueAt(n);
    }

    public void displaySignalValues() {
        for (int i = 0; i <= 15; i++) {
            System.out.println("Value at position " + i + ": " + getSignalValueAt(i));
        }
    }

    public void displaySignalInfo() {
        signal.displaySignalInfo();
    }