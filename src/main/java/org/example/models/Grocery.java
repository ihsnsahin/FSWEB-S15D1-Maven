package org.example.models;

import java.util.*;
import java.util.stream.Collectors;

public class Grocery {
   public static List<String> groceryList = new ArrayList<>();
   private static Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
       boolean running = true;
       while (running) {
           System.out.println("Lütfen yapacağınız işlemi tercih ediniz: 0:çıkış, 1: Ürün ekle, 2: Ürün çıkar");
           int number;
           try {
               number = scanner.nextInt();
               scanner.nextLine();
           } catch (InputMismatchException e) {
               System.out.println("Hatalı giriş! Lütfen SADECE rakam giriniz.");
               scanner.nextLine();
               continue;
           }
           switch (number) {
               case 0:
                   System.out.println("Uygulama durduruluyor.");
                   running = false;
                   break;
               case 1:
                   System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                   String itemsToAdd = scanner.nextLine();
                   addItems(itemsToAdd);
                   printSorted();
                   break;
               case 2:
                   System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                   String itemsToRemove = scanner.nextLine();
                   removeItems(itemsToRemove);
                   printSorted();
                   break;
               default:
                   System.out.println("Lütfen geçerli bir rakam tuşlayınız...");
           }
       }
   }
   public static void addItems(String input) {
       String[] items = input.split(",");
       for (String item: items) {
           if (!checkItemIsInList(item.trim())){
               groceryList.add(item.trim());
           }
       }
       Collections.sort(groceryList);
   }
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item: items) {
            if (checkItemIsInList(item.trim())) {
                groceryList.remove(item.trim());
            }
        }
        Collections.sort(groceryList);
    }
    public static boolean checkItemIsInList(String product) {
       return groceryList.contains(product);
    }
    public static void printSorted() {
        Collections.sort(groceryList);
        for (String product: groceryList) {
            System.out.println(product);
        }
    }
}
