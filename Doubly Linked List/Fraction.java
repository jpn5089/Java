class Fraction {    
  
  int num;
  int den;
  
  public Fraction(int num, int den){
    this.num = num;
    this.den = den;
  }
  
  public Fraction() {
    this.num = 0;
    this.den = 1;
  }
  
  public String toString(){
    return num + "/" + den;
  }
}