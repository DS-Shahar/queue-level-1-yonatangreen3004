public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();
        q.insert(3);
        q.insert(2);
        q.insert(2);
        q.insert(7);

        Queue<Integer> q2 = new Queue<>();
        q2.insert(1);
        q2.insert(2);
        q2.insert(4);

        System.out.println(cloneQueue(q));
        System.out.println(ex2(q));
        System.out.println(ex3(q, 2));
        System.out.println(ex4(q, q2));
        System.out.println(ex5(q, 2));
        System.out.println(ex5(q, 3));
    }

    public static Queue<Integer> copyQueue(Queue<Integer> q) {
        Queue<Integer> copy = new Queue<>();
        Queue<Integer> temp = new Queue<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            copy.insert(x);
            temp.insert(x);
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return copy;
    }
//יעילות של O(2N) כש n זה אורך התור
}

    public static Queue<Integer> cloneQueue(Queue<Integer> q) {
        return copyQueue(q);
    }

    public static double ex2(Queue<Integer> q) {
        Queue<Integer> c = copyQueue(q);
        int sum = 0, count = 0;

        while (!c.isEmpty()) {
            sum += c.remove();
            count++;
        }

        return (double) sum / count;
    }
//יעילות של O(N) כש n זה אורך התור
}

    public static int ex3(Queue<Integer> q, int x) {
        if (x == 0) return 0;

        Queue<Integer> c = copyQueue(q);
        int count = 0;

        while (!c.isEmpty()) {
            if (c.remove() % x == 0)
                count++;
        }

        return count;
    }
//יעילות של O(N) כש n זה אורך התור
}

    public static boolean ex4(Queue<Integer> q2, Queue<Integer> q1) {
        Queue<Integer> c2 = copyQueue(q2);
        Queue<Integer> c1 = copyQueue(q1);

        while (!c2.isEmpty()) {
            int a = c2.remove();
            boolean found = false;

            Queue<Integer> temp = copyQueue(c1);
            while (!temp.isEmpty()) {
                if (a % temp.remove() == 0)
                    found = true;
            }

            if (!found)
                return false;
        }

        return true;
    }
//יעילות של O(N בריבוע) כש n זה אורך התור
}

    public static boolean ex5(Queue<Integer> q, int x) {
        Queue<Integer> c = copyQueue(q);
        int prev = Integer.MIN_VALUE;

        while (!c.isEmpty()) {
            int curr = c.remove();
            if (curr == x && prev == x)
                return true;
            prev = curr;
        }

        return false;
    }
//יעילות של O(N) כש n זה אורך התור
}



ex11/txt:
הפעולה מקבלת תור וערך x, מסירה מהתור את כל ההופעות של x,
ומחזירה לתור את שאר האיברים בסדר הפוך
