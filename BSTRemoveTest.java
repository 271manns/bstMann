// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class BSTRemoveTest {
   private static boolean failed = false;
   private static String str;
   private static BSTInterface<String> tree;
   private static String[] test = new String[7];

   public BSTRemoveTest() {
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
         System.out.println("Now adding the letters D B A C F E G to the tree");

         try {
            tree.add("D");
            tree.add("B");
            tree.add("A");
            tree.add("C");
            tree.add("F");
            tree.add("E");
            tree.add("G");
         } catch (NoSuchMethodError var4) {
            failure("Failed: missing add(T element) method");
         }
      }

      if (!failed) {
         String[] test = new String[]{"| | G\n| F\n| | E\nD\n| | C\n| B\n", "| | G\n| F\n| | E\nD\n| C\n", "| | G\n| F\n| | E\nD\n", "| G\nF\n| E\n", "| G\nF\n", "G\n", ""};
         System.out.println("Now testing BST Remove method on the following tree:");
         System.out.println(tree);
         int i = 0;

         for(char ch = 'A'; ch <= 'G'; ++ch) {
            System.out.println("Now removing: " + ch);
            tree.remove("" + ch);
            System.out.println(tree);
            if (!test[i].equals(tree.toString())) {
               System.out.println("Incorrect removal of " + ch);
               System.out.println("tree should now look like:\n" + test[i]);
               failed = true;
               break;
            }

            System.out.println("Correct removal of " + ch);
            ++i;
         }
      }

      if (failed) {
         System.out.println("\n\nBummer, try again");
      }

      if (!failed) {
         System.out.println("\n\nCongratulations, your BST Remove test was successful");
      }

   }

   private static void failure(String str) {
      System.out.println("*** " + str);
      failed = true;
   }
}
