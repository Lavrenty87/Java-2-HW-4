public class Java2HW5 {
    final int size = 10000000;
    final int h = size / 2;

    public static void main(String[] args) {
        Java2HW5 e1 = new Java2HW5();

        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }
    public synchronized void method1() {

            float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;

            }
            long a = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(System.currentTimeMillis() - a);
        }
    public synchronized void method2() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        for (int i = 0; i < a1.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < a2.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}

