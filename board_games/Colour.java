package board_games;

public enum Colour {
  RED,
  GREEN,
  YELLOW,
  BLUE;

  public Colour opponent() {
    if (this == RED) {
      return GREEN;
    } else if (this == GREEN) {
      return YELLOW;
    } else {
      return BLUE;
    }
  }
}
