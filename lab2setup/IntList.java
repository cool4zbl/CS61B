import java.util.Arrays;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /**
     * Return the size of this IntLIst.
     */
    public int size() {
        if (this.rest == null) return 1;
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        int size = 0;
        IntList p = this;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return size;
    }

    public int get(int index) {
        int size = this.size();
        if (index >= size || (this.rest == null && index != 0)) {
            throw new IllegalArgumentException("Out of range");
        }
        int i = 0;
        IntList p = this;
        while (i < index) {
            p = p.rest;
            i++;
        }
        return p.first;
    }

    public int recursionGet(int index) {
        int size = this.size();
        if (index >= size || (this.rest == null && index != 0)) {
            throw new IllegalArgumentException("Out of range");
        }
        if (index == 0) {
            return this.first;
        }
        return this.rest.recursionGet(index - 1);
    }

    /**
     * 1. Returns an IntList identical to L, but with all values incremented by x
     * 2. Values in L cannot change!.
     */
    public static IntList incrList(IntList L, int x) {
        int size = L.size();
        IntList Q = new IntList(L.get(size - 1) + x, null);
        int i = size - 2;
        while (i >= 0) {
            Q = new IntList(L.get(i) + x, Q);
            i--;
        }
        return Q;
    }

    /**
     * 1. Returns an IntList identical to L, but with all values incremented by x
     * 2. Values in L cannot change!.
     * 3. with recursion.
     */
    public static IntList incrList2(IntList L, int x) {
        if (L == null) return L;

        IntList Q = new IntList(L.first + x, null);
        Q.rest = incrList2(L.rest, x);
        return Q;
    }

    /**
     * 1. Returns an IntList identical to L, but with all values incremented by x.
     * 2. Not allowed to use `new` (to save memory)
     *
     * @param L IntList
     * @param x incremented value
     * @return IntList
     */
//    public static IntList dincrList(IntList L, int x) {
//        int size = L.size();
//
//    }
    public String toString() {
        int[] a = new int[this.size()];
        int cnt = 0;
        for (IntList p = this; p != null; p = p.rest) {
            a[cnt] = p.first;
            cnt++;
        }
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);

        IntList L = new IntList(5, null);
        L = new IntList(6, L);
        L = new IntList(7, L);
        System.out.println(L);

        IntList Q = IntList.incrList(L, 3);
        System.out.println(Q);

        IntList Q2 = IntList.incrList2(L, 4);
        System.out.println(Q2);
    }
}
