abstract class AbstractNorm {
    public abstract double calculateModule();
    public abstract double calculateNorm();

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}

class Vector2DNew extends AbstractNorm {
    private double x;
    private double y;

    public Vector2DNew(double x, double y) {
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
        return "Vector2DNew(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2DNew vector2D = (Vector2DNew) obj;
        return Double.compare(vector2D.x, x) == 0 && Double.compare(vector2D.y, y) == 0;
    }
}

class Vector3DNew extends AbstractNorm {
    private double x;
    private double y;
    private double z;

    public Vector3DNew(double x, double y, double z) {
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
        return "Vector3DNew(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector3DNew vector3D = (Vector3DNew) obj;
        return Double.compare(vector3D.x, x) == 0 &&
               Double.compare(vector3D.y, y) == 0 &&
               Double.compare(vector3D.z, z) == 0;
    }
}

public class NormDemo {
    public static void main(String[] args) {
        AbstractNorm[] vectors = new AbstractNorm[3];
        vectors[0] = new Vector2DNew(3, 4);   
        vectors[1] = new Vector3DNew(1, 2, 3); 
        vectors[2] = new Vector3DNew(5, 6, 7); 
        
        for (AbstractNorm vector : vectors) {
            System.out.println(vector.toString());
            System.out.println("Module: " + vector.calculateModule());
            System.out.println("Norm: " + vector.calculateNorm());
            System.out.println("---------------");
        }
    }
}
