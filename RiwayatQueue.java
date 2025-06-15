public class RiwayatQueue {
    TransaksiPengisian[] data;
    int front, rear, size, max;

    public RiwayatQueue() {
        max = 100;
        data = new TransaksiPengisian[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(TransaksiPengisian dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh!");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Riwayat Transaksi tidak ada!\n");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i].kendaraan.platNomor + ": Rp. " + data[i].totalBayar);
                i = (i + 1) % max;
            }
            System.out.println(data[i].kendaraan.platNomor + ": Rp. " + data[i].totalBayar + "\n");
        }
    }
}