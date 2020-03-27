/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
  int month;
  int day;
  int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
    this.month = month;
    this.day = day;
    this.year = year;
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
    String[] date = s.split("/");
    String m = date[0];
    //System.out.println(m);
    this.month = Integer.parseInt(m);
    String d = date[1];
    //System.out.println(d);
    this.day = Integer.parseInt(d);
    String y = date[2];
    //System.out.println(y);
    this.year = Integer.parseInt(y);
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    if(year % 400 == 0){
      return true;
    }else if(year % 4 == 0 && (year % 100 != 0)){
      return true; 
    }else{
      return false;
    }                   // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    if(Date.isLeapYear(year) == true){
      switch(month){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12: return 31;
        case 2: return 29;
        case 4:
        case 6:
        case 9:
        case 11: return 30;
      }
    }else{
        switch(month){
          case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12: return 31;
        case 2: return 28;
        case 4:
        case 6:
        case 9:
        case 11: return 30;
        }
      }
      return 0;                         // replace this line with your solution
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    if(year < 1 || month < 1 ||month > 12 || day < 1 || day > 31){
      return false;
    }else {
      int i = Date.daysInMonth(month, year);
      if(day > i){
        return false;
      }else{
        return true;
      }
    }          // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    String a = month + "/" + day + "/" + year;
    return a;                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    if(this.year > d.year){
      return false;
    }else if(this.year < d.year){
      return true;
    }else {
      if(this.month > d.month){
        return false;
      }else if(this.month < d.month){
        return true;
      }else{
        if(this.day >= d.day){
          return false;
        }else {
          return true;
        }
      }
    }         // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    if(this.year < d.year){
      return false;
    }else if(this.year > d.year){
      return true;
    }else {
      if(this.month < d.month){
        return false;
      }else if(this.month > d.month){
        return true;
      }else{
        if(this.day <= d.day){
          return false;
        }else {
          return true;
        }
      }
    }                       // replace this line with your solution
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    if(Date.isLeapYear(this.year) == true) {
      switch(month){
        case 1: return day;
        case 2: return (31+day);
        case 3: return (31+29+day);
        case 4: return (31+29+31+day);
        case 5: return (91+30+day);
        case 6: return (121+31+day);
        case 7: return (152+30+day);
        case 8: return (182+31+day);
        case 9: return (213+31+day);
        case 10: return (244+30+day);
        case 11: return (274+31+day);
        case 12: return (305+30+day);
      }
    }else{
      switch(month){
        case 1: return day;
        case 2: return (31+day);
        case 3: return (31+28+day);
        case 4: return (31+28+31+day);
        case 5: return (90+30+day);
        case 6: return (120+31+day);
        case 7: return (151+30+day);
        case 8: return (181+31+day);
        case 9: return (212+31+day);
        case 10: return (243+30+day);
        case 11: return (273+31+day);
        case 12: return (304+30+day);
      }
    }
    return 0;                         // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
      int dyear;
      int tyear;
      if(Date.isLeapYear(d.year)){
        dyear = 366;
      }else{
        dyear = 365;
      }
      if(Date.isLeapYear(this.year)){
        tyear = 366;
      }else{
        tyear = 365;
      }
      int i = this.dayInYear();
      int j = d.dayInYear();
       
      if(this.year > d.year){
        int yy = d.year+1;
        int dif = dyear - j;
        while(yy<this.year){
          int a;
          if(Date.isLeapYear(yy)){
            a = 366;
          }else{
            a = 365;
          }
          dif = dif + a;
          yy++;
        }
        return dif+i;
      }else if (this.year < d.year){
        int yy = this.year +1;
        int dif = tyear - i;
        while(yy < d.year){
          int a;
          if(Date.isLeapYear(yy)){
            a = 366;
          }else{
            a = 365;
          }
          dif = dif + a;
          yy++;
        }
        return -(dif + j);
      }else{
        int tday = this.dayInYear();
        int dday = d.dayInYear();
        return tday-dday;
      }
                                 // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
