//Name: Raymond Diamonds
//StudentID: 260656751

public class Circle {
  
  public static void main(String[] args) {
    drawCircle(4,10,5,'&');
  }
  
  //method taking 5 inputs to determine whether circle should be drawn @ grid
  public static boolean onCircle(int r, int a, int b, int x, int y){
    
    int lhs = (int) Math.pow(r,2);
    int circle = (int) (Math.pow((x - a),2) + Math.pow((y - b), 2));
    int rhs = (int) (Math.pow(r,2) +1);
    
    return (lhs <= circle) && (circle <= rhs); 
  }
  //method that takes as inputs three ints representing radius & center coordinates to make sure circle is in 1st quadrant and radius is positive
  public static void verifyInput(int r, int a, int b){
    if (r>a || r>b){
      throw new IllegalArgumentException("Circle must fit in upper right quadrant");
    }
    else if (r<=0){
      throw new IllegalArgumentException("Circle must have positive radius");
    }
  }
  /*method that takes as input 3 values for radius & center coordinates & a char 
  to actually call methods and draw out the circle*/
  public static void drawCircle(int r, int a, int b, char c){
    //verify that values are right using verifyInput method
    verifyInput(r,a,b);
    int xDimension = 9;
    if ((a+r)>xDimension){
      xDimension = a+r;
    }
    int yDimension = 9;
    if ((b+r)>yDimension){
      yDimension = b+r;
    }
    System.out.println('^');
    //use for loop to iterate each coordinate from top to bottom
    for(int y=yDimension; y>=0; y--){
      //use nested for loop to iterate each coordinate from left to right
      for(int x=0; x<=xDimension; x++){
        //if statement to give priority to circle over axis
        if(onCircle(r,a,b,x,y) && (x == 0 || y==0)){
          System.out.print(c);
        }
        else if(onCircle(r,a,b,x,y) && (x!=0 && y!=0)){
          System.out.print(c);
        }
        //draw y-axis
        else if(!(onCircle(r,a,b,x,y)) && (x == 0 && y!= 0)){
          System.out.print("|");
        }
        //draw origin 
        else if(!(onCircle(r,a,b,x,y)) && (x == 0 && y== 0)){
          System.out.print("+");
        }
        //draw x-axis
        else if(!(onCircle(r,a,b,x,y)) && y == 0){
          System.out.print('-'); 
        }
        //draw spaces in between the circle symbol
        else{
          System.out.print(" ");
        }
      }
      if(y==0){
        System.out.print('>');
      }
      System.out.println();
    } 
  } 
}
