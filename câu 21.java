//Câu 2.1:
public class DiscreteSignal implements Signal {
    private double amplitude, frequency, period, wavelength;
    private int impulsePosition;

    public DiscreteSignal(double amplitude, double frequency, double period, double wavelength, int impulsePosition) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.period = period;
        this.wavelength = wavelength;
        this.impulsePosition = impulsePosition;
    }

    @Override
    public double getAmplitude() { return amplitude; }

    @Override
    public void setAmplitude(double amplitude) { this.amplitude = amplitude; }

    @Override
    public double getFrequency() { return frequency; }

    @Override
    public void setFrequency(double frequency) { this.frequency = frequency; }

    @Override
    public double getPeriod() { return period; }

    @Override
    public void setPeriod(double period) { this.period = period; }

    @Override
    public double getWavelength() { return wavelength; }

    @Override
    public void setWavelength(double wavelength) { this.wavelength = wavelength; }

    public double getValueAt(int n) {
        return (n == impulsePosition) ? amplitude : 0;
    }

    public void displaySignalInfo() {
        System.out.println("Discrete Signal - Amplitude: " + amplitude + 
                           ", Frequency: " + frequency + 
                           ", Period: " + period + 
                           ", Wavelength: " + wavelength +
                           ", Impulse Position: " + impulsePosition);
    }
}
