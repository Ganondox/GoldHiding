public class HLBlindStrategy extends HLStrategy {

    Game.HLAction action;

    public HLBlindStrategy(Game.HLAction action) {
        this.action = action;
    }

    @Override
    Game.HLAction getAction(Game.MNAction mnAction) {
        return action;
    }
}
