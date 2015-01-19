public class CircularGamesIterator implements Iterator<Game> {

 private Vector<Game> list;
 private int currentPosition;
 
 public CircularGamesIterator(Vector<Game> games) {
  list = games;
  currentPosition = 0;
 }
 
 @Override
 public boolean hasNext() {
  return currentPosition < list.size();
 }

 @Override
 public Game next() {
  Game el = list.elementAt(currentPosition);
  currentPosition = (currentPosition + 1) % list.size(); 
  return el;
 }

 @Override
 public void remove() { }
}
---------------------------------------------------------------------------------- 
 调用时：
 
 public class GameCollection implements Iterable<Game> {
 private Vector<Game> games;
 
 public GameCollection() {
  games = new Vector<Game>();
 }
 
 public void add(Game game) {
  games.add(game);
 }

 @Override
 public Iterator<Game> iterator() {
  return new CircularGamesIterator(games);
 }
}
