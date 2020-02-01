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
        if (L == null) return null;

        IntList Q = new IntList(L.first + x, null);
        IntList p = Q;
        L = L.rest;
        while (L != null) {
            p.rest = new IntList(L.first + x, null);
            L = L.rest;
            p = p.rest;
        }
        return Q;
    }

    /**
     * 1. Returns an IntList identical to L, but with all values incremented by x
     * 2. Values in L cannot change!.
     * 3. with recursion.
     */
    public static IntList incrList2(IntList L, int x) {
        if (L == null) return null;

        return new IntList(L.first + x, incrList2(L.rest, x));
//        IntList incr = new IntList(L.first + x, null);
//        incr.rest = incrList2(L.rest, x);
//        return incr;
    }

    /**
     * 1. Returns an IntList identical to L, but with all values incremented by x.
     * 2. Not allowed to use `new` (to save memory)
     *
     * @param L IntList
     * @param x incremented value
     * @return IntList
     */
    public static IntList dincrList(IntList L, int x) {
        if (L == null) return null;
        L.first += x;
        dincrList(L.rest, x);
        return L;
    }

    /**
     * Implement square and squareDestructive which are static methods that both
     * take in an IntList L and return an IntList with its integer values all squared.
     * square does this non-destructively with recursion by creating new IntLists while
     * squareDestructive uses a recursive approach to change the instance variables of
     * the input IntList L.
     *
     * @return an IntList with its integer values all squared.
     */
    public static IntList square(IntList L) {
        if (L == null) return null;

        return new IntList(L.first * L.first, square(L.rest));
    }

    public static IntList squareIterative(IntList L) {
        if (L == null) return null;

        IntList Q = new IntList(L.first * L.first, null);
        IntList p = Q;
        L = L.rest;
        while (L != null) {
            p.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            p = p.rest;
        }
        return Q;
    }

    public static IntList squareDestructive(IntList L) {
        if (L == null) return null;

        L.first *= L.first;
        squareDestructive(L.rest);
        return L;
    }

    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first *= L.first;
            L = L.rest;
        }
    }

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
        IntList L = new IntList(5, null);
        L = new IntList(6, L);
        L = new IntList(7, L);
        System.out.println(L);

        IntList Q = IntList.incrList(L, 3);
        System.out.println(Q);

        IntList Q2 = IntList.incrList2(L, 4);
        System.out.println(Q2);
        IntList Q3 = IntList.dincrList(L, 5);
        System.out.println(Q3);

        IntList Q4 = IntList.square(L);
        System.out.println(Q4);

        IntList Q6 = IntList.squareIterative(L);
        System.out.println("q6: " + Q6);
        System.out.println("q6 L: " + L);

        IntList Q5 = IntList.squareDestructive(L);
        System.out.println(L);
        System.out.println(Q5);
    }

}
