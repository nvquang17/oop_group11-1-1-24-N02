//Câu 1:
interface Signal {
    public void displayInfo();
}


 class DiscreteSignal implements Signal {
    private double amplitude;
    private double frequency;
    private double period;
    private double wavelength;

    public DiscreteSignal(double amplitude, double frequency, double period, double wavelength) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.period = period;
        this.wavelength = wavelength;
    }

    @Override
    public void displayInfo() {
        System.out.println("Discrete Signal: Amplitude = " + amplitude + ", Frequency = " + frequency + 
                           ", Period = " + period + ", Wavelength = " + wavelength);
    }
}

//3
 class ContinuousSignal implements Signal {
    private double amplitude;
    private double frequency;
    private double period;
    private double wavelength;

    public ContinuousSignal(double amplitude, double frequency, double period, double wavelength) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.period = period;
        this.wavelength = wavelength;
    }

    @Override
    public void displayInfo() {
        System.out.println("Continuous Signal: Amplitude = " + amplitude + ", Frequency = " + frequency + 
                           ", Period = " + period + ", Wavelength = " + wavelength);
    }
}


public class Main {
    public static void main(String[] args) {
        Signal discreteSignal = new DiscreteSignal(1.0, 1000, 0.001, 300);
        discreteSignal.displayInfo();

        Signal continuousSignal = new ContinuousSignal(2.0, 2000, 0.0005, 600);
        continuousSignal.displayInfo();
    }
}
