public class RiwayatQueue {
    int[] data;
    int front, rear, size, max;

    public RiwayatQueue() {
        max = 100;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }
}