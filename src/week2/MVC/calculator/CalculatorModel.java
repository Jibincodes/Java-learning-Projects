package week2.MVC.calculator;



public class CalculatorModel {
 public String calculate(String str)  {
	 boolean error = false;
	 String result;
	 String[] strValues = str.split("[\\+-]");
	 String part1 = strValues[0];
	 long num1 = Long.parseLong(part1);
	 
	 String part2 = strValues[1];
	 long num2 = Long.parseLong(part2);
	 if (str.contains("+")){
		 long sum = 0;
		 sum = num1+num2;
		 result = Long.toString(sum);
		 
	 }else {
		 long sub =0;
		 sub = num1-num2;
		 result = Long.toString(sub);
		 
	 }
	 return result;
	
	 
	 
}
}