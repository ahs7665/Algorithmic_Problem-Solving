class Solution {
    int n;
    int[] root;
    int count;

    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        root = new int[n*n*4];
        for (int i = 0; i < n*n*4; i++) {
            root[i] = i;
        }
        count = n*n*4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (i > 0) {
                    union(parse(i - 1, j, 2), parse(i, j, 0));
                }
                if (j > 0) {
                    union(parse(i, j - 1, 1), parse(i, j, 3));
                }
                if (c != '/') {
                    union(parse(i, j, 0), parse(i, j, 1));
                    union(parse(i, j, 2), parse(i, j, 3));
                }
                if (c != '\\') {
                    union(parse(i, j, 0), parse(i, j, 3));
                    union(parse(i, j, 1), parse(i, j, 2));
                }
            }
        }
        return count;
    }

    private int parse(int x, int y, int z) {
        return (x*n + y)*4 + z;
    }

    private void union(int a, int b) {
        int r1 = findRoot(root, a);
        int r2 = findRoot(root, b);
        if (r1 != r2) {
            count--;
            root[r2] = r1;
        }
    }

    private int findRoot(int[] root, int p) {
        while (root[p] != p) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }
}
