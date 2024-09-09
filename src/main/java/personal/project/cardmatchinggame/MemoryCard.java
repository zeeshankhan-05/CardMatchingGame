package personal.project.cardmatchinggame;

public class MemoryCard extends Card {
    private boolean matched;

    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false; // Game just started, so no pairs made
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * Returns true if 2 cards have the same suit and face names (match made)
     */
    public boolean isSameCard(MemoryCard otherCard) {
        return (this.getSuit().equals(otherCard.getSuit()) && (this.getFaceName().equals(otherCard.getFaceName())));
    }
}
