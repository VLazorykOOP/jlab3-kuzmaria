interface Norm {
    double calculateModule();
    double calculateNorm();

    @Override
    String toString();

    @Override
    boolean equals(Object obj);
}

class Vector2D implements Norm {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateModule() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double calculateNorm() {
        double module = calculateModule();
        return module * module;
    }

    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2D vector2D = (Vector2D) obj;
        return Double.compare(vector2D.x, x) == 0 && Double.compare(vector2D.y, y) == 0;
    }
}

class Vector3D implements Norm {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double calculateModule() {
        return Math.max(Math.max(Math.abs(x), Math.abs(y)), Math.abs(z));
    }

    @Override
    public double calculateNorm() {
        double module = calculateModule();
        return module * module;
    }

    @Override
    public String toString() {
        return "Vector3D(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector3D vector3D = (Vector3D) obj;
        return Double.compare(vector3D.x, x) == 0 &&
               Double.compare(vector3D.y, y) == 0 &&
               Double.compare(vector3D.z, z) == 0;
    }
}

public class NormDemo2 {
    public static void main(String[] args) {
        Norm[] vectors = new Norm[3];
        vectors[0] = new Vector2D(3, 4);   
        vectors[1] = new Vector3D(1, 2, 3); 
        vectors[2] = new Vector3D(5, 6, 7); 
        for (Norm vector : vectors) {
            System.out.println(vector.toString());
            System.out.println("Module: " + vector.calculateModule());
            System.out.println("Norm: " + vector.calculateNorm());
            System.out.println("---------------");
        }
    }
}
