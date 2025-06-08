public class LinkedListAntrian {
    NodeLinkedListAntrian head;
    NodeLinkedListAntrian tail;
    int ttl_antrian = 0;
    
    LinkedListAntrian() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        NodeLinkedListAntrian temp = head;
        if (isEmpty()) {
            System.out.println("Antrian masih kosong! \n");
        }
        while (temp != null) {
            temp.data.tampilkanInformasi();
            temp = temp.next;
        }
    }

    public void addLast(Kendaraan data) {
        NodeLinkedListAntrian newNode = new NodeLinkedListAntrian(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ttl_antrian++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
        ttl_antrian--;
    }

    public int getSize() {
        return ttl_antrian;
    }
}
