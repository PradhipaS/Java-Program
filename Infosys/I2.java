// 1. Monster Defeat Sequence
// Problem Statement
// You are given N monsters, where each monster requires a certain amount of experience points to defeat. Once defeated, the monster rewards you with additional experience points.

// Initially, you have X experience points. Determine whether it is possible to defeat all monsters by choosing an appropriate order.

// Example
// Input:

// Initial Experience = 10

// Monster Details:
// Power  Bonus
// 5         4
// 15        10
// 8         3
// Output:

// YES

import java.util.*;

public class I2 {
    // Class to represent a Monster
    static class Monster implements Comparable<Monster> {
        int power;
        int bonus;

        Monster(int power, int bonus) {
            this.power = power;
            this.bonus = bonus;
        }

        // Sort monsters based on their required power in ascending order
        @Override
        public int compareTo(Monster other) {
            return Integer.compare(this.power, other.power);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read total number of monsters
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // Read initial experience points (X)
        int currentExperience = sc.nextInt();

        Monster[] monsters = new Monster[n];
        
        // Read Monster Powers
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = sc.nextInt();
        }

        // Read Monster Bonuses
        int[] bonuses = new int[n];
        for (int i = 0; i < n; i++) {
            bonuses[i] = sc.nextInt();
        }

        // Combine powers and bonuses into Monster objects
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster(powers[i], bonuses[i]);
        }

        // Sort monsters by required power
        Arrays.sort(monsters);

        boolean possible = true;
        for (int i = 0; i < n; i++) {
            // Check if current experience is enough to defeat the monster
            if (currentExperience >= monsters[i].power) {
                currentExperience += monsters[i].bonus;
            } else {
                possible = false;
                break;
            }
        }

        // Output result based on verification flag
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
