package Recursion;

/*
 Kunal Kushwaha - Recursion & Sorting
 Inverted Triangle Pattern (Preparation for Bubble Sort)
 Playlist Link : https://www.youtube.com/@KunalKushwaha

 Approach:
 - Recursion
 - Use the row pointer 'r' to represent the number of elements in the current row.
 - Use the column pointer 'c' to track the current position within that row.
 - Base Case: If 'r < 1', all rows have been successfully printed, so terminate the recursion.
 - Step 1 (Print Row Elements): If 'c < r', print a star, increment 'c' to 'c + 1', and recurse to handle the next column.
 - Step 2 (Move to Next Row): Once 'c == r' (row is complete), print a newline, decrement 'r' to 'r - 1', reset 'c' to 0, and recurse to start the next row.

 Time Complexity: O(r^2) - Total number of prints is equivalent to the sum of the first 'r' natural numbers, resulting in a quadratic relationship similar to nested loops.
 Space Complexity: O(r) - Proportional to the maximum depth of the recursive call stack, equal to the initial number of rows.
 */


public class TrianglePattern {
    public static void main(String[] args) {
        trianglePattern(5,0);
    }
    public static void invertedTriangle(int r, int c){
        if(r < 1)return;
        if(c == r){
            System.out.println();
            invertedTriangle(r-1,0);
        }
        else if(c < r){
            System.out.print("* ");
            invertedTriangle(r,c+1);
        }
    }

    public static void trianglePattern(int r, int c) {
      if(r == 0)return;
      if(c == r){
          trianglePattern(r-1,0);
          System.out.println();
      }
      else if(c < r){
          trianglePattern(r,c+1);
          System.out.print("* ");
      }
    }

}
