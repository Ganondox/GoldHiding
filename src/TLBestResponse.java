public class TLBestResponse extends TLStrategy{

    //only needs TF because it has perfect information about everything else from observation
    TFStrategy tfStrategy;


    public TLBestResponse(TFStrategy tfStrategy) {
        this.tfStrategy = tfStrategy;
    }

    @Override
    Game.TLAction getAction(Game.MNAction mnAction, Game.HLAction hlAction, Game.HFAction hfAction) {
        Game.TLAction tlAction = Game.TLAction.tsignal1;
        if(!Game.play(mnAction,new HLBlindStrategy(hlAction), new HFBlindStrategy(hfAction), new TLBlindStrategy(tlAction), tfStrategy)) return tlAction;
        return Game.TLAction.tsignal2;
    }
}
