import java.util.*;

class Cells {
    int[] cells;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cells cells1 = (Cells) o;
        return Arrays.equals(cells, cells1.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    public Cells(int[] cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "Cells{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}

class Solution {
    List<Cells> cycle;
    Set<Cells> cellSet;

    public int[] prisonAfterNDays(int[] cells, int n) {
        cycle = new ArrayList<>();
        cellSet = new HashSet<>();

        Cells c = new Cells(cells);

        c = getNextPrison(c);

        for (int day = 1; day < n; day++) {
            cellSet.add(c);
            cycle.add(c);
            c = getNextPrison(c);
            if (cellSet.contains(c)) {
                int rem = (n - day - 1) % cellSet.size();
                return cycle.get(rem).cells;
            }
        }
        return c.cells;
    }

    Cells getNextPrison(Cells cells) {
        Cells newCells = new Cells(new int[cells.cells.length]);
        for (int i = 1; i < cells.cells.length - 1; i++) {
            int leftCell = cells.cells[i - 1];
            int rightCell = cells.cells[i + 1];
            if (leftCell == 1 && rightCell == 1) {
                newCells.cells[i] = 1;
                continue;
            } else if (leftCell == 0 && rightCell == 0) {
                newCells.cells[i] = 1;
                continue;
            }
            newCells.cells[i] = 0;
        }
        newCells.cells[0] = 0;
        newCells.cells[newCells.cells.length - 1] = 0;
        return newCells;
    }
}
