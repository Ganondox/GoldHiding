public class TLBlindStrategy extends  TLStrategy{

    Game.TLAction action;

    public TLBlindStrategy(Game.TLAction action) {
        this.action = action;
    }

    @Override
    Game.TLAction getAction(Game.MNAction mnAction, Game.HLAction hlAction, Game.HFAction hfAction) {
        return action;
    }
}

