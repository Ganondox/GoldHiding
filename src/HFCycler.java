public class HFCycler extends HFStrategy{

    //picking this strategy because it affects all pots, and thus might
    @Override
    Game.HFAction getAction(Game.HLAction hlAction) {
        switch (hlAction){
            case hsignal1:
                return Game.HFAction.cycleRight;
            case hsignal2:
                return Game.HFAction.cycleLeft;
            case hsignal3:
                return Game.HFAction.identity;
        }
        return Game.HFAction.identity;
    }
}
