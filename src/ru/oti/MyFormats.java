package ru.oti;

public enum MyFormats {

   C4("C4 (229 × 324 мм)"),
   C6("C6 (114 х 162 мм)"),
   B4("B4 (250 x 353мм)"),
   EURO("Евро (110 х 220 мм)"),

   RECTANGULAR_PACKAGING("Прямоугольная упаковка"),
   ROLL("Рулон");

   public String name;

   MyFormats(String s) {
      this.name = s;
   }

   public String getName(){
      return name;
   }

}
