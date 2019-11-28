package ru.oti;

public enum MyFormat {
   NONE("Не установлен"),
   C4("C4"),
   C6("C6"),
   B4("B4"),
   EURO("Евро");

   public String name;

   MyFormat(String s) {
      this.name = s;
   }

   public String getName(){
      return name;
   }

}
