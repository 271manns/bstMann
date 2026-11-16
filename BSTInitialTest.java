// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.List;

public class BSTInitialTest {
   private static boolean failed = false;
   private static String str;
   private static BSTInterface<String> tree;
   private static List<String> list;

   public BSTInitialTest() {
   }

   public static void main(String[] args) {
      System.out.println("Now testing your BinarySearchTree class: \n");

      try {
         tree = new BinarySearchTree();
      } catch (NoClassDefFoundError var5) {
         failure("Epic Failure: missing BinarySearchTree class");
      } catch (NoSuchMethodError var6) {
         failure("Failed: missing constructor BinarySearchTree<T>()");
      }

      if (!failed && !(tree instanceof BSTInterface)) {
         failure("Failed: BinarySearchTree does not implement BSTInterface");
      }

      if (!failed) {
         System.out.println("This tester class checks the isEmpty(), size(),");
         System.out.println("     add(T element), and contains(T element) methods\n");

         try {
            if (!tree.isEmpty()) {
               failure("Failed: incorrect isEmpty() method");
            }
         } catch (NoSuchMethodError var4) {
            failure("Failed: missing isEmpty() method");
         }
      }

      if (!failed) {
         System.out.println("Now adding the letters D B A C F E G to the tree");

         try {
            tree.add("D");
            tree.add("B");
            tree.add("A");
            tree.add("C");
            tree.add("F");
            tree.add("E");
            tree.add("G");
         } catch (NoSuchMethodError var3) {
            failure("Failed: missing add(T element) method");
         }
      }

      if (!failed && tree.isEmpty()) {
         failure("Failed: incorrect add(T element) and/or isEmpty() method");
      }

      if (!failed) {
         try {
            if (tree.size() != 7) {
               failure("Failed: size method reports that there are " + tree.size() + " nodes");
            }
         } catch (NoSuchMethodError var2) {
            failure("Failed: missing size() method");
         }
      }

      if (!failed) {
         String test = "| | G\n| F\n| | E\nD\n| | C\n| B\n| | A\n";
         System.out.println("\nTree diagram (sideways):\n" + tree);
         if (!test.equals(tree.toString())) {
            failure("Correct tree diagram:\n" + test);
         }
      }

      if (!failed) {
         try {
            if (!tree.contains("A") || !tree.contains("B") || !tree.contains("C") || !tree.contains("D") || !tree.contains("E") || !tree.contains("F") || !tree.contains("G") || tree.contains("H")) {
               failure("Failed: incorrect contains(T element) method");
            }
         } catch (NoSuchMethodError var7) {
            failure("Failed: missing contains(T element) method");
         }
      }

      if (failed) {
         System.out.println("\n\nBummer, try again");
      }

      if (!failed) {
         System.out.println("\n\nCongratulations, your BST Initial test was successful");
      }

   }

   private static void failure(String str) {
      System.out.println("*** " + str);
      failed = true;
   }
}
