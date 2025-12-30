package P2_E11;

public class TopografiaSimple extends Topografia {
    private boolean esAgua;

    public TopografiaSimple(boolean esAgua) {
        this.esAgua = esAgua;
    }

    @Override
    public double proporcionAgua() {
        return esAgua ? 1.0 : 0.0;
    }

    @Override
    protected boolean equalsTopografia(Topografia otra) {
        TopografiaSimple otraSimple = (TopografiaSimple) otra;
        return this.esAgua == otraSimple.esAgua;
    }
}


