public class HFBlindStrategy extends HFStrategy {

    Game.HFAction action;

    public HFBlindStrategy(Game.HFAction action) {
        this.action = action;
    }

    @Override
    Game.HFAction getAction(Game.HLAction hlAction) {
        return action;
    }
}
