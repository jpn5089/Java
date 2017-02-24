import java.util.LinkedList;

class Word implements Comparable<Word> {
  public String word = ""; 
  public LinkedList<Integer> lineNumber = new LinkedList<Integer>(); //create linkedlist for line numbers
  
  public Word() {
  }
  public Word(String s, Integer line) { //constructor that takes a string and a line number integer and adds that line number to the linkedlist 
    word = s;
    lineNumber.add(line);
  }
  public boolean equals(Object el) {
    return word.equals(((Word)el).word);
  }
  public int compareTo(Word el) {
    return word.compareTo(el.word);
  }
  public String toString() {
    return word + " occurs on lines " + lineNumber.toString() + " "; 
  }
}