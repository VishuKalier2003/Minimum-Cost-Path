/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path... Note: You can only move either down or right at any point in time...
 * Eg 1: grid = [[1,3,1],[1,5,1],[4,2,1]]           Output = 7 => 1+3+1+1+1 = 7
 * Eg 2: grid = [[1,2,3],[4,5,6]]                   Output = 12 => 1+2+3+6 = 12
 */
import java.util.*;
public class Minimum
{
    public int MinimumCost(int grid[][])
    {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];     // Setting the first grid element as the starting point...
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(i == 0 && j == 0)    // For first grid element we pass...
                    continue;
                int Max = 100000, Min = 0;
                if(i > 0)
                    Max = dp[i-1][j];    // Updating the max value...
                if(j > 0)
                    Min = dp[i][j-1];    // Updating the min value...
                dp[i][j] = grid[i][j] + Math.min(Max, Min);    // Adding the minimum cost value to the current indices in DP Array with respect to the current grid indices...
            }
        }
        return dp[grid.length-1][grid[0].length-1];    // returning the last grid element...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.print("Enter the number of rows (n) : ");
        n = sc.nextInt();
        System.out.print("Enter the number of columns (m) : ");
        m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print("Enter data of "+(i+1)+" row and "+(j+1)+" column : ");
                matrix[i][j] = sc.nextInt();
            }
        }
        Minimum minimum = new Minimum();    // object creation...
        System.out.println("The Minimum cost path is : "+minimum.MinimumCost(matrix));
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(n^2) space...

/* DEDUCTIONS :- 
 * 1. For every block found we evaluate the minimum path till that point using Dynamic Programming matrix, at the end the Dynamic Programming matrix gives the least distance to reach the end node...
 * 2. The least distance gets stored at the end indices of the Dynamic Programming matrix...
*/