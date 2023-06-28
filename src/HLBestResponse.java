public class HLBestResponse extends HLStrategy{

    //returns a best response to pure strategies
    HFStrategy hfStrategy;
    TLStrategy tlStrategy;
    TFStrategy tfStrategy;

    public HLBestResponse(HFStrategy hfStrategy, TLStrategy tlStrategy, TFStrategy tfStrategy) {
        this.hfStrategy = hfStrategy;
        this.tlStrategy = tlStrategy;
        this.tfStrategy = tfStrategy;
    }

    @Override
    Game.HLAction getAction(Game.MNAction mnAction) {
        Game.HLAction hlAction = Game.HLAction.hsignal1;

        if(Game.play(mnAction, new HLBlindStrategy(hlAction), hfStrategy, tlStrategy, tfStrategy)) return hlAction;
        hlAction = Game.HLAction.hsignal2;
        if(Game.play(mnAction, new HLBlindStrategy(hlAction), hfStrategy, tlStrategy, tfStrategy)) return hlAction;
        return Game.HLAction.hsignal3;

    }
}
