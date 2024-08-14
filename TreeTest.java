//  Name: Josue Gonzalez-Silva
//  Date: 8/10/24
//  Class CS 145
//  Assignment: Printing Trees
//  Purpose: To demonstrate the functionality of a binary tree

import java.security.SecureRandom;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Person> tree = new Tree<>();
        SecureRandom randomNumber = new SecureRandom();

        String[] names = {"Alice", "Rob", "Charles", "Dian", "Evan", "Francisco", "Grace", "Hannah", "Rodri"};
        int[] ages = {22, 31, 33, 42, 47, 50, 54, 63, 67};

        System.out.println("Inserting the following persons:");
        for (int i = 0; i < 10; i++) {
            int index = randomNumber.nextInt(names.length);
            Person person = new Person(names[index], ages[index]);
            System.out.printf("%s ", person);
            tree.insertNode(person);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();

        System.out.printf("%n%nTree structure:%n");
        tree.outputTree();
    }
}
