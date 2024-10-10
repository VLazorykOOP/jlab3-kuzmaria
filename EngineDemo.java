public class EngineDemo {
    public static void main(String[] args) {
        Engine[] engines = new Engine[3];

        engines[0] = new InternalCombustionEngine(150, "Petrol", 4, 2.0);
        engines[1] = new DieselEngine(180, "Diesel", 6, 3.5, true);
        engines[2] = new JetEngine(5000, "Kerosene", 100, 5.0);

        for (Engine engine : engines) {
            engine.Show();
            System.out.println("---------------");
        }
    }

    static class Engine {
        protected double power; 
        protected String fuelType; 

        public Engine(double power, String fuelType) {
            this.power = power;
            this.fuelType = fuelType;
        }

        public void Show() {
            System.out.println("Engine Power: " + power + " kW");
            System.out.println("Fuel Type: " + fuelType);
        }
    }

    static class InternalCombustionEngine extends Engine {
        private final int cylinders; 
        private final double displacement; 

        public InternalCombustionEngine(double power, String fuelType, int cylinders, double displacement) {
            super(power, fuelType);
            this.cylinders = cylinders;
            this.displacement = displacement;
        }

        @Override
        public void Show() {
            super.Show();
            System.out.println("Cylinders: " + cylinders);
            System.out.println("Displacement: " + displacement + " L");
        }
    }

    static class DieselEngine extends InternalCombustionEngine {
        private final boolean turbocharged; 

        public DieselEngine(double power, String fuelType, int cylinders, double displacement, boolean turbocharged) {
            super(power, fuelType, cylinders, displacement);
            this.turbocharged = turbocharged;
        }

        @Override
        public void Show() {
            super.Show();
            System.out.println("Turbocharged: " + (turbocharged ? "Yes" : "No"));
        }
    }

    static class JetEngine extends Engine {
        private final double thrust; 
        private final double bypassRatio; 

        public JetEngine(double power, String fuelType, double thrust, double bypassRatio) {
            super(power, fuelType);
            this.thrust = thrust;
            this.bypassRatio = bypassRatio;
        }

        @Override
        public void Show() {
            super.Show();
            System.out.println("Thrust: " + thrust + " kN");
            System.out.println("Bypass Ratio: " + bypassRatio);
        }
    }
}
